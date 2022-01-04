package hextechlibrary.objects.lol.itemjson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import hextechlibrary.managers.AssetManager;
import hextechlibrary.objects.lol.itemjson.item.Basic;
import hextechlibrary.objects.lol.itemjson.item.ItemsData;
import hextechlibrary.objects.lol.itemjson.item.Group;
import hextechlibrary.objects.lol.itemjson.item.Tree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.processing.Generated;
import java.util.List;

@JsonPropertyOrder({
        "type",
        "version",
        "basic",
        "data",
        "groups",
        "tree"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = Item.Builder.class)
public class Item {
    @JsonProperty("type")
    private final String type;
    @JsonProperty("version")
    private final String version;
    @JsonProperty("basic")
    private final Basic basic;
    @JsonProperty("data")
    private final ItemsData itemsData;
    @JsonProperty("groups")
    private final List<Group> groups;
    @JsonProperty("tree")
    private final Tree tree;

    public Item(Builder builder) {
        this.type = builder.type;
        this.version = builder.version;
        this.basic = builder.basic;
        this.itemsData = builder.itemsData;
        this.groups = builder.groups;
        this.tree = builder.tree;
    }

    public String getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }

    public Basic getBasic() {
        return basic;
    }

    public ItemsData getData() {
        return itemsData;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Tree getTree() {
        return tree;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private String type;
        private String version;
        private Basic basic;
        private ItemsData itemsData;
        private List<Group> groups;
        private Tree tree;

        public Builder withType(String type){
            this.type = type;
            return this;
        }
        public Builder withVersion(String version){
            this.version = type;
            return this;
        }
        public Builder withBasic(Basic basic){
            this.basic = basic;
            return this;
        }
        public Builder withData(ItemsData itemsData){
            this.itemsData = itemsData;
            return this;
        }
        public Builder withGroups(List<Group> groups){
            this.groups = groups;
            return this;
        }
        public Builder withTree(Tree tree){
            this.tree = tree;
            return this;
        }

        public Item build(){
            Item item = new Item(this);
            //TODO: Validate JSON to Java Object
            return item;
        }
    }
}
