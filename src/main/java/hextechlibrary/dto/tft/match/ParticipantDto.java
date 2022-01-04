
package hextechlibrary.dto.tft.match;

import java.util.List;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonDeserialize(builder = ParticipantDto.Builder.class)

public class ParticipantDto {

    @JsonProperty("companion")
    private final CompanionDto companionDto;
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
    private final List<TraitDto> traits;
    @JsonProperty("units")
    private final List<UnitDto> units;

    public ParticipantDto(Builder builder) {
        this.companionDto = builder.companionDto;
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

    public CompanionDto getCompanion() {
        return companionDto;
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

    public List<TraitDto> getTraits() {
        return traits;
    }

    public List<UnitDto> getUnits() {
        return units;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPOJOBuilder
    public static class Builder{

        private CompanionDto companionDto;
        private int goldLeft;
        private int lastRound;
        private int level;
        private int placement;
        private int playersEliminated;
        private String puuid;
        private float timeEliminated;
        private int totalDamageToPlayers;
        private List<TraitDto> traits;
        private List<UnitDto> units;


        public Builder withCompanion(CompanionDto companionDto) {
            this.companionDto = companionDto;
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

        public Builder withTraits(List<TraitDto> traits) {
            this.traits = traits;
            return this;
        }

        public Builder withUnits(List<UnitDto> units) {
            this.units = units;
            return this;
        }

        public ParticipantDto build(){
            ParticipantDto participantDto = new ParticipantDto(this);
            validateUserObject(participantDto);
            return participantDto;
        }

        private void validateUserObject(ParticipantDto participantDto) {
            //TODO: Object Validation
        }
    }
}
