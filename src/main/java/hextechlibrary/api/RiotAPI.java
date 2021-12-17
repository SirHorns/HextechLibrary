package hextechlibrary.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;

public abstract class RiotAPI {
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    String apiKey;
}
