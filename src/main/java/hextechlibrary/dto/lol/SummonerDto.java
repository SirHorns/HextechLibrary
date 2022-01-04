package hextechlibrary.dto.lol;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import hextechlibrary.dto.Summoner;
import org.jetbrains.annotations.NotNull;

@JsonDeserialize(builder = SummonerDto.Builder.class)
public class SummonerDto extends Summoner {

    private SummonerDto(@NotNull Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.puuid = builder.puuid;
        this.accountId = builder.accountId;
        this.profileIconId = builder.profileIconId;
        this.revisionDate = builder.revisionDate;
        this.summonerLevel = builder.summonerLevel;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private String name, id, puuid, accountId;
        private long revisionDate, summonerLevel;
        private int profileIconId;

        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Builder withId(String id){
            this.id = id;
            return this;
        }
        public Builder withPuuid(String puuid){
            this.puuid = puuid;
            return this;
        }
        public Builder withAccountId(String accountId){
            this.accountId = accountId;
            return this;
        }
        public Builder withRevisionDate(long revisionDate){
            this.revisionDate = revisionDate;
            return this;
        }
        public Builder withSummonerLevel(long summonerLevel){
            this.summonerLevel = summonerLevel;
            return this;
        }
        public Builder withProfileIconId(int profileIconId){
            this.profileIconId = profileIconId;
            return this;
        }

        public SummonerDto build(){
            SummonerDto summoner = new SummonerDto(this);
            validateUserObject(summoner);
            return summoner;
        }

        private void validateUserObject(SummonerDto summoner) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}
