package hextechlibrary.callables;

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
    private final int tmpGamesToPull;
    String summonerName;
    private final Logger logger = LogManager.getLogger(this.getClass().getName());

    /**
     *
     * @param api The API Manager for League of Legends.
     * @param summonerName The name of the Summoner to be looked up.
     * @param numOfGames The number of days to look back on for match info.
     */
    public CareerStats(LeagueOfLegendsAPI api, String summonerName,int numOfGames) {
        this.api = api;
        this.summonerName = summonerName;
        this.tmpGamesToPull = numOfGames;
        this.threadName = summonerName + "-CareerStats";
    }

    public void start () {
        logger.info("Starting " +  threadName);
        if (t == null) {
            t = new Thread (this::start,threadName);
            t.start ();
        }
    }

    @Override
    public CareerStatInfo call() throws Exception {

        logger.info("Running Thread: [" +  threadName + "]");

        CareerStatInfo playerStats = new CareerStatInfo(summonerName);
        SummonerDto summoner = api.getSummonerByName(summonerName);
        String puuid = summoner.getPuuid();

        //GETTING EPOCH TIME PERIOD INFO
        //startTime is in the past while endTime is close to the present.
        LocalDateTime endTime = LocalDateTime.now();
        int queryPeriod = 30;
        LocalDateTime startTime = endTime.minusDays(queryPeriod);
        ZoneId zone = ZoneId.of("America/Chicago");
        ZoneOffset zoneOffSet = zone.getRules().getOffset(startTime);

        //This code requests 100 matchIDs from the League API
        List<String> matchIDs = api.getMatchesByPUUID(puuid, startTime.toEpochSecond(zoneOffSet), endTime.toEpochSecond(zoneOffSet), 400, "normal", 0, tmpGamesToPull);
        List<MatchDto> matchList = new ArrayList<>();
        for (String id : matchIDs) {
            matchList.add(api.getMatchByMatchID(id));
        }
        //Storing matchIDS and match count in CareerStatsInfo object
        playerStats.setMatchIDList(matchIDs);

        //Parsing through the matchID list to find the Participant of the player and storing that in a List for later use.
        List<ParticipantDto> playerMatchInfoList = new ArrayList<>();
        for (MatchDto match : matchList) {
            if (match != null) {
                for (ParticipantDto part : match.getInfo().getParticipants()) {
                    if (puuid.equals(part.getPuuid())) {
                        playerMatchInfoList.add(part);
                    }
                }
            }
        }

        //Total Career K/D/A count
        int totalKills = 0;
        int totalDeaths = 0;
        int totalAssists = 0;

        //Hash Maps for storing ChampPick K/D/A info
        Map<String, Integer> champWins = new HashMap<>();
        Map<String, Integer> champLoses = new HashMap<>();
        Map<String, Double> champKDA = new HashMap<>();

        //Get Champs & Wins/loses
        List<String> championNameList = new ArrayList<>();
        for (ParticipantDto player:playerMatchInfoList) {
            championNameList.add(player.getChampionName());

            String champName = player.getChampionName();
            Integer num;

            //set win/lose info
            //Makes sure to put a 0 entry for a champ in the other list[Win/Lose]
            // if the player has never won or lose with the champ.
            if(player.getWin()) {
                num = champWins.get(champName);
                champWins.put(player.getChampionName(),(num == null) ? 1 : num + 1);
                champLoses.putIfAbsent(player.getChampionName(), 0);
            }else{
                num = champLoses.get(champName);
                champLoses.put(player.getChampionName(),(num == null) ? 1 : num + 1);
                champWins.putIfAbsent(player.getChampionName(), 0);
            }

            //Increment player total scoring
            totalKills += player.getKills();
            totalDeaths += player.getDeaths();
            totalAssists += player.getAssists();

            //Calculate match Champ KDA.
            double kda = calculateKDA(player.getKills(),player.getDeaths(),player.getAssists());
            double newKda;
            champKDA.putIfAbsent(player.getChampionName(),kda);
            if (champKDA.get(player.getChampionName()) != null){
                newKda = kda + champKDA.get(player.getChampionName());
                champKDA.replace(player.getChampionName(),champKDA.get(player.getChampionName()),newKda);
            }
        }

        //Setting TotalScores
        playerStats.setTotalKills(totalKills);
        playerStats.setTotalDeaths(totalDeaths);
        playerStats.setTotalAssists(totalAssists);

        //PARSING THOUGH THE TOP FIVE CHAMP LIST
        List<String> topFivePicks = new ArrayList<>(5);
        List<Integer> topFivePickCounts = new ArrayList<>(5);
        List<Double> topFivePickRates = new ArrayList<>(5);
        List<Double> topFiveWinRates = new ArrayList<>(5);

        Map<String, Long> group = championNameList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //Getting Top Five Champion pick Info
        group.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5) // here you can use a variable for the number of the top object you want
                .forEach(entry ->{
                    String champ = entry.getKey();
                    //Pick & Count
                    topFivePicks.add(champ);
                    topFivePickCounts.add(entry.getValue().intValue());

                    //Pick Rate
                    double pr = calculatePickRate(entry.getValue().intValue(), championNameList.size());
                    topFivePickRates.add(pr);

                    //Win Rate
                    int wins;
                    int loses;
                    if (champWins.get(champ) != null){
                        wins = champWins.get(champ);
                    }else{
                        wins = 0;
                    }
                    if (champLoses.get(champ) != null){
                        loses = champLoses.get(champ);
                    }else{
                        loses = 0;
                    }

                    double wr =  calculateWinRate(wins,loses);
                    topFiveWinRates.add(wr);
                });

        //Getting All Champion pick Info
        int champPoolSize = championNameList.size();
        championNameList.clear(); //Clearing so it can be filled with a list of only champion names occurring once.
        List<CareerStatInfo.ChampPick> champList = new ArrayList<>();
        group.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry ->{
                    //Pick Rate
                    double pr = calculatePickRate(entry.getValue().intValue(), champPoolSize);
                    pr = Precision.round(pr, 1);

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

                    double wr = calculateWinRate(wins,loses);
                    wr = Precision.round(wr,1);

                    //Setting Info
                    CareerStatInfo.ChampPick champPick = new CareerStatInfo.ChampPick();
                    champPick.setName(entry.getKey());
                    champPick.setPickCount(entry.getValue().intValue());
                    champPick.setPickRatio(pr);
                    champPick.setWinRate(wr);
                    champPick.setWins(champWins.get(entry.getKey()));
                    champPick.setLoses(champLoses.get(entry.getKey()));
                    champPick.setKillDeathAssistRatio(Precision.round(champKDA.get(entry.getKey()),1));
                    champList.add(champPick);
                    championNameList.add(entry.getKey());

                });
        playerStats.setChampionPickInfoList(champList);
        playerStats.setChampionList(championNameList);

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
                    for (CareerStatInfo.ChampPick pick:champList) {
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
                    for (CareerStatInfo.ChampPick pick:champList) {
                        if(pick.getName().equals(entry.getKey())){
                            lowestKDAList.add(pick);
                        }
                    }
                });
        playerStats.setLowestKDAList(lowestKDAList);

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
}
