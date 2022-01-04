package hextechlibrary.objects.lol.itemjson.item;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import hextechlibrary.objects.lol.itemjson.item.tree.TreeObject;

import java.util.List;

@JsonDeserialize(builder = Tree.Builder.class)
public class Tree {
    private final List<TreeObject> treeObjects;

    public Tree(Builder builder) {
        this.treeObjects = builder.treeObjects;
    }

    public List<TreeObject> getTreeObjects() {
        return treeObjects;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private List<TreeObject> treeObjects;

        public Builder withTreeObjects(List<TreeObject> tree){
            this.treeObjects = tree;
            return this;
        }

        public Tree build(){
            Tree tree = new Tree(this);
            //TODO: validate JSOn to Data object.
            return tree;
        }
    }
}
