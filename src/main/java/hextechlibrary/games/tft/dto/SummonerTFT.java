package hextechlibrary.games.tft.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

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
@JsonDeserialize(builder = SummonerTFT.Builder.class)
public class SummonerTFT {

    @JsonProperty("id")
    private final String id;
    @JsonProperty("accountId")
    private final String accountId;
    @JsonProperty("puuid")
    private final String puuid;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("profileIconId")
    private final int profileIconId;
    @JsonProperty("revisionDate")
    private final long revisionDate;
    @JsonProperty("summonerLevel")
    private final int summonerLevel;

    public SummonerTFT(Builder builder) {
        this.id = builder.id;
        this.accountId = builder.accountId;
        this.puuid = builder.puuid;
        this.name = builder.name;
        this.profileIconId = builder.profileIconId;
        this.revisionDate = builder.revisionDate;
        this.summonerLevel = builder.summonerLevel;
    }

    /*GETTERS*/
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

    /*BUILDER*/
    @JsonPOJOBuilder
    public static class Builder{
        private String id;
        private String accountId;
        private String puuid;
        private String name;
        private int profileIconId;
        private long revisionDate;
        private int summonerLevel;

        Builder withId(String id) {
            this.id = id;
            return this;
        }

        Builder withAccountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        Builder withPuuid(String puuid) {
            this.puuid = puuid;
            return this;
        }

        Builder withName(String name) {
            this.name = name;
            return this;
        }

        Builder withProfileIconId(int profileIconId) {
            this.profileIconId = profileIconId;
            return this;
        }

        Builder withRevisionDate(long revisionDate) {
            this.revisionDate = revisionDate;
            return this;
        }

        Builder withSummonerLevel(int summonerLevel) {
            this.summonerLevel = summonerLevel;
            return this;
        }

        public SummonerTFT build(){
            SummonerTFT summonerTFT = new SummonerTFT(this);
            validateUserObject(summonerTFT);
            return summonerTFT;
        }

        private void validateUserObject(SummonerTFT summonerTFT) {
            //TODO: Object Validation
        }
    }
}