package hextechlibrary.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import hextechlibrary.games.tft.dto.SummonerTFT;
import hextechlibrary.games.tft.dto.match.MatchTFT;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class TfTAPI extends RiotAPI {
    public TfTAPI(String key, String platform, String regional) {
        apiKey = key;
        platformLink = platform;
        regionalLink = regional;
    }

    //TFT MATCH INFO
    /**
     *  Returns a list of Match object
     *
     * @param puuid PUUID of TFT account
     * @param count Defaults to 20..
     * @return List of matches based on puuid
     */
    public List<String> getMatchesByPUUID(String puuid, int count) throws JsonProcessingException {
        String responseJSON = "";
        String args = puuid +"/ids?count=" + count;

        Request request = new Request.Builder()
                .header("X-Riot-Token", apiKey)
                .header("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("Origin", "https://developer.riotgames.com")
                .url( regionalLink + "tft/match/v1/matches/by-puuid/" + args)
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
    public MatchTFT getMatchByMatchID(String matchId) throws JsonProcessingException {
        String responseJSON = "";

        Request request = new Request.Builder()
                .header("X-Riot-Token", apiKey)
                .url(regionalLink + "tft/match/v1/matches/" + matchId)
                .build();

        try (Response response = client.newCall(request).execute()){
            responseJSON = Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectMapper.readValue(responseJSON, MatchTFT.class);
    }

    //TFT SUMMONER INFO
    /**
     *  Returns a SummonerTFT object
     *
     * @param name Name of a Summoner
     * @return summoner object based on searched Summoner name
     */
    public SummonerTFT getSummonerByName(String name) throws JsonProcessingException {
        String responseJSON = "";

        Request request = new Request.Builder()
                .header("X-Riot-Token", apiKey)
                .url(platformLink + "tft/summoner/v1/summoners/by-name/" + name)
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
    public SummonerTFT getSummonerByPUUID(String puuid) throws JsonProcessingException {
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

        return objectMapper.readValue(responseJSON, SummonerTFT.class);
    }
}
