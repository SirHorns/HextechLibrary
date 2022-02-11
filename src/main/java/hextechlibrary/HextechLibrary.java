package hextechlibrary;

import hextechlibrary.managers.AssetManager;
import hextechlibrary.managers.TFTManager;
import hextechlibrary.api.RiotAPIManager;
import hextechlibrary.objects.lol.CareerStatInfo;
import hextechlibrary.okhttp.LoggingInterceptor;
import hextechlibrary.callables.CareerStats;
import okhttp3.OkHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class HextechLibrary{
    private final Logger logger = LogManager.getLogger(HextechLibrary.class);
    private final TFTManager tftManager;
    private final RiotAPIManager riotAPIManager;
    private AssetManager assetManager;

    public static void main(String[] args) {

    }

    /**
     * <p>
     *     The HextechLibrary constructor takes in the API Keys for Riots' League of Legends based products.
     *     <br>
     *     You can provide a Development Key instead of a proper key for testing.
     *     <br>
     *     If you do not have a key for each product then can simply provide an empty string value. ie "".
     * </p>
     *
     * @param lol_key League of Legends API Key
     * @param lor_key League of Runeterra API Key
     * @param tft_key Team Fight Tactics API Key
     */
    public HextechLibrary(String lol_key, String lor_key,String tft_key) {
        logger.info("Creating okHttpClient.");
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .build();
        logger.info("Setting Managers.");
        this.riotAPIManager = new RiotAPIManager(lol_key, lor_key, tft_key, okHttpClient);
        this.tftManager = new TFTManager();
        logger.info("Setting Asset Manager.");
        try {
            this.assetManager = new AssetManager();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return The Riot API Manager for the HextechLibaray instance that is used to access API calls.
     */
    public RiotAPIManager getRiotAPIManager() {
        return riotAPIManager;
    }
    /**
     *
     * @return The Team Fight Tactics Manager used to access set information.
     */
    public TFTManager getTftManager() {
        return tftManager;
    }
    /**
     *
     * @return The Asset Manager for Riot DataDragon files.
     */
    public AssetManager getAssetManager() {
        return assetManager;
    }


    public void getCareerStats(String summonerName) {
        FutureTask[] randomNumberTasks = new FutureTask[1];
        CareerStats careerStats = new CareerStats(riotAPIManager.getLeagueOfLegendsAPI(), "",summonerName,100);
        randomNumberTasks[0] = new FutureTask(careerStats);
        Thread t = new Thread(randomNumberTasks[0],summonerName + "-CareerStats");
        t.start();

        try {
            CareerStatInfo info = (CareerStatInfo) randomNumberTasks[0].get();
            System.out.println(info.getSummonerName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    public static void countFrequencies(ArrayList<String> list) {
        list.sort(Collections.reverseOrder());
        // hashmap to store the frequency of element
        Map<String, Integer> hm = new HashMap<String, Integer>();

        for (String i : list) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }

        ValueComparator bvc =  new ValueComparator(hm);
        TreeMap<String,Integer> sorted_map = new TreeMap<>(bvc);
        sorted_map.putAll(hm);

        for (Map.Entry<String, Integer> val : sorted_map.entrySet()) {
            System.out.println("Element " + val.getKey() + " "
                    + "occurs"
                    + ": " + val.getValue() + " times");
        }
    }

    static class ValueComparator implements Comparator<String> {

        Map<String, Integer> base;
        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
