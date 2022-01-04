package hextechlibrary.dto.tft.five;

import hextechlibrary.dto.tft.TFTSet;


public class SetFive extends TFTSet {

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

