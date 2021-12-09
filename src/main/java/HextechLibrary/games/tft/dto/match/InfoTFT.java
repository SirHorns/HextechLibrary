
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
    "game_datetime",
    "game_length",
    "game_version",
    "participants",
    "queue_id",
    "tft_game_type",
    "tft_set_number"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = InfoTFT.Builder.class)
public class InfoTFT {

    @JsonProperty("game_datetime")
    private final long gameDatetime;
    @JsonProperty("game_length")
    private final float gameLength;
    @JsonProperty("game_version")
    private final String gameVersion;
    @JsonProperty("participants")
    private final List<ParticipantTFT> participantTFTS;
    @JsonProperty("queue_id")
    private final int queueId;
    @JsonProperty("tft_game_type")
    private final String tftGameType;
    @JsonProperty("tft_set_number")
    private final int tftSetNumber;

    public InfoTFT(Builder builder) {
        this.gameDatetime = builder.gameDatetime;
        this.gameLength = builder.gameLength;
        this.gameVersion = builder.gameVersion;
        this.participantTFTS = builder.participantTFTS;
        this.queueId = builder.queueId;
        this.tftGameType = builder.tftGameType;
        this.tftSetNumber = builder.tftSetNumber;
    }

    public long getGameDatetime() {
        return gameDatetime;
    }

    public float getGameLength() {
        return gameLength;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public List<ParticipantTFT> getParticipants() {
        return participantTFTS;
    }

    public int getQueueId() {
        return queueId;
    }

    public String getTftGameType() {
        return tftGameType;
    }

    public int getTftSetNumber() {
        return tftSetNumber;
    }

    @JsonPOJOBuilder
    public static class Builder{

        private long gameDatetime;
        private float gameLength;
        private String gameVersion;
        private List<ParticipantTFT> participantTFTS;
        private int queueId;
        private String tftGameType;
        private int tftSetNumber;

        public Builder withgame_datetime(long gameDatetime) {
            this.gameDatetime = gameDatetime;
            return this;
        }

        public Builder withgame_length(float gameLength) {
            this.gameLength = gameLength;
            return this;
        }

        public Builder withgame_version(String gameVersion) {
            this.gameVersion = gameVersion;
            return this;
        }

        public Builder withParticipants(List<ParticipantTFT> participantTFTS) {
            this.participantTFTS = participantTFTS;
            return this;
        }

        public Builder withqueue_id(int queueId) {
            this.queueId = queueId;
            return this;
        }

        public Builder withtft_game_type(String tftGameType) {
            this.tftGameType = tftGameType;
            return this;
        }

        public Builder withtft_set_number(int tftSetNumber) {
            this.tftSetNumber = tftSetNumber;
            return this;
        }

        public InfoTFT build(){
            InfoTFT infoTFT = new InfoTFT(this);
            validateUserObject(infoTFT);
            return infoTFT;
        }

        private void validateUserObject(InfoTFT infoTFT) {
            //TODO: Object Validation
        }
    }
}
