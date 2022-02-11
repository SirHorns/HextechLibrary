package hextechlibrary.callables;

import hextechlibrary.LeakyBucket;
import hextechlibrary.api.LeagueOfLegendsAPI;
import hextechlibrary.dto.lol.SummonerDto;
import hextechlibrary.dto.lol.match.MatchDto;
import hextechlibrary.dto.lol.match.ParticipantDto;
import hextechlibrary.objects.lol.CareerStatInfo;
import org.apache.commons.math3.util.Precision;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CareerStats implements Callable<CareerStatInfo> {

    private Thread t;
    private final String threadName;
    private final LeagueOfLegendsAPI api;
    private final int numberGamesToPull;
    private final String summonerName;
    private final CareerStatInfo playerStats;
    private final Logger logger = LogManager.getLogger(this.getClass().getName());
    private final LeakyBucket leakyBucket =  new LeakyBucket(20,1);
    private final int queueID;


    /**
     *
     * @param api The API Manager for League of Legends.
     * @param summonerName The name of the Summoner to be looked up.
     * @param numOfGames The number of days to look back on for match info.
     */
    public CareerStats(LeagueOfLegendsAPI api, String queue,String summonerName,int numOfGames) {
        this.api = api;
        this.summonerName = summonerName;
        this.playerStats = new CareerStatInfo(summonerName);
        this.numberGamesToPull = numOfGames;
        this.threadName = summonerName + "-CareerStats";
        this.queueID = HandleQueueID(queue);
    }

    public void start () {
        logger.info("Starting " +  threadName);
        if (t == null) {
            t = new Thread (this::start,threadName);
            t.start ();
        }
    }

    LocalDateTime endTime;
    LocalDateTime startTime;
    int queryPeriod;
    ZoneOffset zoneOffSet;
    private void HandleTimeInfo() {
        //GETTING EPOCH TIME PERIOD INFO
        //startTime is in the past while endTime is close to the present.
        endTime = LocalDateTime.now();
        queryPeriod = 30;
        startTime = endTime.minusDays(queryPeriod);
        ZoneId zone = ZoneId.of("America/Chicago");
        zoneOffSet = zone.getRules().getOffset(startTime);
    }

    SummonerDto playerInfo;
    private void HandleMatchIDs() {
        apiMatchIDs();
        List<MatchDto> matchList= apiMatchInfo();

        //Parsing through the matchID list to find the Participant of the player and storing that in a List for later use.
        List<ParticipantDto> playerMatchInfoList = new ArrayList<>();
        for (MatchDto match : matchList) {
            if (match != null) {
                for (ParticipantDto participant : match.getInfo().getParticipants()) {
                    if (playerInfo.getPuuid().equals(participant.getPuuid())) {
                        playerMatchInfoList.add(participant);
                    }
                }
            }
        }

        playerStats.setPlayerMatchInfoList(playerMatchInfoList);
    }
    private List<String> apiMatchIDs(){
        List<String> apiMatchIDs = new ArrayList<>();
        int requests = 1;
        //This code requests 100 matchIDs from the League API
        while(requests == 1){
            if(leakyBucket.tryConsume())
            {
                apiMatchIDs = api.getMatchesByPUUID(
                        playerInfo.getPuuid(),
                        startTime.toEpochSecond(zoneOffSet),
                        endTime.toEpochSecond(zoneOffSet), queueID, "", 0, numberGamesToPull);

                playerStats.setMatchIDList(apiMatchIDs);
                requests--;
            }
        }
        return apiMatchIDs;
    }
    private List<MatchDto> apiMatchInfo(){
        int requests;
        //Queery API for Match INFO
        List<MatchDto> matchList = new ArrayList<>();
        for (String id : playerStats.getMatchIDList()) {
            requests = 1;
            while(requests == 1){
                if(leakyBucket.tryConsume())
                {
                    matchList.add(api.getMatchByMatchID(id));
                    requests--;
                }
            }
        }
        playerStats.setMatchInfoList(matchList);
        return matchList;
    }

    //Hash Maps for storing ChampPick K/D/A info
    Map<String, Integer> champWins = new HashMap<>();
    Map<String, Integer> champLoses = new HashMap<>();
    Map<String, Double> champKDA = new HashMap<>();
    Map<String,CareerStatInfo.ChampPick> mapChampPick = new HashMap<>();
    List<CareerStatInfo.ChampPick> championPickList = new ArrayList<>();

    //sets Champion Pick Info.
    private void HandleMatchInfo() {
        //Get Champs & Wins/loses
        List<String> championNames = new ArrayList<>();
        for (ParticipantDto player:playerStats.getPlayerMatchInfoList()) {
            CareerStatInfo.ChampPick temporaryChampionPick = new CareerStatInfo.ChampPick();
            String championName = player.getChampionName();
            temporaryChampionPick.setName(championName);
            boolean newEntry;

            if (mapChampPick.containsKey(championName)){
                temporaryChampionPick = mapChampPick.get(championName);
                temporaryChampionPick.setPickCount(temporaryChampionPick.getPickCount() + 1);
                newEntry = false;
            }else{
                championNames.add(championName);
                temporaryChampionPick.setPickCount(1);
                newEntry = true;
            }

            // if the player has never won or lose with the champ.
            if(player.getWin()) {
                temporaryChampionPick.setWins(temporaryChampionPick.getWins() + 1);
                playerStats.setPlayerWins(playerStats.getPlayerWins() + 1);
            }else{
                temporaryChampionPick.setLoses(temporaryChampionPick.getLoses() + 1);
                playerStats.setPlayerLoses(playerStats.getPlayerLoses() + 1);
            }

            temporaryChampionPick.setPickRate(calculatePickRate(temporaryChampionPick.getPickCount(),numberGamesToPull));
            temporaryChampionPick.setKills(temporaryChampionPick.getKills() + player.getKills());
            temporaryChampionPick.setDeaths(temporaryChampionPick.getDeaths() + player.getDeaths());
            temporaryChampionPick.setAssists(temporaryChampionPick.getAssists() + player.getAssists());

            //Increment player total scoring
            playerStats.setTotalKills(playerStats.getTotalKills() + player.getKills());
            playerStats.setTotalDeaths(playerStats.getTotalDeaths() + player.getDeaths());
            playerStats.setTotalAssists(playerStats.getTotalAssists() + player.getAssists());

            //Calculate match Champ KDA.

            if(newEntry){
                mapChampPick.put(championName, temporaryChampionPick);
            }
            else{
                mapChampPick.replace(championName, temporaryChampionPick);
            }
        }

        for (String champion: championNames) {
            CareerStatInfo.ChampPick pick = HandleCalculateRatios(mapChampPick.get(champion));
            championPickList.add(pick);
            mapChampPick.replace(champion, pick);
        }


        playerStats.setChampionPickInfoList(championPickList);
        playerStats.setChampionList(championNames);
    }
    CareerStatInfo.ChampPick HandleCalculateRatios(CareerStatInfo.ChampPick pick){
        double wr = calculateWinRate(pick.getWins(), pick.getLoses());
        double kda = calculateKDA(pick.getKills(),pick.getDeaths(),pick.getAssists());
        double kdr = calculateKDR(pick.getKills(),pick.getDeaths());
        double df = calculateDF(pick.getKills(),pick.getDeaths(),pick.getAssists());
        double dr = calculateDR(pick.getKills(),pick.getDeaths(),pick.getAssists());

        pick.setWinRate(wr);
        pick.setKillDeathAssistRatio(kda);
        pick.setKillDeathRatio(kdr);
        pick.setDominanceFactor(df);
        pick.setDominanceRatio(dr);

        return pick;
    }

    //PARSING THOUGH THE TOP FIVE CHAMP LIST
    List<String> topFivePicks = new ArrayList<>(5);
    List<Integer> topFivePickCounts = new ArrayList<>(5);
    List<Double> topFivePickRates = new ArrayList<>(5);
    List<Double> topFiveWinRates = new ArrayList<>(5);
    private void HandleTopFive() {
        Map<String, Long> group = new HashMap<>();
        for (CareerStatInfo.ChampPick pick: playerStats.getChampionPickInfoList()) {
            group.put(pick.getName(), (long) pick.getPickCount());
        }
        //Getting Top Five Champion pick Info
        group.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5) // here you can use a variable for the number of the top object you want
                .forEach(entry ->{
                    String champ = entry.getKey();
                    //Pick & Count
                    topFivePicks.add(champ);
                    topFivePickCounts.add(entry.getValue().intValue());

                    topFivePickRates.add(mapChampPick.get(entry.getKey()).getPickRate());

                    //Win Rate
                    int wins = mapChampPick.get(entry.getKey()).getWins();
                    int loses = mapChampPick.get(entry.getKey()).getLoses();

                    double winRate =  calculateWinRate(wins,loses);
                    topFiveWinRates.add(winRate);
                });
    }

    private void SetTopFiveChamps(){
        //SETTING TOP FIVE CHAMPS
        int index = 0;
        List<CareerStatInfo.ChampPick> topFiveChampList = new ArrayList<>();
        for (String champ:topFivePicks) {
            CareerStatInfo.ChampPick champPick = new CareerStatInfo.ChampPick();
            champPick.setName(champ);
            champPick.setPickCount(topFivePickCounts.get(index));
            champPick.setPickRatio(topFivePickRates.get(index));
            champPick.setWinRate(topFiveWinRates.get(index));
            champPick.setWins(champWins.get(champ));
            champPick.setLoses(champLoses.get(champ));
            topFiveChampList.add(champPick);
            index++;
        }
        playerStats.setMostPlayedList(topFiveChampList);
    }

    private void HandleWLPRates(Map<String, Long> group){
        //Handling Champ Win/Lose/Pick info
        List<String> championNameList = new ArrayList<>();
        List<CareerStatInfo.ChampPick> champList = new ArrayList<>();
        group.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry ->{
                    //Pick Rate
                    double pickRate = calculatePickRate(entry.getValue().intValue(), playerStats.getChampionList().size());
                    pickRate = Precision.round(pickRate, 1);

                    //Win Rate
                    int wins;
                    int loses;
                    if (champWins.get(entry.getKey()) != null){
                        wins = champWins.get(entry.getKey());
                    }else{
                        wins = 0;
                    }
                    if (champLoses.get(entry.getKey()) != null){
                        loses = champLoses.get(entry.getKey());
                    }else{
                        loses = 0;
                    }

                    double winRate = calculateWinRate(wins,loses);
                    winRate = Precision.round(winRate,1);

                    //Setting Info
                    CareerStatInfo.ChampPick champPick = new CareerStatInfo.ChampPick();
                    champPick.setName(entry.getKey());
                    champPick.setPickCount(entry.getValue().intValue());
                    champPick.setPickRatio(pickRate);
                    champPick.setWinRate(winRate);
                    champPick.setWins(champWins.get(entry.getKey()));
                    champPick.setLoses(champLoses.get(entry.getKey()));
                    champPick.setKillDeathAssistRatio(Precision.round(champKDA.get(entry.getKey()),1));
                    champList.add(champPick);
                    championNameList.add(entry.getKey());
                });

        playerStats.setChampionPickInfoList(champList);
        playerStats.setChampionList(championNameList);
    }

    private void HandleChampsKDA(){
        //Setting the Highest & Lowest KDA Champs
        List<CareerStatInfo.ChampPick> highestKDAList = new ArrayList<>();
        List<CareerStatInfo.ChampPick> lowestKDAList = new ArrayList<>();

        Map<String, Double> kdaMap = new HashMap<>();
        for (CareerStatInfo.ChampPick pick:playerStats.getChampionPickInfoList()) {
            kdaMap.put(pick.getName(),pick.getKillDeathAssistRatio());
        }


        //HIGHEST KDA
        kdaMap.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5) // here you can use a variable for the number of the top object you want
                .forEach(entry ->{
                    for (CareerStatInfo.ChampPick pick:playerStats.getChampionPickInfoList()) {
                        if(pick.getName().equals(entry.getKey())){
                            highestKDAList.add(pick);
                        }
                    }
                });

        playerStats.setHighestKDAList(highestKDAList);

        //LOWEST KDA
        kdaMap.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed().reversed())
                .limit(5) // here you can use a variable for the number of the top object you want
                .forEach(entry ->{
                    for (CareerStatInfo.ChampPick pick:playerStats.getChampionPickInfoList()) {
                        if(pick.getName().equals(entry.getKey())){
                            lowestKDAList.add(pick);
                        }
                    }
                });
        playerStats.setLowestKDAList(lowestKDAList);
    }

    @Override
    public CareerStatInfo call() throws Exception {
        logger.info("Running Thread: [" +  threadName + "]");

        int requests = 1;
        while(requests == 1){
            if(leakyBucket.tryConsume())
            {
                playerInfo = api.getSummonerByName(summonerName);
                requests--;
            }
        }

        HandleTimeInfo();
        HandleMatchIDs();
        HandleMatchInfo();
        Map<String, Long> group =
                playerStats.getChampionList().stream()
                        .collect(
                                Collectors.groupingBy(
                                        Function.identity(),
                                        Collectors.counting()
                                )
                        );
        HandleTopFive();
        //HandleWLPRates(group);
        //SetTopFiveChamps();
        //HandleChampsKDA();

        /*
        Things to figure out how to add:
        Player Main Role/Lane
        Champ Role/Lane
        */

        logger.info("Exiting Thread [" +  threadName + "]");
        return playerStats;
    }

    //HELPER METHODS
    private Double calculatePickRate(int picks, int totalPicks){
        double pr = (double) picks / totalPicks;
        //Precision.round(pr,1);
        return pr;
    }
    private Double calculateWinRate(int wins, int loses){
        double wr = (double) wins / (wins + loses);
        //Precision.round(wr,1);
        return wr;
    }
    private Double calculateKDA(int kills, int deaths, int assists){
        double kda = (double) (kills + assists) / Math.max(deaths, 1);
        //Precision.round(kda,1);
        return kda;
    }
    private Double calculateKDR(int kills, int deaths){
        double kdr = (double) kills / Math.max(deaths, 1);
        //Precision.round(kdr,1);
        return kdr;
    }
    private int calculateDF(int kills, int deaths, int assists){
        return ((2 * kills) + assists) - (2 * deaths);
    }
    private Double calculateDR(double kills, double deaths, double assists){
        double dr = ((2 * kills) + assists) / (2 * deaths);
        //Precision.round(dr,1);
        return dr;
    }

    private int HandleQueueID(String id){
        id = id.toLowerCase(Locale.ROOT);
        int qID = 0;

        switch (id) {
            case "aram" -> qID = 100;
            case "draft" -> qID = 400;
            case "solo" -> qID = 420;
            case "blind" -> qID = 430;
            case "flex" -> qID = 440;
            case "clash" -> qID = 700;
            case "arurf" -> qID = 900;
            case "urf" -> qID = 1900;
            default -> {
                qID = 400;
            }
        }
        return qID;
    }
}
