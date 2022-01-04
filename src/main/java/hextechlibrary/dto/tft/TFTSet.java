package hextechlibrary.dto.tft;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hextechlibrary.dto.tft.five.patch1115.Champion;
import hextechlibrary.dto.tft.five.patch1115.Item;
import hextechlibrary.dto.tft.five.patch1115.TraitDto;

import java.util.ArrayList;
import java.util.List;

public abstract class TFTSet {
    List<Champion> champions = new ArrayList<>();
    List<Item> items = new ArrayList<>();
    List<TraitDto> traitDtos = new ArrayList<>();

    final int set;
    final int patch;

    /**
     * @param championsJSON TFT Set Champions JSON String
     * @param itemsJSON TFT Set Items JSON String
     * @param traitsJSON TFT Set Traits JSON String
     */
    public TFTSet(String championsJSON,String itemsJSON,String traitsJSON, int set, int patch) {
        this.champions = setChampions(championsJSON);
        this.items = setItems(itemsJSON);
        this.traitDtos = setTraits(traitsJSON);
        this.set = set;
        this.patch = patch;
    }

    /**
     *
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
     */
    private List<TraitDto>  setTraits(String traitsJSON){
        ObjectMapper objectMapper = new ObjectMapper();
        List<TraitDto> traitDtos = null;
        try {
            traitDtos = List.of(objectMapper.readValue(traitsJSON, TraitDto[].class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return traitDtos;
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
     * @return tft item object or null object if not valid object found
     */
    public Item getItemByID(int id) {
        for(Item item : items){
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
    public List<TraitDto> getTraits() {
        return this.traitDtos;
    }
}
