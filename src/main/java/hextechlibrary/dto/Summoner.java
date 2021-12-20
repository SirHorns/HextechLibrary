package hextechlibrary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Summoner {
    @JsonProperty("id")
    protected String id;
    @JsonProperty("accountId")
    protected String accountId;
    @JsonProperty("puuid")
    protected String puuid;
    @JsonProperty("name")
    protected String name;
    @JsonProperty("profileIconId")
    protected int profileIconId;
    @JsonProperty("revisionDate")
    protected long revisionDate;
    @JsonProperty("summonerLevel")
    protected int summonerLevel;

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getPuuid() {
        return puuid;
    }

    public String getName() {
        return name;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public long getRevisionDate() {
        return revisionDate;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }
}
