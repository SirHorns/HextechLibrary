package hextechlibrary.dto.tft.match;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "metadata",
        "info"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = MatchDto.Builder.class)
public class MatchDto {

    @JsonProperty("metadata")
    private final MetadataDto metadata;
    @JsonProperty("info")
    private final InfoDto info;

    public MatchDto(Builder builder) {
        this.metadata = builder.metadata;
        this.info = builder.info;
    }

    public MetadataDto getMetadata() {
        return metadata;
    }

    public InfoDto getInfo() {
        return info;
    }

    @JsonPOJOBuilder
    public static class Builder{

        private MetadataDto metadata;
        private InfoDto info;

        public Builder withMetaData(MetadataDto metadataDto) {
            this.metadata = metadataDto;
            return this;
        }

        public Builder withInfo(InfoDto infoDto) {
            this.info = infoDto;
            return this;
        }

        public MatchDto build(){
            MatchDto matchDto = new MatchDto(this);
            validateUserObject(matchDto);
            return matchDto;
        }

        private void validateUserObject(MatchDto summoner) {
            //TODO: Object Validation
        }
    }
}