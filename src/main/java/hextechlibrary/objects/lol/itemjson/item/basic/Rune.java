package hextechlibrary.objects.lol.itemjson.item.basic;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isrune",
        "tier",
        "type"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = Rune.Builder.class)
public class Rune {

    @JsonProperty("isrune")
    private final boolean isrune;
    @JsonProperty("tier")
    private final int tier;
    @JsonProperty("type")
    private final String type;

    public Rune(Builder builder) {
        this.isrune = builder.isrune;
        this.tier = builder.tier;
        this.type = builder.type;
    }

    @JsonPOJOBuilder
    public static class Builder{
        @JsonProperty("isrune")
        private boolean isrune;
        @JsonProperty("tier")
        private int tier;
        @JsonProperty("type")
        private String type;

        Builder withIsrune(boolean isrune) {
            this.isrune = isrune;
            return this;
        }

        Builder withTier(int tier) {
            this.tier = tier;
            return this;
        }

        Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Rune build(){
            Rune rune = new Rune(this);
            //TODO: Validate JSON to Object.
            return rune;
        }
    }
}
