package hextechlibrary.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import hextechlibrary.games.leagueoflegends.dto.match.Match;
import hextechlibrary.games.leagueoflegends.dto.summoner.Summoner;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class LoLAPI extends RiotAPI {
    public LoLAPI(String key, String platform, String regional) {
        this.apiKey = key;
        this.platformLink = platform;
        this.regionalLink = regional;
    }

    //SUMMONER INFO
    /**
     *  Returns a Summoner object
     *
     * @param accountID LoL Account ID
     * @return summoner object based on searched LoL Account ID
     */
    public Summoner getSummonerByAccountID(String accountID) throws JsonProcessingException {
        String responseJSON = "";

        Request request = new Request.Builder()
                .header("Accept-Language","en-US,en;q=0.9")
                .header("Accept-Charset","application/x-www-form-urlencoded; charset=UTF-8")
                .header("Origin","https://developer.riotgames.com")
                .header("X-Riot-Token", apiKey)
                .url(platformLink + "lol/summoner/v4/summoners/by-account/" + accountID)
                .build();

        try (Response response = client.newCall(request).execute()){
            responseJSON = Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectMapper.readValue(responseJSON, Summoner.class);
    }
    /**
     *  Returns a Summoner object
     *
     * @param name Name of a Summoner
     * @return summoner object based on searched Summoner name
     */
    public Summoner getSummonerByName(String name) throws JsonProcessingException {
        String responseJSON = "";

        Request request = new Request.Builder()
                .header("X-Riot-Token", apiKey)
                .url(platformLink + "lol/summoner/v4/summoners/by-name/" + name)
                .build();

        try (Response response = client.newCall(request).execute()){
            responseJSON = Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectMapper.readValue(responseJSON, Summoner.class);
    }
    /**
     *  Returns a Summoner object
     *
     * @param puuid PUUID of a LoL account
     * @return summoner object based on searched PUUID
     */
    public Summoner getSummonerByPUUID(String puuid) throws JsonProcessingException {
        String responseJSON = "";

        Request request = new Request.Builder()
                .header("X-Riot-Token", apiKey)
                .url(platformLink + "lol/summoner/v4/summoners/by-puuid/" + puuid)
                .build();

        try (Response response = client.newCall(request).execute()){
            responseJSON = Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectMapper.readValue(responseJSON, Summoner.class);
    }
    /**
     *  Returns a Summoner object
     *
     * @param summonerID SummonerId of a LoL account
     * @return summoner object based on searched SummonerId
     */
    public Summoner getSummonerBySummonerID(String summonerID) throws JsonProcessingException {
        String responseJSON = "";

        Request request = new Request.Builder()
                .header("X-Riot-Token", apiKey)
                .url(platformLink + "lol/summoner/v4/summoners/" + summonerID)
                .build();

        try (Response response = client.newCall(request).execute()){
            responseJSON = Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectMapper.readValue(responseJSON, Summoner.class);
    }

    //MATCH INFO
    /**
     *  Returns a String List object of match IDs.
     *
     * @param puuid PUUID of LoL account
    //* @param startTime Epoch start timestamp in seconds. The matchlist started storing timestamps on June 16th, 2021. Any matches played before June 16th, 2021 won't be included in the results if the startTime filter is set.
    //* @param endTime Epoch end timestamp in seconds.
    //* @param queue Filter the list of match ids by a specific queue id. This filter is mutually inclusive of the type filter meaning any match ids returned must match both the queue and type filters.
    //* @param type 	Filter the list of match ids by the type of match. This filter is mutually inclusive of the queue filter meaning any match ids returned must match both the queue and type filters.
    //* @param start Defaults to 0. Start index.
    //* @param count Defaults to 20. Valid values: 0 to 100. Number of match ids to return.
     * @return List of matches based on puuid
     */
    public List<String> getMatchesByPUUID(String puuid,String startTime, String endTime, String queueID, String type, String start, String count) throws JsonProcessingException {
        String responseJSON = "";
        //, long startTime, long endTime, int queue, String type, int start, int count
        String args = puuid + "";
        //"/ids?start=" + startTime + "&end=" + endTime + "&queue=" + queue + "&type=" + type + "&start=" + start + "&count=" + count;

        //Validate Args
        StringBuilder argString = new StringBuilder().append("/ids?");
        if (!puuid.equals("")){
            argString.append("startTime").append(puuid);
        }else {
            System.out.println("No PUUID provided for get Match List.");
        }
        if (!startTime.equals("")){
            argString.append("start=").append(startTime);
        }
        if (!endTime.equals("")){
            argString.append("&end=").append(endTime);
        }
        if (!queueID.equals("")){
            argString.append("&queue=").append(queueID);
        }
        if (!type.equals("")){
            argString.append("&type=").append(type);
        }
        if (!start.equals("")){
            argString.append("&start=").append(start);
        }
        if (!count.equals("")){
            argString.append("&count=").append(count);
        }


        Request request = new Request.Builder()
                .header("X-Riot-Token", apiKey)
                .url(regionalLink + "lol/match/v5/matches/by-puuid/" + args)
                .build();


        try (Response response = client.newCall(request).execute()){
            System.out.println(responseJSON);
            responseJSON = Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return List.of(objectMapper.readValue(responseJSON, String[].class));
    }
    /**
     *  Returns a Match object
     *
     * @param matchId LoL Account ID
     * @return Match object based on searched matchId
     */
    public Match getMatchByMatchID(String matchId) throws JsonProcessingException {
        String responseJSON = "";

        Request request = new Request.Builder()
                .header("X-Riot-Token", apiKey)
                .url(regionalLink + "lol/match/v5/matches/" + matchId)
                .build();

        try (Response response = client.newCall(request).execute()){
            responseJSON = Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectMapper.readValue(responseJSON, Match.class);
    }
    /**
     *  Returns the timeline of a match
     *
     * @param matchId LoL Account ID
     * @return Timeline of a match based on the matchId
     */
    public Match getMatchTimeLine(String matchId) throws JsonProcessingException {
        String responseJSON = "";

        Request request = new Request.Builder()
                .header("X-Riot-Token", apiKey)
                .url(regionalLink + "lol/match/v5/matches/" + matchId + "/timeline")
                .build();

        try (Response response = client.newCall(request).execute()){
            responseJSON = Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectMapper.readValue(responseJSON, Match.class);
    }
}
