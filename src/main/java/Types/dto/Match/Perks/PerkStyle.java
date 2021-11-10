package Types.dto.Match.Perks;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
//TODO: Convert [PerkStyle] to Builder Pattern
public class PerkStyle {
    String description;
    List<PerkStyleSelection> selections;
    int style;

    public PerkStyle(@JsonProperty("description") String description,@JsonProperty("selections") List<PerkStyleSelection> selections,@JsonProperty("style") int style) {
        this.description = description;
        this.selections = selections;
        this.style = style;
    }

    public String getDescription() {
        return description;
    }

    public List<PerkStyleSelection> getSelections() {
        return selections;
    }

    public int getStyle() {
        return style;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setSelections(List<PerkStyleSelection> selections) {
        this.selections = selections;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}
