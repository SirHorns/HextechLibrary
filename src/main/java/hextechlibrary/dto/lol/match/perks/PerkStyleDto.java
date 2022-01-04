package hextechlibrary.dto.lol.match.perks;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//TODO: Convert [PerkStyle] to Builder Pattern
public class PerkStyleDto {
    String description;
    List<PerkStyleSelectionDto> selections;
    int style;

    public PerkStyleDto(@JsonProperty("description") String description, @JsonProperty("selections") List<PerkStyleSelectionDto> selections, @JsonProperty("style") int style) {
        this.description = description;
        this.selections = selections;
        this.style = style;
    }

    public String getDescription() {
        return description;
    }

    public List<PerkStyleSelectionDto> getSelections() {
        return selections;
    }

    public int getStyle() {
        return style;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setSelections(List<PerkStyleSelectionDto> selections) {
        this.selections = selections;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}
