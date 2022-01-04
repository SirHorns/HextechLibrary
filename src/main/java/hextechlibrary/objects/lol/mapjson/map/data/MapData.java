package hextechlibrary.objects.lol.mapjson.map.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import hextechlibrary.objects.lol.Image;
import hextechlibrary.objects.lol.mapjson.Map;

import javax.annotation.processing.Generated;

@JsonPropertyOrder({
        "MapName",
        "MapId",
        "image"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = MapData.Builder.class)
public class MapData {

    private String mapName;
    private String mapID;
    private Image image;

    public MapData(Builder builder) {
        this.mapName = builder.mapName;
        this.mapID = builder.mapID;
        this.image = builder.image;
    }

    public String getMapName() {
        return mapName;
    }
    public String getMapID() {
        return mapID;
    }
    public Image getImage() {
        return image;
    }

    @JsonPOJOBuilder
    public static class Builder{
        @JsonProperty("MapName")
        private String mapName;
        @JsonProperty("MapId")
        private String mapID;
        @JsonProperty("image")
        private Image image;

        public Builder withMapName(String data){
            this.mapName = data;
            return this;
        }
        public Builder withMapId(String data){
            this.mapID = data;
            return this;
        }
        public Builder withImage(Image data){
            this.image = data;
            return this;
        }

        public MapData build(){
            MapData mapData = new MapData(this);
            //TODO: Validate JSON to DataObject.
            return mapData;
        }
    }
}
