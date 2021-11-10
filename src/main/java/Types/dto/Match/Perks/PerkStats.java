package Types.dto.Match.Perks;

import com.fasterxml.jackson.annotation.JsonProperty;
//TODO: Convert [PerkStats] to Builder Pattern
public class PerkStats {
    int defense, flex, offense;

    public PerkStats(@JsonProperty("defense") int defense,@JsonProperty("flex") int flex,@JsonProperty("offense") int offense) {
        this.defense = defense;
        this.flex = flex;
        this.offense = offense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getFlex() {
        return flex;
    }

    public void setFlex(int flex) {
        this.flex = flex;
    }

    public int getOffense() {
        return offense;
    }

    public void setOffense(int offense) {
        this.offense = offense;
    }
}
