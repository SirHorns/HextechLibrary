package hextechlibrary.games.tft.dto.match;

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
@JsonDeserialize(builder = MatchTFT.Builder.class)
public class MatchTFT {

    @JsonProperty("metadata")
    private final MetadataTFT metadata;
    @JsonProperty("info")
    private final InfoTFT info;

    public MatchTFT(Builder builder) {
        this.metadata = builder.metadata;
        this.info = builder.info;
    }

    public MetadataTFT getMetadata() {
        return metadata;
    }

    public InfoTFT getInfo() {
        return info;
    }

    @JsonPOJOBuilder
    public static class Builder{

        private MetadataTFT metadata;
        private InfoTFT info;

        public Builder withMetadata(MetadataTFT metadataTFT) {
            this.metadata = metadataTFT;
            return this;
        }

        public Builder withInfo(InfoTFT infoTFT) {
            this.info = infoTFT;
            return this;
        }

        public MatchTFT build(){
            MatchTFT matchTFT = new MatchTFT(this);
            validateUserObject(matchTFT);
            return matchTFT;
        }

        private void validateUserObject(MatchTFT summoner) {
            //TODO: Object Validation
        }
    }
}