package hextechlibrary.games.tft;

import hextechlibrary.games.tft.sets.five.patch1115.Champion;
import hextechlibrary.games.tft.sets.five.patch1115.Item;
import hextechlibrary.games.tft.sets.five.patch1115.Trait;

import java.util.List;

public interface ITFTSet {

    /**
     * Returns the TFT Set Number
     *
     * @return tft set number
     */
    public default int getSetNumber() {
        return 0;
    }

    /**
     * Returns the TFT Patch Number
     * @return tft patch number
     */
    public default int getPatch() {
        return 0;
    }

    /**
     * Returns an item object based on the id
     * @param id tft item id
     * @return tft item object
     */
    public default Item getItemByID(int id) {
        return null;
    }

    /**
     * Returns a champion object based on the champion id
     * @param id tft champion id
     * @return tft champion object
     */
    public default Champion getChampionByID(String id) {
        return null;
    }

    /**
     * Returns a champion object based on the champion name
     * @param name tft champion name
     * @return tft champion object
     */
    public default Champion getChampionByName(String name) {
        return null;
    }

    /**
     * Returns a champion object based on the champion name
     * @return List of tft champion objects
     */
    public default List<Champion> getChampions() {
        return null;
    }

    /**
     * Returns a champion object based on the champion name
     * @return List of tft item objects
     */
    public default List<Item> getItems() {
        return null;
    }

    /**
     * Returns a champion object based on the champion name
     * @return List of tft trait objects
     */
    public default List<Trait> getTraits() {
        return null;
    }
}
