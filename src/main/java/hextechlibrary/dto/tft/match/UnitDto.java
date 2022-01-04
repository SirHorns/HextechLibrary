
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
    "character_id",
    "items",
    "name",
    "rarity",
    "tier"
})
@JsonDeserialize(builder = UnitDto.Builder.class)
@Generated("jsonschema2pojo")

public class UnitDto {

    @JsonProperty("character_id")
    private final String characterId;
    @JsonProperty("items")
    private final List<Integer> items;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("rarity")
    private final int rarity;
    @JsonProperty("tier")
    private final int tier;

    public UnitDto(Builder builder) {
        this.characterId = builder.characterId;
        this.items = builder.items;
        this.name = builder.name;
        this.rarity = builder.rarity;
        this.tier = builder.tier;
    }

    public String getCharacterId() {
        return characterId;
    }

    public List<Integer> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public int getRarity() {
        return rarity;
    }

    public int getTier() {
        return tier;
    }

    @JsonPOJOBuilder
    public static class Builder{

        private String characterId;
        private List<Integer> items;
        private String name;
        private int rarity;
        private int tier;

        Builder withcharacter_id(String characterId) {
            this.characterId = characterId;
            return this;
        }

        Builder withItems(List<Integer> items) {
            this.items = items;
            return this;
        }

        Builder withName(String name) {
            this.name = name;
            return this;
        }

        Builder withRarity(int rarity) {
            this.rarity = rarity;
            return this;
        }

        Builder withTier(int tier) {
            this.tier = tier;
            return this;
        }

        public UnitDto build(){
            UnitDto unitDto = new UnitDto(this);
            validateUserObject(unitDto);
            return unitDto;
        }

        private void validateUserObject(UnitDto unitDto) {
            //TODO: Object Valudation
        }

    }
}
