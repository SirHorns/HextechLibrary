package hextechlibrary.games.leagueoflegends.dto.match.Objectives;


import com.fasterxml.jackson.annotation.JsonProperty;

//TODO: Convert to Builder Pattern
public class RiftHerald {
    boolean first;
    int kills;

    public RiftHerald(
            @JsonProperty("first") boolean first
            ,@JsonProperty("kills") int kills) {
        this.first = first;
        this.kills = kills;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }
}
