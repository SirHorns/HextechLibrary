
package hextechlibrary.games.tft.dto.match;

import java.util.List;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "companion",
    "gold_left",
    "last_round",
    "level",
    "placement",
    "players_eliminated",
    "puuid",
    "time_eliminated",
    "total_damage_to_players",
    "traits",
    "units"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = ParticipantTFT.Builder.class)

public class ParticipantTFT {

    @JsonProperty("companion")
    private final CompanionTFT companionTFT;
    @JsonProperty("gold_left")
    private final int goldLeft;
    @JsonProperty("last_round")
    private final int lastRound;
    @JsonProperty("level")
    private final int level;
    @JsonProperty("placement")
    private final int placement;
    @JsonProperty("players_eliminated")
    private final int playersEliminated;
    @JsonProperty("puuid")
    private final String puuid;
    @JsonProperty("time_eliminated")
    private final float timeEliminated;
    @JsonProperty("total_damage_to_players")
    private final int totalDamageToPlayers;
    @JsonProperty("traits")
    private final List<Trait> traits;
    @JsonProperty("units")
    private final List<Unit> units;

    public ParticipantTFT(Builder builder) {
        this.companionTFT = builder.companionTFT;
        this.goldLeft = builder.goldLeft;
        this.lastRound = builder.lastRound;
        this.level = builder.level;
        this.placement = builder.placement;
        this.playersEliminated = builder.playersEliminated;
        this.puuid = builder.puuid;
        this.timeEliminated = builder.timeEliminated;
        this.totalDamageToPlayers = builder.totalDamageToPlayers;
        this.traits = builder.traits;
        this.units = builder.units;
    }

    public CompanionTFT getCompanion() {
        return companionTFT;
    }

    public int getGoldLeft() {
        return goldLeft;
    }

    public int getLastRound() {
        return lastRound;
    }

    public int getLevel() {
        return level;
    }

    public int getPlacement() {
        return placement;
    }

    public int getPlayersEliminated() {
        return playersEliminated;
    }

    public String getPuuid() {
        return puuid;
    }

    public float getTimeEliminated() {
        return timeEliminated;
    }

    public int getTotalDamageToPlayers() {
        return totalDamageToPlayers;
    }

    public List<Trait> getTraits() {
        return traits;
    }

    public List<Unit> getUnits() {
        return units;
    }

    @JsonPOJOBuilder
    public static class Builder{

        private CompanionTFT companionTFT;
        private int goldLeft;
        private int lastRound;
        private int level;
        private int placement;
        private int playersEliminated;
        private String puuid;
        private float timeEliminated;
        private int totalDamageToPlayers;
        private List<Trait> traits;
        private List<Unit> units;


        public Builder withCompanion(CompanionTFT companionTFT) {
            this.companionTFT = companionTFT;
            return this;
        }

        public Builder withgold_left(int goldLeft) {
            this.goldLeft = goldLeft;
            return this;
        }

        public Builder withlast_round(int lastRound) {
            this.lastRound = lastRound;
            return this;
        }

        public Builder withLevel(int level) {
            this.level = level;
            return this;
        }

        public Builder withPlacement(int placement) {
            this.placement = placement;
            return this;
        }

        public Builder withplayers_eliminated(int playersEliminated) {
            this.playersEliminated = playersEliminated;
            return this;
        }

        public Builder withPuuid(String puuid) {
            this.puuid = puuid;
            return this;
        }

        public Builder withtime_eliminated(float timeEliminated) {
            this.timeEliminated = timeEliminated;
            return this;
        }

        public Builder withtotal_damage_to_players(int totalDamageToPlayers) {
            this.totalDamageToPlayers = totalDamageToPlayers;
            return this;
        }

        public Builder withTraits(List<Trait> traits) {
            this.traits = traits;
            return this;
        }

        public Builder withUnits(List<Unit> units) {
            this.units = units;
            return this;
        }

        public ParticipantTFT build(){
            ParticipantTFT participantTFT = new ParticipantTFT(this);
            validateUserObject(participantTFT);
            return participantTFT;
        }

        private void validateUserObject(ParticipantTFT participantTFT) {
            //TODO: Object Validation
        }
    }
}
