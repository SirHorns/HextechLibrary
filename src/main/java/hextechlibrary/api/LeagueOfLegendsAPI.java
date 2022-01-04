package hextechlibrary.api;

import hextechlibrary.dto.lol.SummonerDto;
import hextechlibrary.dto.lol.match.MatchDto;
import hextechlibrary.dto.lol.match.MatchTimelineDto;
import hextechlibrary.dto.lol.status.StatusDto;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;

public class LeagueOfLegendsAPI extends RiotAPI {
    private Headers previousHeaders;
    private final Bucket apiBucket;
    private Date tmpDate;

    public LeagueOfLegendsAPI(String key, String platform, String regional, OkHttpClient okHttpClient) {
        this.apiKey = key;
        this.platformLink = platform;
        this.regionalLink = regional;
        this.okHttpClient = okHttpClient;

        Refill refill1 = Refill.intervally(120, Duration.ofMinutes(2));
        Refill refill2 = Refill.intervally(20, Duration.ofSeconds(1));
        Bandwidth limit1 = Bandwidth.classic(120, refill1);
        Bandwidth limit2 = Bandwidth.classic(20, refill2);
        this.apiBucket = Bucket.builder()
                .addLimit(limit1)
                .addLimit(limit2)
                .build();
    }

    //SUMMONER API CALLS
    /**
     *  <p>
     *      Requests a SummonerDto Account info JSON file from the RIOT League of Legends API.
     *  </p>
     *
     * @param accountID ID of League of Legends SummonerDto Account
     * @return The summonerDto object generated based on the account ID provided.
     */
    public SummonerDto getSummonerDtoByAccountID(String accountID) {
        String responseJSON;
        SummonerDto summonerDto = null;

        //Validate Args.
        if (accountID.equals("")){
            return null;
        }

        Request request = new Request.Builder()
                .header("User-Agent","")
                .header("Accept-Language","en-US,en;q=0.9")
                .header("Accept-Charset","application/x-www-form-urlencoded; charset=UTF-8")
                .header("X-Riot-Token", apiKey)
                .url(platformLink + "lol/summoner/v4/summoners/by-account/" + accountID)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()){
            if (!response.isSuccessful()){
                throw new IOException("\nUnexpected Code: " + response);
            }else {
                responseJSON = Objects.requireNonNull(response.body()).string();
                summonerDto = objectMapper.readValue(responseJSON, SummonerDto.class);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return summonerDto;
    }

    /**
     *  <p>
     *      Requests a SummonerDto Account info JSON file from the RIOT League of Legends API.
     *  </p>
     *
     * @param name The username of the summonerDto.
     * @return The summonerDto object generated based on the account ID provided.
     */
    public SummonerDto getSummonerByName(String name) {
        String responseJSON;
        SummonerDto summonerDto = null;

        //Validate Args.
        if (name.equals("")){
            return null;
        }

        Request request = new Request.Builder()
                .header("User-Agent","")
                .header("Accept-Language","en-US,en;q=0.9")
                .header("Accept-Charset","application/x-www-form-urlencoded; charset=UTF-8")
                .header("X-Riot-Token", apiKey)
                .url(platformLink + "lol/summoner/v4/summoners/by-name/" + name)
                .build();

        Response response = GetResponse(request);

        try {
            responseJSON = Objects.requireNonNull(response.body()).string();
            summonerDto = objectMapper.readValue(responseJSON, SummonerDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return summonerDto;
    }

    private Response GetResponse(Request request){
        Response response = null;

        if (apiBucket.tryConsume(1)){
            try {
                response = okHttpClient.newCall(request).execute();

                if (!response.isSuccessful()){
                    logger.warn("Request returned an unsuccessful response: \nCode: " + response.code() + "Message: " + response.message() + "\nHeaders:\n" + response.headers());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return response;
    }

    private boolean VerifyResponse(Response response){
        //checkRateLimit(response.headers());
        //Check Response Code & Log it.
        if (!response.isSuccessful()){
            //throw new IOException("\nUnexpected Code: " + response);
            logger.error("Code: " + response.code() + " Message: " + response.message() + "\n" + response.headers());
            return false;
        }else{
            logger.info("Code: " + response.code() + " Message: " + response.message());
            return true;
        }
    }

    private void VerifyHeaders(){

    }

    /**
     *  Requests a SummonerDto Account's info JSON file from the RIOT League of Legends API.
     *
     * @param puuid The puuid of a League of Legends account.
     * @return The summonerDto object generated based on the summonerDto puuid provided.
     */
    public SummonerDto getSummonerDtoByPUUID(String puuid) {
        String responseJSON;
        SummonerDto summonerDto = null;

        //Validate Args.
        if (puuid.equals("")){
            return null;
        }

        Request request = new Request.Builder()
                .header("User-Agent","")
                .header("Accept-Language","en-US,en;q=0.9")
                .header("Accept-Charset","application/x-www-form-urlencoded; charset=UTF-8")
                .header("X-Riot-Token", apiKey)
                .url(platformLink + "lol/summoner/v4/summoners/by-puuid/" + puuid)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()){
            if (!response.isSuccessful()){
                throw new IOException("\nUnexpected Code: " + response);
            }else {
                responseJSON = Objects.requireNonNull(response.body()).string();
                summonerDto = objectMapper.readValue(responseJSON, SummonerDto.class);
                checkRateLimit(response.headers());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return summonerDto;
    }

    /**
     * <p>
     *     Requests a SummonerDto Account info JSON file from the RIOT League of Legends API.
     * </p>
     *
     * @param summonerDtoID SummonerDtoId of a League of Legends account
     * @return The summonerDto object generated based on the summonerDto ID provided.
     */
    public SummonerDto getSummonerDtoBySummonerDtoID(String summonerDtoID) {
        String responseJSON;
        SummonerDto summonerDto = null;

        //Validate Args.
        if (summonerDtoID.equals("")){
            return null;
        }

        Request request = new Request.Builder()
                .header("User-Agent","")
                .header("Accept-Language","en-US,en;q=0.9")
                .header("Accept-Charset","application/x-www-form-urlencoded; charset=UTF-8")
                .header("X-Riot-Token", apiKey)
                .url(platformLink + "lol/summoner/v4/summoners/" + summonerDtoID)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()){
            if (!response.isSuccessful()){
                throw new IOException("\nUnexpected Code: " + response);
            }else {
                responseJSON = Objects.requireNonNull(response.body()).string();
                summonerDto = objectMapper.readValue(responseJSON, SummonerDto.class);
                checkRateLimit(response.headers());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return summonerDto;
    }

    //MATCH API CALLS
    /**
     * Requests a MatchID List JSON file from the RIOT League of Legends API.
     * <p><b>Epoch TimeStamps: StartTime & EndTime.</b></p>
     * <p>
     *     The match-list started storing timestamps on June 16th, 2021.
     *     Any matches played before June 16th, 2021 won't be included in the results if the startTime filter is set.
     * </p>
     * <br>
     * <p><b>Filters: QueueID & Type.</b></p>
     * <p>
     *     These filters are mutually inclusive of each-other.
     *     Meaning any match ids returned must match both the queue and type filters.
     * </p>
     * <br>
     * <p><b>Start:</b></p>
     * <p>
     *     Defaults to 0.
     * </p>
     * <br>
     * <p><b>Count:</b></p>
     * <p>
     *     Defaults to 20.
     *     Valid values: 0 to 100.
     * </p>
     * <br>
     * @param puuid PUUID of LoL account
     * @param startTime Epoch start timestamp in seconds.
     * @param endTime Epoch end timestamp in seconds.
     * @param queueID Filter the list of match ids by a specific queue id.
     * @param type  Filter the list of match ids by the type of match.
     * @param start Start index of the returned ID List.
     * @param count Number of matchIDs to return.
     * @return String List of matchIDs based on a summonerDto puuid.
     */
    public List<String> getMatchesByPUUID(String puuid,long startTime, long endTime, int queueID, String type, int start, int count) {
        String responseJSON;
        List<String> returnList = null;

        //Validate Args
        StringBuilder arg = new StringBuilder();
        if (!puuid.equals("")){
            arg.append(puuid);
            arg.append("/ids?");
            if (startTime < 0){arg.append("startTime=").append(startTime);}
            if (endTime < 0){arg.append("&endTime=").append(endTime);}
            if (queueID < 0){arg.append("&queue=").append(queueID);}
            if (!type.equals("")){arg.append("&type=").append(type);}
            arg.append("&start=").append(start);
            if (count > 0){arg.append("&count=").append(count);}
        }else {
            System.out.println("No PUUID provided for get Match List.");
            return null;
        }


        Request request = new Request.Builder()
                .header("Accept-Language","en-US,en;q=0.9")
                .header("Accept-Charset","application/x-www-form-urlencoded; charset=UTF-8")
                .header("X-Riot-Token", apiKey)
                .url(regionalLink + "lol/match/v5/matches/by-puuid/" + arg)
                .build();

        if (apiBucket.tryConsume(1)){
            //Preform Request
            try (Response response = okHttpClient.newCall(request).execute()){
                if (!response.isSuccessful()){
                    throw new IOException("\nUnexpected Code: " + response + "\n" + response.headers());
                }else {
                    responseJSON = Objects.requireNonNull(response.body()).string();
                    returnList = new ArrayList<>(List.of(objectMapper.readValue(responseJSON, String[].class)));
                    //checkRateLimit(response.headers());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            logger.warn("Not enough tokens in the bucket. Request ignored, returning null matchID list.");
        }

        return returnList;
    }

    /**
     *  Requests a Match JSON file from the RIOT League of Legends API.
     *
     * @param matchId ID of a League of Legends match.
     * @return Match object based on searched matchId
     */
    public MatchDto getMatchByMatchID(String matchId) {
        String responseJSON;
        MatchDto matchDto = null;

        Request request = new Request.Builder()
                .header("Accept-Language","en-US,en;q=0.9")
                .header("Accept-Charset","application/x-www-form-urlencoded; charset=UTF-8")
                .header("X-Riot-Token", apiKey)
                .url(regionalLink + "lol/match/v5/matches/" + matchId)
                .build();



        if (apiBucket.tryConsume(1)){
            try (Response response = okHttpClient.newCall(request).execute()){
                if (!response.isSuccessful()){
                    //checkRateLimit(response.headers());
                    throw new IOException("\nUnexpected Code: " + response + "\n" + response.headers());
                }else{
                    responseJSON = Objects.requireNonNull(response.body()).string();
                    matchDto = objectMapper.readValue(responseJSON, MatchDto.class);
                    //checkRateLimit(response.headers());
                }


            } catch (IOException jsonMappingException) {
                jsonMappingException.printStackTrace();
            }
        }else{
            logger.warn("Not enough tokens in the bucket. Request ignored, returning null matchID list.");
        }



        return matchDto;
    }

    /**
     *  Requests a Match JSON file from the RIOT League of Legends API.
     *
     * @param matchIds List of league of Legends match IDs.
     * @return List of MatchDto objects based on searched matchIds
     */
    public List<MatchDto> getMatchesByMatchIDs(List<String> matchIds) {
        String responseJSON;
        List<MatchDto> matchesList = new ArrayList<>();


        for (String id:matchIds) {
            boolean flag = true;
            Request request = new Request.Builder()
                    .header("Accept-Language","en-US,en;q=0.9")
                    .header("Accept-Charset","application/x-www-form-urlencoded; charset=UTF-8")
                    .header("X-Riot-Token", apiKey)
                    .url(regionalLink + "lol/match/v5/matches/" + id)
                    .build();
            do{
                if (apiBucket.tryConsume(1)){
                    Response response = GetResponse(request);

                    if (!response.isSuccessful()){
                        //checkRateLimit(response.headers());
                        logger.error("\nUnexpected Code: " + response + "\n" + response.headers());
                    }else {
                        try {
                            responseJSON = Objects.requireNonNull(response.body()).string();
                            matchesList.add(objectMapper.readValue(responseJSON, MatchDto.class));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    flag = false;
                }else {
                    try {
                        int sleep = 1000;
                        logger.warn("Not enough tokens in the bucket. Putting " + Thread.currentThread().getName() + " to sleep for " + sleep + "milliseconds");
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }while(flag);
        }

        return matchesList;
    }

    /**
     * Requests a Timeline JSON file for a match from the RIOT League of Legends API.
     *
     * @param matchId ID of a League of Legends match.
     * @return Timeline object of a match based on the provided matchId.
     */
    public MatchTimelineDto getMatchTimeLine(String matchId) {
        String responseJSON;
        MatchTimelineDto matchTimelineDto = null;

        Request request = new Request.Builder()
                .header("Accept-Language","en-US,en;q=0.9")
                .header("Accept-Charset","application/x-www-form-urlencoded; charset=UTF-8")
                .header("X-Riot-Token", apiKey)
                .url(regionalLink + "lol/match/v5/matches/" + matchId + "/timeline")
                .build();

        try (Response response = okHttpClient.newCall(request).execute()){
            responseJSON = Objects.requireNonNull(response.body()).string();
            matchTimelineDto = objectMapper.readValue(responseJSON, MatchTimelineDto.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return matchTimelineDto;
    }

    public StatusDto getStatus(String region){
        String responseJSON;
        StatusDto statusDto = null;

        //Validate Args
        if (region.equals("")){
            System.out.println("No PUUID provided for get Match List.");
            return null;
        }

        //Preform Request
        Request request = new Request.Builder()
                .header("Accept-Language","en-US,en;q=0.9")
                .header("Accept-Charset","application/x-www-form-urlencoded; charset=UTF-8")
                .header("X-Riot-Token", apiKey)
                .url("https://" + region + ".api.riotgames.com/lol/status/v4/platform-data")
                .build();

        try (Response response = okHttpClient.newCall(request).execute()){
            if (!response.isSuccessful()){
                throw new IOException("\nUnexpected Code: " + response);
            }else {
                responseJSON = Objects.requireNonNull(response.body()).string();
                statusDto = objectMapper.readValue(responseJSON, StatusDto.class);
                checkRateLimit(response.headers());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return statusDto;
    }
}
