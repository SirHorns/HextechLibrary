package hextechlibrary.dto.tft.five.patch1115;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import hextechlibrary.dto.tft.Set;

@JsonDeserialize(builder = TraitDto.Builder.class)
public class TraitDto {
    private final String key;
    private final String name;
    private final String description;
    private final String type;
    private final Set[] sets;
    private final String innate;

    public TraitDto(Builder builder) {
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

        public TraitDto build(){
            TraitDto traitDto = new TraitDto(this);
            validateUserObject(traitDto);
            return traitDto;
        }

        private void validateUserObject(TraitDto traitDto) {
            //TODO: Object Valudation
        }
    }
}
