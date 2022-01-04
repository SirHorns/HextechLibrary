package hextechlibrary.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import hextechlibrary.HextechLibrary;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.internal.http2.Header;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class RiotAPI {
    protected  final Logger logger = LogManager.getLogger(this.getClass().getName());
    protected final ObjectMapper objectMapper = new ObjectMapper();
    protected OkHttpClient okHttpClient;
    protected String apiKey;
    protected String platformLink;
    protected String regionalLink;

    /**
     *
     * @param headers The headers from a Riot API Call.
     */
    protected void checkRateLimit(Headers headers){
        boolean rateFlag = false;
        String[] header = headers.get("X-App-Rate-Limit").split(",");
        int aLimitSeconds = Integer.parseInt(header[0].split(":")[0]) ;
        int aLimitMinutes = Integer.parseInt(header[1].split(":")[0]) ;

        header = headers.get("X-App-Rate-Limit-Count").split(",");
        int aCountSeconds = Integer.parseInt(header[0].split(":")[0]) ;
        int aCountMinutes = Integer.parseInt(header[1].split(":")[0]) ;

        int mLimit = Integer.parseInt(headers.get("X-Method-Rate-Limit").split(":")[0]) ;

        int mCount = Integer.parseInt(headers.get("X-Method-Rate-Limit-Count").split(":")[0]);

        if(aLimitSeconds == 0 || aLimitMinutes == 0  || mLimit == 0 || aCountSeconds == 0 || aCountMinutes == 0 || mCount == 0){
            LogManager.getLogger(this.getClass().getName()).error("Header did not include a RateLimit or RateLimit count.");
            return;
        }

        if(aCountSeconds >= aLimitSeconds){
            LogManager.getLogger(this.getClass().getName())
                    .info("X-App-Rate-Limit reached: [Seconds][L] " + headers.get("X-App-Rate-Limit").split(",")[0] + " [C] " + headers.get("X-App-Rate-Limit-Count").split(",")[0]);
            rateFlag = true;
        }

        if(aCountMinutes >=aLimitMinutes){
            LogManager.getLogger(this.getClass().getName())
                    .info("X-App-Rate-Limit reached: [Minutes][L] " + headers.get("X-App-Rate-Limit").split(",")[1] + " [C] " + headers.get("X-App-Rate-Limit-Count").split(",")[1]);
            rateFlag = true;
        }

        if(mCount >= mLimit){
            LogManager.getLogger(this.getClass().getName())
                    .info("X-Method-Rate-Limit reached: [L] " + headers.get("X-Method-Rate-Limit") + "[C] " + headers.get("X-Method-Rate-Count"));
            rateFlag = true;
        }

        if(rateFlag){
            LogManager.getLogger(this.getClass().getName())
                    .warn("Preforming a 120 second sleep on Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(120000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
