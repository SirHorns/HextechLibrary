package hextechlibrary.games.tft.sets.five.patch1115;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import hextechlibrary.games.tft.dto.Set;

@JsonDeserialize(builder = Trait.Builder.class)
public class Trait {
    private final String key;
    private final String name;
    private final String description;
    private final String type;
    private final Set[] sets;
    private final String innate;

    public Trait(Builder builder) {
        this.key = builder.key;
        this.name = builder.name;
        this.description = builder.description;
        this.type = builder.type;
        this.sets = builder.sets;
        this. innate = builder.innate;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public Set[] getSets() {
        return sets;
    }

    public String getInnate() {
        return innate;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private String key;
        private String name;
        private String description;
        private String type;
        private Set[] sets;
        private String innate;

        Builder withKey(String key){
            this.key = key;
            return this;
        }
        Builder withName(String name){
            this.name = name;
            return this;
        }
        Builder withDescription(String description){
            this.description = description;
            return this;
        }
        Builder withType(String type){
            this.type = type;
            return this;
        }
        Builder withSets(Set[] sets){
            this.sets = sets;
            return this;
        }
        Builder withInnate(String innate){
            this.innate = innate;
            return this;
        }

        public Trait build(){
            Trait trait = new Trait(this);
            validateUserObject(trait);
            return trait;
        }

        private void validateUserObject(Trait trait) {
            //TODO: Object Valudation
        }
    }
}
