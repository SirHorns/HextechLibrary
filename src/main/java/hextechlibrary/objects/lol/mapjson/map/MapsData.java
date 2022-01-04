package hextechlibrary.objects.lol.mapjson.map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import hextechlibrary.objects.lol.mapjson.map.data.MapData;

import java.util.List;

@JsonDeserialize(builder = MapsData.Builder.class)
public class MapsData {
    private final List<MapData> mapDataList;

    public MapsData(Builder builder) {
        this.mapDataList = builder.mapDataList;
    }

    public List<MapData> getMapDataList() {
        return mapDataList;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private List<MapData> mapDataList;

        public Builder withMapDataList(List<MapData> data){
            this.mapDataList = data;
            return this;
        }

        public MapsData build(){
            MapsData mapsData = new MapsData(this);
            //TODO: validate JSON to Data object.
            return mapsData;
        }
    }
}
