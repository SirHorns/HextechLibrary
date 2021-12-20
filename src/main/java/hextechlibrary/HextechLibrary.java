package hextechlibrary;

import hextechlibrary.games.TFTManager;
import hextechlibrary.api.RAPIManager;


public class HextechLibrary{
    private static HextechLibrary INSTANCE;
    private final TFTManager tftManager;

    RAPIManager rapiManager;

    public HextechLibrary(String lol_key, String lor_key,String tft_key) {
        this.rapiManager = new RAPIManager(lol_key, lor_key, tft_key);
        this.tftManager = new TFTManager();
    }

    public RAPIManager getRapiManager() {
        return rapiManager;
    }

    public TFTManager getTftManager() {
        return tftManager;
    }
}
