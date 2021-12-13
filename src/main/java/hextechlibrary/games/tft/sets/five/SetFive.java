package hextechlibrary.games.tft.sets.five;

import hextechlibrary.games.tft.ITFTSet;
import hextechlibrary.games.tft.TFTSet;
import hextechlibrary.games.tft.sets.five.patch1115.Item;


public class SetFive extends TFTSet implements ITFTSet {

    /**
     * @param championsJSON TFT Set Champions JSON String
     * @param itemsJSON     TFT Set Items JSON String
     * @param traitsJSON    TFT Set Traits JSON String
     * @param set           TFT Set number
     * @param patch         TFT Set patch number
     */
    public SetFive(String championsJSON, String itemsJSON, String traitsJSON, int set, int patch) {
        super(championsJSON, itemsJSON, traitsJSON, set, patch);
    }
}

