package hextechlibrary.api;

import hextechlibrary.api.RiotAPI;

public class LoRAPI extends RiotAPI {
    public LoRAPI(String key, String platform, String regional) {
        apiKey = key;
        platformLink = platform;
        regionalLink = regional;
    }
}
