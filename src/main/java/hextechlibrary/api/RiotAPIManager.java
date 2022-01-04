package hextechlibrary.api;

import okhttp3.OkHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <p>
 *     RiotAPIManager provides access to all the RIOT API calling classes.
 *     This is generated automatically by Hex-techLibrary when it is created and only serves as an access point tot he API calling classes.
 * </p>
 * <ul>
 *     <li>LeagueOfLegendsAPI - League of Legends API call class.</li>
 *     <li>LegendsOfRuneterraAPI - Legends of Runterra API call class.</li>
 *     <li>TeamFightTacticsAPI - Team Fight Tactics API call class.</li>
 * </ul>
 */
public class RiotAPIManager {
    private final Logger logger = LogManager.getLogger(RiotAPIManager.class);
    private final LeagueOfLegendsAPI leagueOfLegendsAPI;
    private final LegendsOfRuneTerraAPI legendsOfRuneTerraAPI;
    private final TeamFightTacticsAPI teamFightTacticsAPI;

    /**
     *
     * @param lol_key League of Legends API Key
     * @param lor_key League of Runeterra API Key
     * @param tft_key Team Fight Tactics API Key
     * @param okHttpClient OkHTTPClient created by Hex-techLibrary.
     */
    public RiotAPIManager(String lol_key, String lor_key, String tft_key, OkHttpClient okHttpClient) {
        this.leagueOfLegendsAPI = new LeagueOfLegendsAPI(lol_key,"https://na1.api.riotgames.com/","https://americas.api.riotgames.com/", okHttpClient);
        this.legendsOfRuneTerraAPI = new LegendsOfRuneTerraAPI(lor_key,"https://na1.api.riotgames.com/","https://americas.api.riotgames.com/");
        this.teamFightTacticsAPI = new TeamFightTacticsAPI(tft_key,"https://na1.api.riotgames.com/","https://americas.api.riotgames.com/");
    }

    /**
     *
     * @return The League of Legends API calling Class.
     */
    public LeagueOfLegendsAPI getLeagueOfLegendsAPI() {
        return leagueOfLegendsAPI;
    }

    /**
     *
     * @return The Legends of Runeterra API calling Class.
     */
    public LegendsOfRuneTerraAPI getLegendsOfRuneTerraAPI() {
        return legendsOfRuneTerraAPI;
    }

    /**
     *
     * @return The Team Fight Tactics API calling class.
     */
    public TeamFightTacticsAPI getTeamFightTacticsAPI() {
        return teamFightTacticsAPI;
    }
}
