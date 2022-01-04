package hextechlibrary.dto.tft.five.patch1115;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonPropertyOrder({
        "name",
        "championId",
        "cost",
        "traits"
})

@JsonDeserialize(builder = Champion.Builder.class)
public class Champion {
    @JsonProperty("name")
    private final String name;
    @JsonProperty("championId")
    private final String championid;
    @JsonProperty("cost")
    private final int cost;
    @JsonProperty("traits")
    private final String[] traits;

    public Champion(Builder builder) {
        this.name = builder.name;
        this.championid = builder.championid;
        this.cost = builder.cost;
        this.traits = builder.traits;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return championid;
    }

    public int getCost() {
        return cost;
    }

    public String[] getTraits() {
        return traits;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private String name;
        private String championid;
        private int cost;
        private String[] traits;

        Builder withName(String name){
            this.name = name;
            return this;
        }

        Builder withChampionId(String championid){
            this.championid = championid;
            return this;
        }

        Builder withCost(int cost){
            this.cost = cost;
            return this;
        }

        Builder withTraits(String[] traits){
            this.traits = traits;
            return this;
        }

        public Champion build(){
            Champion champion = new Champion(this);
            validateUserObject(champion);
            return champion;
        }

        private void validateUserObject(Champion champion) {
            //TODO: Object Valudation
        }
    }
}
