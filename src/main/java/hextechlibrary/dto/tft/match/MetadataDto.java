package hextechlibrary.dto.tft.match;

import java.util.List;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data_version",
    "match_id",
    "participants"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = MetadataDto.Builder.class)
public class MetadataDto {

    @JsonProperty("data_version")
    private final String data_version;
    @JsonProperty("match_id")
    private final String match_id;
    @JsonProperty("participants")
    private final List<String> participants;

    public MetadataDto(Builder builder) {
        this.data_version = builder.data_version;
        this.match_id = builder.match_id;
        this.participants = builder.participants;
    }

    public String getData_version() {
        return data_version;
    }

    public String getMatch_id() {
        return match_id;
    }

    public List<String> getParticipants() {
        return participants;
    }

    @JsonPOJOBuilder
    public static class Builder{

        private String data_version;
        private String match_id;
        private List<String> participants = null;

        public Builder withdata_version(String dataVersion) {
            this.data_version = dataVersion;
            return this;
        }

        public Builder withmatch_id(String matchId) {
            this.match_id = matchId;
            return this;
        }

        public Builder withParticipants(List<String> participants) {
            this.participants = participants;
            return this;
        }

        public MetadataDto build(){
            MetadataDto metadataDto = new MetadataDto(this);
            validateUserObject(metadataDto);
            return metadataDto;
        }

        private void validateUserObject(MetadataDto summoner) {
            //TODO: Object Validation
        }
    }
}
