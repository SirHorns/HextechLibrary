package hextechlibrary.objects.lol.itemjson.item.data.itemdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "11",
        "12",
        "21",
        "22"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = Maps.Builder.class)
public class Maps {

    @JsonProperty("11")
    private final boolean map11;
    @JsonProperty("12")
    private final boolean map12;
    @JsonProperty("21")
    private final boolean map21;
    @JsonProperty("22")
    private final boolean map22;

    public Maps(Builder builder) {
        this.map11 = builder.map11;
        this.map12 = builder.map12;
        this.map21 = builder.map21;
        this.map22 = builder.map22;
    }

    public boolean isMap11() {
        return map11;
    }
    public boolean isMap12() {
        return map12;
    }
    public boolean isMap21() {
        return map21;
    }
    public boolean isMap22() {
        return map22;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPOJOBuilder
    public static class Builder{
        private boolean map11;
        private boolean map12;
        private boolean map21;
        private boolean map22;

        Builder with11(boolean map) {
            this.map11 = map;
            return this;
        }

        Builder with12(boolean map) {
            this.map12 = map;
            return this;
        }

        Builder with21(boolean map) {
            this.map21 = map;
            return this;
        }

        Builder with22(boolean map) {
            this.map22 = map;
            return this;
        }

        public Maps build(){
            Maps maps = new Maps(this);
            //TODO: Validate JSON to Image Object.
            return maps;
        }
    }
}