package hextechlibrary.objects.lol.itemjson.item.tree;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;

@JsonDeserialize(builder = TreeObject.Builder.class)
public class TreeObject {
    private final String header;
    private final List<String> tags;

    public TreeObject(Builder builder) {
        this.header = builder.header;
        this.tags = builder.tags;
    }

    public String getHeader() {
        return header;
    }

    public List<String> getTags() {
        return tags;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private String header;
        private List<String> tags;

        Builder withHeader(String header){
            this.header = header;
            return this;
        }

        Builder withTags(List<String> tags){
            this.tags = tags;
            return this;
        }

        public TreeObject build(){
            TreeObject treeObject = new TreeObject(this);
            //TODO: Validate JSON to Object.
            return treeObject;
        }
    }
}
