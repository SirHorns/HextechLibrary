package hextechlibrary.api;

//Handles all the actual RIOT API calls and passes off output to the DB functions.
public class RAPIManager{
    private LoLAPI lolAPI;
    private LoRAPI lorAPI;
    private TfTAPI tftAPI;

    public RAPIManager(String lolkey, String lorkey, String tftkey) {
        this.lolAPI = new LoLAPI(lolkey,"https://na1.api.riotgames.com/","https://americas.api.riotgames.com/");
        this.lorAPI = new LoRAPI(lorkey,"https://na1.api.riotgames.com/","https://americas.api.riotgames.com/");
        this.tftAPI = new TfTAPI(tftkey,"https://na1.api.riotgames.com/","https://americas.api.riotgames.com/");
    }

    public LoLAPI getLoLAPI() {
        return lolAPI;
    }

    public LoRAPI getLoRAPI() {
        return lorAPI;
    }

    public TfTAPI getTfTAPI() {
        return tftAPI;
    }

    public void setLoLAPI(String key, String platform, String regional) {
        this.lolAPI =  new LoLAPI(key,platform,regional);
    }

    public void setLoRAPI(String key, String platform, String regional) {
        this.lorAPI = new LoRAPI(key,platform,regional);
    }

    public void setTfTAPI(String key, String platform, String regional) {
        this.tftAPI = new TfTAPI(key,platform,regional);
    }
}
