package hextechlibrary.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import hextechlibrary.dto.tft.SummonerDto;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "accountId",
        "puuid",
        "name",
        "profileIconId",
        "revisionDate",
        "summonerLevel"
})

@Generated("jsonschema2pojo")
@JsonDeserialize(builder = SummonerDto.Builder.class)
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
    protected long summonerLevel;

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

    public long getSummonerLevel() {
        return summonerLevel;
    }
}
