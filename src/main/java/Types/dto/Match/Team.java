package Types.dto.Match;

import Types.dto.Match.Objectives.Objectives;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
//TODO: Convert to Builder Pattern
public class Team {
    List<Ban> bans;
    Objectives objectives;
    int teamId;
    boolean win;

    public Team(
            @JsonProperty("bans") List<Ban> bans
            ,@JsonProperty("objectives") Objectives objectives
            ,@JsonProperty("teamId") int teamId
            ,@JsonProperty("win") boolean win) {
        this.bans = bans;
        this.objectives = objectives;
        this.teamId = teamId;
        this.win = win;
    }

    public List<Ban> getBans() {
        return bans;
    }

    public void setBans(List<Ban> bans) {
        this.bans = bans;
    }

    public Objectives getObjectives() {
        return objectives;
    }

    public void setObjectives(Objectives objectives) {
        this.objectives = objectives;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
