package hextechlibrary.objects.lol.itemjson.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.annotation.processing.Generated;

@JsonPropertyOrder({
        "id",
        "MaxGroupOwnable"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = Group.Builder.class)
public class Group {
    @JsonProperty("id")
    private final String id;
    @JsonProperty("MaxGroupOwnable")
    private final String MaxGroupOwnable;

    public Group(Builder builder) {
        this.id = builder.id;
        this.MaxGroupOwnable = builder.MaxGroupOwnable;
    }

    public String getId() {
        return id;
    }

    public String getMaxGroupOwnable() {
        return MaxGroupOwnable;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPOJOBuilder
    public static class Builder{
        private String id;
        private String MaxGroupOwnable;

        public Builder withID(String id){
            this.id = id;
            return this;
        }

        public Builder withmaxGroupOwnable(String max){
            this.MaxGroupOwnable = max;
            return this;
        }

        public Group build(){
            Group group = new Group(this);
            //TODO: Validate JSON to Object.
            return group;
        }
    }
}
