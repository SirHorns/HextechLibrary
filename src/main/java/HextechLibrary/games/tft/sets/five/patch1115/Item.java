package hextechlibrary.games.tft.sets.five.patch1115;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Item.Builder.class)
public class Item{
    private final int id;
    private final String name;
    private final String description;
    private final boolean isUnique;
    private final boolean isElusive;
    private final boolean isRadiant;
    private final String radiantBonus;

    public Item(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.isUnique = builder.isUnique;
        this.isElusive = builder.isElusive;
        this.isRadiant = builder.isRadiant;
        this.radiantBonus = builder.radiantBonus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isUnique() {
        return isUnique;
    }

    public boolean isElusive() {
        return isElusive;
    }

    public boolean isRadiant() {
        return isRadiant;
    }

    public String getRadiantBonus() {
        return radiantBonus;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private int id;
        private String name;
        private String description;
        private boolean isUnique;
        private boolean isElusive;
        private boolean isRadiant;
        private String radiantBonus;

        Builder withId(int id){
            this.id = id;
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
        Builder withIsUnique(boolean isUnique){
            this.isUnique = isUnique;
            return this;
        }
        Builder withIsElusive(boolean isElusive){
            this.isElusive = isElusive;
            return this;
        }
        Builder withIsRadiant(boolean isRadiant){
            this.isRadiant = isRadiant;
            return this;
        }
        Builder withRadiantBonus(String radiantBonus){
            this.radiantBonus = radiantBonus;
            return this;
        }

        public Item build(){
            Item item = new Item(this);
            validateUserObject(item);
            return item;
        }

        private void validateUserObject(Item item) {
            //TODO: Object Validation
        }
    }
}
