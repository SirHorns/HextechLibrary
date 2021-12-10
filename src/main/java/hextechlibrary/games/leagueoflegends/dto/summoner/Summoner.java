package hextechlibrary.games.leagueoflegends.dto.summoner;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.jetbrains.annotations.NotNull;

@JsonDeserialize(builder = Summoner.Builder.class)
public class Summoner {
    private final String name,id,puuid,accountId;
    private final long revisionDate,summonerLevel;
    private final int profileIconId;

    private Summoner(@NotNull Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.puuid = builder.puuid;
        this.accountId = builder.accountId;
        this.profileIconId = builder.profileIconId;
        this.revisionDate = builder.revisionDate;
        this.summonerLevel = builder.summonerLevel;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the puuid
     */
    public String getPuuid() {
        return puuid;
    }

    /**
     * @return the accountID
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @return the profileIconID
     */
    public int getProfileIconId() {
        return profileIconId;
    }

    /**
     * @return the revisionDate
     */
    public long getRevisionDate() {
        return revisionDate;
    }

    /**
     * @return the summonerLevel
     */
    public long getSummonerLevel() {
        return summonerLevel;
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

        public Summoner build(){
            Summoner summoner = new Summoner(this);
            validateUserObject(summoner);
            return summoner;
        }

        private void validateUserObject(Summoner summoner) {
            //TODO: Object Validation
        }
    }
}
