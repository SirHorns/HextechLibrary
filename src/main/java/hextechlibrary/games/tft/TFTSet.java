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
    public TFTSet(String championsJSON,String itemsJSON,String traitsJSON) {
        this.champions = setChampions(championsJSON);
        this.items = setItems(itemsJSON);
        this.traits = setTraits(traitsJSON);
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

    public void setSet(int set) {
        this.set = set;
    }

    public void setPatch(int patch) {
        this.patch = patch;
    }

    public List<Champion> getChampions() {
        return champions;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Trait> getTraits() {
        return traits;
    }

    public int getSet() {
        return set;
    }

    public int getPatch() {
        return patch;
    }
}
