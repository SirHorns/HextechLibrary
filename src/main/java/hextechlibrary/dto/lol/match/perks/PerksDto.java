package hextechlibrary.dto.lol.match.perks;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PerksDto {
    PerkStatsDto statPerks;
    List<PerkStyleDto> styles;

    public PerksDto(@JsonProperty("statPerks") PerkStatsDto statPerks, @JsonProperty("styles") List<PerkStyleDto> styles) {
        this.statPerks = statPerks;
        this.styles = styles;
    }

    public PerkStatsDto getStatPerks() {
        return statPerks;
    }

    public void setStatPerks(PerkStatsDto statPerks) {
        this.statPerks = statPerks;
    }

    public List<PerkStyleDto> getStyles() {
        return styles;
    }

    public void setStyles(List<PerkStyleDto> styles) {
        this.styles = styles;
    }
}
