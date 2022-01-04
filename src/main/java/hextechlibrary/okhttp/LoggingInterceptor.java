package hextechlibrary.okhttp;

import hextechlibrary.api.RiotAPI;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class LoggingInterceptor implements Interceptor {
    static  final Logger logger = LogManager.getLogger(RiotAPI.class);
    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        String requestheader = "===REQUEST HEADERS:===\n" + request.headers() + "=======";
        long t1 = System.nanoTime();

        logger.info(String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), requestheader));

        Response response = chain.proceed(request);

        String responseheader = "===RESPONSE HEADERS:===\n" + response.headers() + "=======";

        long t2 = System.nanoTime();
        logger.info(String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, responseheader));

        return response;
    }
}