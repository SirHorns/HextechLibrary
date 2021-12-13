package hextechlibrary.games.tft;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hextechlibrary.games.tft.sets.five.patch1115.Champion;
import hextechlibrary.games.tft.sets.five.patch1115.Item;
import hextechlibrary.games.tft.sets.five.patch1115.Trait;

import java.util.ArrayList;
import java.util.List;

public abstract class TFTSet {
    List<Champion> champions = new ArrayList<>();
    List<Item> items = new ArrayList<>();
    List<Trait> traits = new ArrayList<>();

    int set;
    int patch;

    /**
     * @param championsJSON TFT Set Champions JSON String
     * @param itemsJSON TFT Set Items JSON String
     * @param traitsJSON TFT Set Traits JSON String
     */
    public TFTSet(String championsJSON,String itemsJSON,String traitsJSON, int set, int patch) {
        this.champions = setChampions(championsJSON);
        this.items = setItems(itemsJSON);
        this.traits = setTraits(traitsJSON);
        this.set = set;
        this.patch = patch;
    }

    /**
     *
     * @param championsJSON
     * @return
     */
    private List<Champion>  setChampions(String championsJSON){
        ObjectMapper objectMapper = new ObjectMapper();
        List<Champion> champions = null;
        try {
            champions = List.of(objectMapper.readValue(championsJSON, Champion[].class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return champions;
    }

    /**
     *
     * @param itemsJSON
     * @return
     */
    private List<Item>  setItems(String itemsJSON){
        ObjectMapper objectMapper = new ObjectMapper();
        List<Item> items = null;
        try {
            items = List.of(objectMapper.readValue(itemsJSON, Item[].class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     *
     * @param traitsJSON
     * @return
     */
    private List<Trait>  setTraits(String traitsJSON){
        ObjectMapper objectMapper = new ObjectMapper();
        List<Trait> traits = null;
        try {
            traits = List.of(objectMapper.readValue(traitsJSON, Trait[].class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return traits;
    }

    /**
     * Returns the TFT Set Number
     *
     * @return tft set number
     */
    public int getSet() {
        return set;
    }

    /**
     * Returns the TFT Patch Number
     * @return tft patch number
     */
    public int getPatch() {
        return patch;
    }

    /**
     * Returns an item object based on the id
     * @param id tft item id
     * @return tft item object
     */
    public Item getItemByID(int id) {
        for(Item item : getItems()){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    /**
     * Returns a champion object based on the champion id
     * @param id tft champion id
     * @return tft champion object
     */
    public Champion getChampionByID(String id) {
        for(Champion champion : this.champions){
            if(champion.getId().equals(id)){
                return champion;
            }
        }

        return null;
    }

    /**
     * Returns a champion object based on the champion name
     * @param name tft champion name
     * @return tft champion object
     */
    public Champion getChampionByName(String name) {
        for(Champion champion : this.champions){
            if(champion.getName().equals(name)){
                return champion;
            }
        }

        return null;
    }

    /**
     * Returns a champion object based on the champion name
     * @return List of tft champion objects
     */
    public List<Champion> getChampions() {
        return this.champions;
    }

    /**
     * Returns a champion object based on the champion name
     * @return List of tft item objects
     */
    public List<Item> getItems() {
        return this.items;
    }

    /**
     * Returns a champion object based on the champion name
     * @return List of tft trait objects
     */
    public List<Trait> getTraits() {
        return this.traits;
    }
}
