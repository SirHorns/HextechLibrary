package hextechlibrary.objects.lol.mapjson;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import hextechlibrary.objects.lol.itemjson.Item;
import hextechlibrary.objects.lol.mapjson.map.MapsData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "version",
        "data"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = Map.Builder.class)
public class Map{

    private String type;
    private String version;
    private MapsData mapsData;

    public Map(Builder builder) {
        this.type = builder.type;
        this.version = builder.version;
        this.mapsData = builder.mapsData;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private String type;
        private String version;
        @JsonProperty("data")
        private MapsData mapsData;

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withVersion(String version) {
            this.version = version;
            return this;
        }

        public Builder withData(MapsData data) {
            this.mapsData = data;
            return this;
        }

        public Map build(){
            Map map = new Map(this);
            //TODO: Validate JSON to DataObject.
            return map;
        }
    }
}