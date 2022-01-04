package hextechlibrary.dto.tft;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import hextechlibrary.dto.Summoner;

public class SummonerDto extends Summoner {

    public SummonerDto(Builder builder) {
        this.id = builder.id;
        this.accountId = builder.accountId;
        this.puuid = builder.puuid;
        this.name = builder.name;
        this.profileIconId = builder.profileIconId;
        this.revisionDate = builder.revisionDate;
        this.summonerLevel = builder.summonerLevel;
    }

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

        public SummonerDto build(){
            SummonerDto summonerDto = new SummonerDto(this);
            validateUserObject(summonerDto);
            return summonerDto;
        }

        private void validateUserObject(SummonerDto summonerDto) {
            //TODO: Object Validation
        }
    }
}