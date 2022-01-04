package hextechlibrary.objects.lol.itemjson.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import hextechlibrary.objects.lol.itemjson.item.data.itemdata.Gold;
import hextechlibrary.objects.lol.itemjson.item.data.itemdata.Maps;
import hextechlibrary.objects.lol.itemjson.item.basic.Rune;
import hextechlibrary.objects.lol.itemjson.item.basic.Stats;

import java.util.List;

@JsonPropertyOrder({
        "name",
        "rune",
        "gold",
        "group",
        "description",
        "colloq",
        "plaintext",
        "consumed",
        "stacks",
        "depth",
        "consumeOnFull",
        "from",
        "into",
        "specialRecipe",
        "inStore",
        "hideFromAll",
        "requiredChampion",
        "requiredAlly",
        "stats",
        "tags",
        "maps"
})
@JsonDeserialize(builder = Basic.Builder.class)
public class Basic{
    @JsonProperty("name")
    private final String name;
    @JsonProperty("rune")
    private final Rune rune;
    @JsonProperty("gold")
    private final Gold gold;
    @JsonProperty("group")
    private final String group;
    @JsonProperty("description")
    private final String description;
    @JsonProperty("colloq")
    private final String colloq;
    @JsonProperty("plaintext")
    private final String plaintext;
    @JsonProperty("consumed")
    private final boolean consumed;
    @JsonProperty("stacks")
    private final int stacks;
    @JsonProperty("depth")
    private final int depth;
    @JsonProperty("consumeOnFull")
    private final boolean consumeOnFull;
    @JsonProperty("from")
    private final List<String> from;
    @JsonProperty("into")
    private final List<String> into;
    @JsonProperty("specialRecipe")
    private final int specialRecipe;
    @JsonProperty("inStore")
    private final boolean inStore;
    @JsonProperty("hideFromAll")
    private final boolean hideFromAll;
    @JsonProperty("requiredChampion")
    private final String requiredChampion;
    @JsonProperty("requiredAlly")
    private final String requiredAlly;
    @JsonProperty("stats")
    private final Stats stats;
    @JsonProperty("tags")
    private final List<String> tags;
    @JsonProperty("maps")
    private final Maps maps;

    public Basic(Builder builder) {
        this.name = builder.name;
        this.rune = builder.rune;
        this.gold = builder.gold;
        this.group = builder.group;
        this.description = builder.description;
        this.colloq = builder.colloq;
        this.plaintext = builder.plaintext;
        this.consumed = builder.consumed;
        this.stacks = builder.stacks;
        this.depth = builder.depth;
        this.consumeOnFull = builder.consumeOnFull;
        this.from = builder.from;
        this.into = builder.into;
        this.specialRecipe = builder.specialRecipe;
        this.inStore = builder.inStore;
        this.hideFromAll = builder.hideFromAll;
        this.requiredChampion = builder.requiredChampion;
        this.requiredAlly = builder.requiredAlly;
        this.stats = builder.stats;
        this.tags = builder.tags;
        this.maps = builder.maps;
    }

    public String getName() {
        return name;
    }
    public Rune getRune() {
        return rune;
    }
    public Gold getGold() {
        return gold;
    }
    public String getGroup() {
        return group;
    }
    public String getDescription() {
        return description;
    }
    public String getColloq() {
        return colloq;
    }
    public String getPlaintext() {
        return plaintext;
    }
    public boolean isConsumed() {
        return consumed;
    }
    public int getStacks() {
        return stacks;
    }
    public int getDepth() {
        return depth;
    }
    public boolean isConsumeOnFull() {
        return consumeOnFull;
    }
    public List<String> getFrom() {
        return from;
    }
    public List<String> getInto() {
        return into;
    }
    public int getSpecialRecipe() {
        return specialRecipe;
    }
    public boolean isInStore() {
        return inStore;
    }
    public boolean isHideFromAll() {
        return hideFromAll;
    }
    public String getRequiredChampion() {
        return requiredChampion;
    }
    public String getRequiredAlly() {
        return requiredAlly;
    }
    public Stats getStats() {
        return stats;
    }
    public List<String> getTags() {
        return tags;
    }
    public Maps getMaps() {
        return maps;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private String name;
        private Rune rune;
        private Gold gold;
        private String group;
        private String description;
        private String colloq;
        private String plaintext;
        private boolean consumed;
        private int stacks;
        private int depth;
        private boolean consumeOnFull;
        private List<String> from;
        private List<String> into;
        private int specialRecipe;
        private boolean inStore;
        private boolean hideFromAll;
        private String requiredChampion;
        private String requiredAlly;
        private Stats stats;
        private List<String> tags;
        private Maps maps;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withRune(Rune rune) {
            this.rune = rune;
            return this;
        }

        public Builder withGold(Gold gold) {
            this.gold = gold;
            return this;
        }

        public Builder withGroup(String group) {
            this.group = group;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withColloq(String colloq) {
            this.colloq = colloq;
            return this;
        }

        public Builder withPlaintext(String plaintext) {
            this.plaintext = plaintext;
            return this;
        }

        public Builder withConsumed(Boolean consumed) {
            this.consumed = consumed;
            return this;
        }

        public Builder withStacks(Integer stacks) {
            this.stacks = stacks;
            return this;
        }

        public Builder withDepth(Integer depth) {
            this.depth = depth;
            return this;
        }

        public Builder withConsumeOnFull(Boolean consumeOnFull) {
            this.consumeOnFull = consumeOnFull;
            return this;
        }

        public Builder withFrom(List<String> from) {
            this.from = from;
            return this;
        }

        public Builder withInto(List<String> into) {
            this.into = into;
            return this;
        }

        public Builder withSpecialRecipe(Integer specialRecipe) {
            this.specialRecipe = specialRecipe;
            return this;
        }

        public Builder withInStore(Boolean inStore) {
            this.inStore = inStore;
            return this;
        }

        public Builder withHideFromAll(Boolean hideFromAll) {
            this.hideFromAll = hideFromAll;
            return this;
        }

        public Builder withRequiredChampion(String requiredChampion) {
            this.requiredChampion = requiredChampion;
            return this;
        }

        public Builder withRequiredAlly(String requiredAlly) {
            this.requiredAlly = requiredAlly;
            return this;
        }

        public Builder withStats(Stats stats) {
            this.stats = stats;
            return this;
        }

        public Builder withTags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder withMaps(Maps maps) {
            this.maps = maps;
            return this;
        }

        public Basic build(){
            Basic basic = new Basic(this);
            //TODO: Validate JSON to Object.
            return basic;
        }
    }
}
