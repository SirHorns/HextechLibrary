package hextechlibrary;

import hextechlibrary.riotapi.RAPIManager;


public class HextechLibrary{
    private static HextechLibrary INSTANCE;
    private String LOL_API_KEY;

    RAPIManager rapiManager;

    public HextechLibrary(String lol_api_key) {
        this.LOL_API_KEY = lol_api_key;
        this.rapiManager = new RAPIManager(LOL_API_KEY);
    }

    public String getLOL_API_KEY() {
        return LOL_API_KEY;
    }

    public void setLOL_API_KEY(String LOL_API_KEY) {
        this.LOL_API_KEY = LOL_API_KEY;
        rapiManager = new RAPIManager(LOL_API_KEY);
    }

    public RAPIManager getRapiManager() {
        return rapiManager;
    }
}
