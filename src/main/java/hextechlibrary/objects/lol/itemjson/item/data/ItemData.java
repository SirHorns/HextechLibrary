package hextechlibrary.objects.lol.itemjson.item.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import hextechlibrary.objects.lol.Image;
import hextechlibrary.objects.lol.itemjson.item.basic.Rune;
import hextechlibrary.objects.lol.itemjson.item.basic.Stats;
import hextechlibrary.objects.lol.itemjson.item.data.itemdata.*;

import java.util.List;

@JsonDeserialize(builder = ItemData.Builder.class)
public class ItemData {
    private int id;
    private final String name;
    private final Rune rune;
    private final Gold gold;
    private final String group;
    private final String description;
    private final String colloq;
    private final String plaintext;
    private final boolean consumed;
    private final int stacks;
    private final int depth;
    private final boolean consumeOnFull;
    private final List<String> from;
    private final List<String> into;
    private final int specialRecipe;
    private final boolean inStore;
    private final boolean hideFromAll;
    private final String requiredChampion;
    private final String requiredAlly;
    private final Stats stats;
    private final Image image;
    private final List<String> tags;
    private final Effect effect;
    private final Maps maps;

    public ItemData(Builder builder) {
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
        this.image = builder.image;
        this.tags = builder.tags;
        this.effect = builder.effect;
        this.maps = builder.maps;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
        return description.replaceAll("\\<.*?\\>", "");
    }
    public String getDescriptionRaw() {
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
    public Image getImage() {
        return image;
    }
    public List<String> getTags() {
        return tags;
    }
    public Effect getEffect() {
        return effect;
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
        private Image image;
        private List<String> tags;
        private  Effect effect;
        private Maps maps;

        Builder withName(String name) {
            this.name = name;
            return this;
        }
        Builder withRune(Rune rune) {
            this.rune = rune;
            return this;
        }
        Builder withGold(Gold gold) {
            this.gold = gold;
            return this;
        }
        Builder withGroup(String group) {
            this.group = group;
            return this;
        }
        Builder withDescription(String description) {
            this.description = description;
            return this;
        }
        Builder withColloq(String colloq) {
            this.colloq = colloq;
            return this;
        }
        Builder withPlaintext(String plaintext) {
            this.plaintext = plaintext;
            return this;
        }
        Builder withConsumed(boolean consumed) {
            this.consumed = consumed;
            return this;
        }
        Builder withStacks(int stacks) {
            this.stacks = stacks;
            return this;
        }
        Builder withDepth(int depth) {
            this.depth = depth;
            return this;
        }
        Builder withConsumeOnFull(boolean consumeOnFull) {
            this.consumeOnFull = consumeOnFull;
            return this;
        }
        Builder withFrom(List<String> from) {
            this.from = from;
            return this;
        }
        Builder withInto(List<String> into) {
            this.into = into;
            return this;
        }

        Builder withSpecialRecipe(int depth) {
            this.specialRecipe = depth;
            return this;
        }
        Builder withInStore(boolean inStore) {
            this.inStore = inStore;
            return this;
        }
        Builder withHideFromAll(boolean hideFromAll) {
            this.hideFromAll = hideFromAll;
            return this;
        }
        Builder withRequiredChampion(String requiredChampion) {
            this.requiredChampion = requiredChampion;
            return this;
        }
        Builder withRequiredAlly(String requiredAlly) {
            this.requiredAlly = requiredAlly;
            return this;
        }
        Builder withImage(Image image) {
            this.image = image;
            return this;
        }
        Builder withTags(List<String> tags) {
            this.tags = tags;
            return this;
        }
        Builder withMaps(Maps maps) {
            this.maps = maps;
            return this;
        }
        Builder withEffect(Effect effect) {
            this.effect = effect;
            return this;
        }
        Builder withStats(Stats stats) {
            this.stats = stats;
            return this;
        }

        public ItemData build(){
            ItemData itemData = new ItemData(this);
            //TODO: Validate JSON to DataObject.
            return itemData;
        }
    }
}
