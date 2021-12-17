package hextechlibrary.api;

import hextechlibrary.games.leagueoflegends.dto.match.Match;
import hextechlibrary.games.leagueoflegends.dto.summoner.Summoner;
import hextechlibrary.games.tft.dto.SummonerTFT;
import hextechlibrary.games.tft.dto.match.MatchTFT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

//Handles all the actual RIOT API calls and passes off output to the DB functions.
public class RAPIManager{

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private String LOL_KEY;
    private String LOR_KEY;
    private String TFT_KEY;

    public RAPIManager(String lolkey, String lorkey, String tftkey) {
        LOL_KEY = lolkey;
        LOR_KEY = lorkey;
        TFT_KEY = tftkey;
    }

    /**
     * Sets the TFT API Key
     * @param tft_key Team Fight Tactics API Key
     */
    public void setTFT_KEY(String tft_key) {
        this.TFT_KEY = tft_key;
    }

    /**
     * Returns the set League of Legends API Key
     * @return  League of Legends API Key string
     */
    public String getLOL_KEY() {
        return LOL_KEY;
    }

    /**
     * Returns the set Legends of Runtera API Key
     * @param LOL_KEY League of Legends API Key
     */
    public void setLOL_KEY(String LOL_KEY) {
        this.LOL_KEY = LOL_KEY;
    }

    /**
     * Returns the set Team Fight Tactics API Key
     * @return Team Fight Tactics API Key
     */
    public String getTFT_KEY() {
        return TFT_KEY;
    }

    //TFT MATCH INFO
    /**
     *  Returns a list of Match object
     *
     * @param puuid PUUID of TFT account
     * @param count Defaults to 20..
     * @return List of matches based on puuid
     */
    public List<String> getTFTMatchesByPUUID(String puuid, int count) throws JsonProcessingException {
        String responseJSON = "";
        String args = puuid +"/ids?count=" + count;

        Request request = new Request.Builder()
                .header("X-Riot-Token", TFT_KEY)
                .header("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("Origin", "https://developer.riotgames.com")
                .url("https://americas.api.riotgames.com/tft/match/v1/matches/by-puuid/" + args)
                .build();

        try (Response response = client.newCall(request).execute()){
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
    public MatchTFT getTFTMatchByMatchID(String matchId) throws JsonProcessingException {
        String responseJSON = "";

        Request request = new Request.Builder()
                .header("X-Riot-Token", TFT_KEY)
                .url("https://americas.api.riotgames.com/tft/match/v1/matches/" + matchId)
                .build();

        try (Response response = client.newCall(request).execute()){
            responseJSON = Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectMapper.readValue(responseJSON, MatchTFT.class);
    }

    //LoL SUMMONER INFO
    /**
     *  Returns a Summoner object
     *
     * @param accountID LoL Account ID
     * @return summoner object based on searched LoL Account ID
     */
    public Summoner getSummonerByAccountID(String accountID) throws JsonProcessingException {
        String responseJSON = "";

        Request request = new Request.Builder()
                .header("X-Riot-Token", LOL_KEY)
                .url("https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-account/" + accountID)
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
                .header("X-Riot-Token", LOL_KEY)
                .url("https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name)
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
                .header("X-Riot-Token", LOL_KEY)
                .url("https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/" + puuid)
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
                .header("X-Riot-Token", LOL_KEY)
                .url("https://https://na1.api.riotgames.com/lol/summoner/v4/summoners/" + summonerID)
                .build();

        try (Response response = client.newCall(request).execute()){
            responseJSON = Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectMapper.readValue(responseJSON, Summoner.class);
    }

    //TFT SUMMONER INFO
    /**
     *  Returns a SummonerTFT object
     *
     * @param name Name of a Summoner
     * @return summoner object based on searched Summoner name
     */
    public SummonerTFT getSummonerTFTByName(String name) throws JsonProcessingException {
        String responseJSON = "";

        Request request = new Request.Builder()
                .header("X-Riot-Token", TFT_KEY)
                .url("https://na1.api.riotgames.com/tft/summoner/v1/summoners/by-name/" + name)
                .build();

        try (Response response = client.newCall(request).execute()){
            responseJSON = Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectMapper.readValue(responseJSON, SummonerTFT.class);
    }
    /**
     *  Returns a SummonerTFT object
     *
     * @param puuid PUUID of a TFT account
     * @return summoner object based on searched PUUID
     */
    public SummonerTFT getSummonerTFTByPUUID(String puuid) throws JsonProcessingException {
        String responseJSON = "";

        Request request = new Request.Builder()
                .header("X-Riot-Token", TFT_KEY)
                .url("https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/" + puuid)
                .build();

        try (Response response = client.newCall(request).execute()){
            responseJSON = Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectMapper.readValue(responseJSON, SummonerTFT.class);
    }
}
