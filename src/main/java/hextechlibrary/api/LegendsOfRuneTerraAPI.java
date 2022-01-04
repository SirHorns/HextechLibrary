package hextechlibrary.api;

import hextechlibrary.api.RiotAPI;

public class LegendsOfRuneTerraAPI extends RiotAPI {
    public LegendsOfRuneTerraAPI(String key, String platform, String regional) {
        apiKey = key;
        platformLink = platform;
        regionalLink = regional;
    }
}
