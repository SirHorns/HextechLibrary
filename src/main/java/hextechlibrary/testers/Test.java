package hextechlibrary.testers;

import com.fasterxml.jackson.databind.ObjectMapper;
import hextechlibrary.dto.lol.SummonerDto;
import hextechlibrary.okhttp.LoggingInterceptor;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Test {
    private static Bucket apiBucket;
    private static final Logger logger = LogManager.getLogger(Test.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            //.addInterceptor(new LoggingInterceptor())
            .build();

    public static void main(String[] args) {
        Refill refill1 = Refill.intervally(120, Duration.ofMinutes(2));
        Refill refill2 = Refill.intervally(20, Duration.ofSeconds(1));
        Bandwidth limit1 = Bandwidth.classic(120, refill1);
        Bandwidth limit2 = Bandwidth.classic(20, refill2);
        apiBucket = Bucket.builder()
                .addLimit(limit1)
                .addLimit(limit2)
                .build();

        getSummonerDtoByName("JackWiburn");
    }

    private static SummonerDto getSummonerDtoByName(String name) {
        String responseJSON;
        SummonerDto summonerDto = null;

        //Validate Args.
        if (name.equals("")){
            return null;
        }

        Request request = new Request.Builder()
                .header("User-Agent","")
                .header("Accept-Language","en-US,en;q=0.9")
                .header("Accept-Charset","application/x-www-form-urlencoded; charset=UTF-8")
                .header("X-Riot-Token", "RGAPI-dbd6d858-570a-4103-a22f-76c94c370609")
                .url("https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name)
                .build();

        Response response = PreformRequest(apiBucket.tryConsume(1),request);


        try {
            responseJSON = Objects.requireNonNull(response.body()).string();
            //summonerDto = objectMapper.readValue(responseJSON, SummonerDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return summonerDto;
    }

    private static Response PreformRequest(boolean bucketBool, Request request) {
        Response response = null;
        boolean loopFlag = true;

        do{
            if (bucketBool){
                try {
                    response = okHttpClient.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (response.isSuccessful()){
                    CheckResponse(response);
                    loopFlag = false;
                }else {
                    CheckResponse(response);
                }
            }
        }while(loopFlag);

        return response;
    }

    private static void CheckResponse(Response response){
        String code = "xxx";

        if (response.code()>= 100 && response.code() <= 199 ){
            code = "1xx";
        }
        if (response.code() >= 200 && response.code() <= 299 ){
            code = "2xx";
        }
        if (response.code() >= 300 && response.code() <= 399 ){
            code = "3xx";
        }
        if (response.code() >= 400 && response.code() <= 499 ){
            code = "4xx";
        }
        if (response.code() >= 500 && response.code() <= 599 ){
            code = "5xx";
        }

        switch (code) {
            case "1xx" -> {
                logger.info("Response 1xx: - " + response.code() + " " +response.message());
            }
            case "2xx" -> {
                logger.warn("Response 2xx: " + response.code() + " " +response.message());
            }
            case "3xx" -> {
                logger.warn("Response 3xx: " + response.code() + " " +response.message());
            }
            case "4xx" -> {
                logger.warn("Response 4xx: " + response.code() + " " +response.message());
            }
            case "5xx" -> {
                logger.warn("Response 5xx: " + response.code() + " " +response.message());
            }
            case "xxx" -> {
                logger.warn("Response: Something went wrong." + response.code() + " " +response.message());
            }
            default -> {
                logger.warn("Response Default:");
            }
        }
    }




    private static void MakeRequest(){
        int tokens = 1;
        if(CheckBucketRateLimit(tokens)){
            Response response = GetResponse();
            CheckHeaders(response.headers());
        }else{

        }
    }
    private static Boolean CheckBucketRateLimit(int tokens){
        boolean check;

        if (apiBucket.tryConsume(tokens)){
            check = true;
        }else{
            check = false;
        }

        return check;
    }
    private static Response GetResponse(){
        Request request = null;
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  response;
    }
    private static void CheckHeaders(Headers responseHeaders){
        //"X-App-Rate-Limit"
        //"X-App-Rate-Limit-Count"
        //"X-Method-Rate-Limit"
        //"X-Method-Rate-Limit-Count"

        //Compare current headers to stored headers.
    }
    private static void Sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
