package hextechlibrary.dto.lol.match.objectives;

import com.fasterxml.jackson.annotation.JsonProperty;
import hextechlibrary.dto.lol.match.ObjectiveDto;

//TODO: Convert to Builder Pattern
public class Dragon extends ObjectiveDto {
    public Dragon(
            @JsonProperty("first") boolean first
            ,@JsonProperty("kills") int kills) {
        this.first = first;
        this.kills = kills;
    }
}
