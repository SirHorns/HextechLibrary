package hextechlibrary.dto.lol.match.perks;

import com.fasterxml.jackson.annotation.JsonProperty;

//TODO: Convert [PerkStyleSelection] to Builder Pattern
public class PerkStyleSelectionDto {
    int perk, var1, var2, var3;

    public PerkStyleSelectionDto(@JsonProperty("perk") int perk, @JsonProperty("var1") int var1, @JsonProperty("var2") int var2, @JsonProperty("var3") int var3) {
        this.perk = perk;
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }

    public int getPerk() {
        return perk;
    }

    public int getVar1() {
        return var1;
    }

    public int getVar2() {
        return var2;
    }

    public int getVar3() {
        return var3;
    }

    public void setPerk(int perk) {
        this.perk = perk;
    }

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }

    public void setVar3(int var3) {
        this.var3 = var3;
    }
}
