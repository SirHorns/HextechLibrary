
package hextechlibrary.games.tft.dto.match;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "content_ID",
    "skin_ID",
    "species"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = CompanionTFT.Builder.class)

public class CompanionTFT {

    @JsonProperty("content_ID")
    private final String contentID;
    @JsonProperty("skin_ID")
    private final int skinID;
    @JsonProperty("species")
    private final String species;

    public CompanionTFT(Builder builder) {
        this.contentID = builder.contentID;
        this.skinID = builder.skinID;
        this.species = builder.species;
    }

    public String getContentID() {
        return contentID;
    }

    public int getSkinID() {
        return skinID;
    }

    public String getSpecies() {
        return species;
    }

    @JsonPOJOBuilder
    public static class Builder{

        private String contentID;
        private int skinID;
        private String species;

        public Builder withcontent_ID(String contentID) {
            this.contentID = contentID;
            return this;
        }

        public Builder withskin_ID(int skinID) {
            this.skinID = skinID;
            return this;
        }

        public Builder withSpecies(String species) {
            this.species = species;
            return this;
        }

        public CompanionTFT build(){
            CompanionTFT companionTFT = new CompanionTFT(this);
            validateUserObject(companionTFT);
            return companionTFT;
        }

        private void validateUserObject(CompanionTFT companionTFT) {
            //TODO: Object Validation
        }
    }
}
