package hextechlibrary;

import hextechlibrary.games.TFTManager;
import hextechlibrary.riotapi.RAPIManager;


public class HextechLibrary{
    private static HextechLibrary INSTANCE;
    private final String lolKey;
    private final String tftKey;
    private final String lorKey;
    private final TFTManager tftManager;

    RAPIManager rapiManager;

    public HextechLibrary(String lol_api_key) {
        this.lolKey = lol_api_key;
        this.lorKey = "LoR-KEY";
        this.tftKey = "TFT-KEY";
        this.rapiManager = new RAPIManager(lolKey);
        this.tftManager = new TFTManager();
    }

    public String getLolKey() {
        return lolKey;
    }

    public RAPIManager getRapiManager() {
        return rapiManager;
    }

    public TFTManager getTftManager() {
        return tftManager;
    }
}
