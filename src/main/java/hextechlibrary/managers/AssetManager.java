package hextechlibrary.managers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import hextechlibrary.objects.lol.itemjson.Item;
import hextechlibrary.objects.lol.itemjson.item.Basic;
import hextechlibrary.objects.lol.itemjson.item.ItemsData;
import hextechlibrary.objects.lol.itemjson.item.Group;
import hextechlibrary.objects.lol.itemjson.item.Tree;
import hextechlibrary.objects.lol.itemjson.item.data.ItemData;
import hextechlibrary.objects.lol.itemjson.item.tree.TreeObject;
import hextechlibrary.objects.lol.mapjson.Map;
import hextechlibrary.objects.lol.mapjson.map.MapsData;
import hextechlibrary.objects.lol.mapjson.map.data.MapData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssetManager {

    private final Logger logger = LogManager.getLogger(AssetManager.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    private Item items;
    private Map maps;

    public AssetManager() throws IOException {
        loadChampion();
        loadChampionFull();
        loadItem();
        loadMap();
        loadRunesReforged();
        loadSummoner();
    }

    public Item getItems() {
        return items;
    }

    public Map getMaps() {
        return maps;
    }

    public BufferedImage passImage() throws IOException {
        InputStream in = getClass().getResourceAsStream("/datadragon/dragontail-11.24.1/11.24.1/img/3100.png");
        BufferedImage bf= ImageIO.read(in);
        return bf;
    }

    private void loadChampion(){
        logger.debug("TODO: Loading champion.json info.");
    }

    private void loadChampionFull(){
        logger.debug("TODO: championFull.json info.");
    }

    private void loadItem() {
        logger.info("Loading item.json info.");
        Item item = null;
        try {
            InputStream inputStream = getClass().getResourceAsStream("/en_US/item.json");
            InputStreamReader inputStreamReader = null;

            if (inputStream != null) {
                inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            }

            BufferedReader bufferedReader = null;
            if (inputStreamReader != null) {
                bufferedReader = new BufferedReader(inputStreamReader);
            }

            StringBuilder json = new StringBuilder();
            String line;

            if (bufferedReader != null) {
                while ((line = bufferedReader.readLine()) != null) {
                    json.append(line);
                }
            }


            //item = objectMapper.readValue(json.toString(), Item.class);
            JsonNode topNode = objectMapper.readTree(json.toString());

            //setting basic info
            JsonNode basic = objectMapper.readTree(topNode.get("basic").toString());
            //Stats stats = objectMapper.readValue(basic.get("stats").toString(), Stats.class);
            Basic basicObj =  new Basic.Builder().build(); //objectMapper.readValue(topNode.get("basic").toString(), Basic.class);
            ItemsData itemsDataObj;
            Tree treeObj;

            //setting data info
            List<ItemData> itemDataList = new ArrayList<>();
            JsonNode data = objectMapper.readTree(topNode.get("data").toString());
            int i = 0;
            int size = data.size();
            int itemNum = 1001;
            while( i < size){
                ItemData itemData = null;
                do {
                    if (data.get(Integer.toString(itemNum)) != null){
                        itemData = objectMapper.readValue(data.get(Integer.toString(itemNum)).toString(), ItemData.class);
                        itemData.setId(itemNum);
                    }
                    itemNum++;
                }while(itemData == null);

                itemDataList.add(itemData);
                i++;
            }
            itemsDataObj = new ItemsData.Builder()
                    .withItemDataList(itemDataList)
                    .build();

            //setting groups info
            JsonNode groups = objectMapper.readTree(topNode.get("groups").toString());
            List<Group> groupList = objectMapper.readValue(groups.toString(), new TypeReference<List<Group>>(){});
            Group[] groupsObj = objectMapper.readValue(groups.toString(), Group[].class);

            //setting trees info
            JsonNode trees = objectMapper.readTree(topNode.get("tree").toString());
            i = 0;
            size = trees.size();
            List<String> treeObjectStrings = new ArrayList<>();
            while (i < size){
                treeObjectStrings.add(trees.get(i).toString());
                i++;
            }
            List<TreeObject> treeObjectList = new ArrayList<>();
            for (String treeObjJson:treeObjectStrings) {
                TreeObject treeObject;
                treeObject = objectMapper.readValue(treeObjJson, TreeObject.class);
                treeObjectList.add(treeObject);
            }
            treeObj = new Tree.Builder().withTreeObjects(treeObjectList).build();


            item = new Item.Builder()
                    .withType(topNode.get("type").asText())
                    .withVersion(topNode.get("version").asText())
                    .withBasic(basicObj)
                    .withData(itemsDataObj)
                    .withGroups(Arrays.stream(groupsObj).toList())
                    .withTree(treeObj)
                    .build();

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.items = item;
    }

    private void loadMap(){
        logger.info("Loading map.json info.");
        Map map = null;
        try {
            InputStream inputStream = getClass().getResourceAsStream("/en_US/map.json");
            InputStreamReader inputStreamReader = null;

            if (inputStream != null) {
                inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            }

            BufferedReader bufferedReader = null;
            if (inputStreamReader != null) {
                bufferedReader = new BufferedReader(inputStreamReader);
            }

            StringBuilder json = new StringBuilder();
            String line;

            if (bufferedReader != null) {
                while ((line = bufferedReader.readLine()) != null) {
                    json.append(line);
                }
            }

            JsonNode topNode = objectMapper.readTree(json.toString());
            JsonNode data = objectMapper.readTree(topNode.get("data").toString());
            List<MapData> mapDataList = new ArrayList<>();

            MapData mapData;
            mapData = objectMapper.readValue(data.get(Integer.toString(11)).toString(), MapData.class);
            mapDataList.add(mapData);
            mapData = objectMapper.readValue(data.get(Integer.toString(12)).toString(), MapData.class);
            mapDataList.add(mapData);
            mapData = objectMapper.readValue(data.get(Integer.toString(21)).toString(), MapData.class);
            mapDataList.add(mapData);
            mapData = objectMapper.readValue(data.get(Integer.toString(22)).toString(), MapData.class);
            mapDataList.add(mapData);

            MapsData mapsObj = new MapsData.Builder()
                    .withMapDataList(mapDataList)
                    .build();

            map = new Map.Builder()
                    .withType(topNode.get("type").toString())
                    .withVersion(topNode.get("version").toString())
                    .withData(mapsObj)
                    .build();

        }catch (IOException e) {
            e.printStackTrace();
        }

        this.maps = map;
    }

    private void loadRunesReforged(){
        logger.debug("TODO: item.json info.");
    }

    private void loadSummoner(){
        logger.debug("TODO: summoner.json info.");
    }
}
