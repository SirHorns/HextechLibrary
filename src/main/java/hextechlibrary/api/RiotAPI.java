package hextechlibrary.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;

public abstract class RiotAPI {
    protected final OkHttpClient client = new OkHttpClient();
    protected final ObjectMapper objectMapper = new ObjectMapper();
    protected String apiKey;
    protected String platformLink;
    protected String regionalLink;
}
