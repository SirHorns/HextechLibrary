
package hextechlibrary.games.tft.dto.match;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "num_units",
    "style",
    "tier_current",
    "tier_total"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = Trait.Builder.class)

public class Trait {

    @JsonProperty("name")
    private final String name;
    @JsonProperty("num_units")
    private final int numUnits;
    @JsonProperty("style")
    private final int style;
    @JsonProperty("tier_current")
    private final int tierCurrent;
    @JsonProperty("tier_total")
    private final int tierTotal;

    public Trait(Builder builder) {
        this.name = builder.name;
        this.numUnits = builder.numUnits;
        this.style = builder.style;
        this.tierCurrent = builder.tierCurrent;
        this.tierTotal = builder.tierTotal;
    }

    public String getName() {
        return name;
    }

    public int getNumUnits() {
        return numUnits;
    }

    public int getStyle() {
        return style;
    }

    public int getTierCurrent() {
        return tierCurrent;
    }

    public int getTierTotal() {
        return tierTotal;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private String name;
        private int numUnits;
        private int style;
        private int tierCurrent;
        private int tierTotal;

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withnum_units( int numUnits){
            this.numUnits = numUnits;
            return this;
        }

        public Builder withStyle ( int style){
            this.style = style;
            return this;
        }

        public Builder withtier_current ( int tierCurrent){
            this.tierCurrent = tierCurrent;
            return this;
        }

        public Builder withTier_total ( int tierTotal){
            this.tierTotal = tierTotal;
            return this;
        }

        public Trait build(){
            Trait trait = new Trait(this);
            validateUserObject(trait);
            return trait;
        }

        private void validateUserObject(Trait trait) {
            //TODO: Object Validation
        }
    }
}

