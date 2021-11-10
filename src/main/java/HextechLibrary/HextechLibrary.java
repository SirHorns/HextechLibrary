package HextechLibrary;


import SQLite.SQLite;
import Types.dto.Match.Match;
import Types.dto.Match.Participant;
import Types.dto.Summoner.Summoner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Objects;

public class HextechLibrary{
    private String RIOT_API_TOKEN;
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String URLBASE = "https://americas.api.riotgames.com/lol/";
    SQLite lite = new SQLite();

    public HextechLibrary() {

    }

    public String getRIOT_API_TOKEN() {
        return RIOT_API_TOKEN;
    }

    public void setRIOT_API_TOKEN(String RIOT_API_TOKEN) {
        this.RIOT_API_TOKEN = RIOT_API_TOKEN;
    }

    public Summoner GetSummoner(String username){
        Summoner summoner = new Summoner.Builder()
                .withName("INIT_name")
                .withId("INIT_id")
                .withPuuid("INIT_puuid")
                .withAccountId("INIT_accountId")
                .withProfileIconId(1)
                .withRevisionDate(1)
                .withSummonerLevel(1)
                .build();
        if (lite.SummonerExist(username)){
            System.out.println(username + " is in the DB.");
            summoner = lite.getSummoner(username);

        }
        else{
            System.out.println("Summoner not in the DB. Returning INIT_Object");
        }
        return summoner;
    }

    public void temp(){
        System.out.println("Summoner not in the database, calling API.");
        Request request = new Request.Builder()
                .header("X-Riot-Token", "RGAPI-dbd6d858-570a-4103-a22f-76c94c370609")
                .url("https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/username")
                .build();

        try (Response response = client.newCall(request).execute()){
            String responseBody = Objects.requireNonNull(response.body()).string();
            //System.out.println("Response Body: "+ jsonString);

           // summoner = objectMapper.readValue(responseBody, Summoner.class);

            /*
            lite.insertSummoner(
                    summoner.getAccountId(),
                    summoner.getId(),
                    summoner.getName(),
                    summoner.getProfileIconId(),
                    summoner.getRevisionDate(),
                    summoner.getSummonerLevel(),
                    summoner.getPuuid());

             */

            //lite.updateSummoner(summoner.getAccountId(), summoner.getName(), summoner.getProfileIconId(), summoner.getRevisionDate(), summoner.getSummonerLevel());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Match GetMatch(String matchId) throws JsonProcessingException {
        String responseJSON = "";

        Request request = new Request.Builder()
                .header("X-Riot-Token", RIOT_API_TOKEN)
                .url( URLBASE + "match/v5/matches/" + matchId)
                .build();

        try (Response response = client.newCall(request).execute()){
            responseJSON = Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Match match = objectMapper.readValue(responseJSON, Match.class);
        lite.insertMatch(match.getMetadata().getMatchId());
        //lite.insertMatchInfo("INIT",match.getInfo().getGameId(),match.getInfo().get);

        for (Participant p : match.getInfo().getParticipants()) {
            if (Objects.equals(p.getSummonerName(), "JackWildBurn")){
                System.out.println("JackWildBurn:");
                System.out.println("Kills: " + p.getKills());
                System.out.println("Deaths: " + p.getDeaths());
                System.out.println("Assists: " +p.getAssists());

            }
        }

        return match;
    }

    public void AddSummoner(String username) throws JsonProcessingException {

        /*
        Get Summoner
        Get 20 matches
        Store that info
        */
        Summoner summoner = new Summoner.Builder()
                .withName("INIT_name")
                .withId("INIT_id")
                .withPuuid("INIT_puuid")
                .withAccountId("INIT_accountId")
                .withProfileIconId(1)
                .withRevisionDate(1)
                .withSummonerLevel(1)
                .build();
        String responseJSON = "";
        String[] matchesIdList;

        if (lite.SummonerExist(username)){
            System.out.println(username + " is in the DB already.");
        }else{
            //Create Summoner Match Info Table
            //lite.CreateNewPlayerTable(username);

            //Get Summoner Info
            Request request = new Request.Builder()
                    .header("X-Riot-Token", RIOT_API_TOKEN)
                    .url( "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + username)
                    .build();

            try (Response response = client.newCall(request).execute()){
                responseJSON = Objects.requireNonNull(response.body()).string();
            } catch (IOException e) {
                e.printStackTrace();
            }

            summoner = objectMapper.readValue(responseJSON, Summoner.class);
            lite.insertSummoner(summoner.getAccountId(), summoner.getId(), summoner.getName(), summoner.getProfileIconId(), summoner.getRevisionDate(), summoner.getSummonerLevel(), summoner.getPuuid());

            //GetLast 20 Matches
            request = new Request.Builder()
                    .header("X-Riot-Token", RIOT_API_TOKEN)
                    .url( URLBASE + "match/v5/matches/by-puuid/" + summoner.getPuuid() + "/ids?start=0&count=" + 20)
                    .build();
            try (Response response = client.newCall(request).execute()){
                responseJSON = Objects.requireNonNull(response.body()).string();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] matches = objectMapper.readValue(responseJSON, String[].class);
            matchesIdList = matches;

            for (String match: matches){
                lite.insertMatch(match);
            }

            //Get MatchInfo
            for(String match: matchesIdList){
                request = new Request.Builder()
                        .header("X-Riot-Token", RIOT_API_TOKEN)
                        .url( URLBASE + "match/v5/matches/" + match)
                        .build();
                try (Response response = client.newCall(request).execute()){
                    responseJSON = Objects.requireNonNull(response.body()).string();

                    Match gameMatch = objectMapper.readValue(responseJSON, Match.class);


                    for (Participant playerParticipant : gameMatch.getInfo().getParticipants()) {
                        if (Objects.equals(playerParticipant.getPuuid(), summoner.getPuuid())){
                            lite.insertMatchInfo(
                                    summoner.getPuuid(),
                                    gameMatch.getMetadata().getMatchId(),
                                    gameMatch.getInfo().getGameMode(),
                                    playerParticipant.getWin(),
                                    playerParticipant.getKills(),
                                    playerParticipant.getDeaths(),
                                    playerParticipant.getAssists(),
                                    playerParticipant.getTotalMinionsKilled(),
                                    playerParticipant.getMagicDamageDealt(),
                                    playerParticipant.getMagicDamageDealtToChampions(),
                                    playerParticipant.getMagicDamageTaken(),
                                    playerParticipant.getPhysicalDamageDealt(),
                                    playerParticipant.getPhysicalDamageDealtToChampions(),
                                    playerParticipant.getPhysicalDamageTaken(),
                                    playerParticipant.getTrueDamageDealt(),
                                    playerParticipant.getTrueDamageDealtToChampions(),
                                    playerParticipant.getTrueDamageTaken(),
                                    playerParticipant.getTotalDamageDealt(),
                                    playerParticipant.getTotalDamageDealtToChampions(),
                                    playerParticipant.getTotalDamageTaken()
                            );
                            break;
                        }
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Insert a new row into the warehouses table
     * @param puuid account puuid
     * @param matchCount Number of matches to pull
     * @return the list of match Ids from the player's match history
     */
    public String[] GetMatchList(String puuid, int matchCount) throws JsonProcessingException {
        String responseJSON = "";
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(10);
        ZoneId zone = ZoneId.systemDefault();
        ZoneOffset zoneOffSet = zone.getRules().getOffset(localDateTime);
        //Headers
        String gameType = "normal";
        long startTime = localDateTime.toEpochSecond(zoneOffSet),endTime = 0;
        int queue = 0, start = 0, count = 100;

        if (matchCount == 0){
            count = matchCount;
        }

        //"&queue=" + queue +
        //"&start=" + start +
        String head =
                "ids?startTime=" + startTime +
                        "&endTime=" + endTime +
                        "&type=" + gameType +
                        "&count=" + count;

        Request request = new Request.Builder()
                .header("X-Riot-Token", RIOT_API_TOKEN)
                .url( URLBASE + "match/v5/matches/by-puuid/" + puuid + "/" + head)
                .build();

        try (Response response = client.newCall(request).execute()){
            responseJSON = Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] matches = objectMapper.readValue(responseJSON, String[].class);

        for (String m: matches){
            lite.insertMatch(m);
        }

        return matches;
    }

    public String GetWinRate(String username){
        String winrate = "";
        Summoner summoner = new Summoner.Builder()
                .withName("INIT_name")
                .withId("INIT_id")
                .withPuuid("INIT_puuid")
                .withAccountId("INIT_accountId")
                .withProfileIconId(1)
                .withRevisionDate(1)
                .withSummonerLevel(1)
                .build();
        if (lite.SummonerExist(username)){

            summoner = lite.getSummoner(username);

        }

        return winrate;
    }


}
