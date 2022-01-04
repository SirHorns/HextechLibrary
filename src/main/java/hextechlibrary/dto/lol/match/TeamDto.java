package hextechlibrary.dto.lol.match;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//TODO: Convert to Builder Pattern
public class TeamDto {
    List<BanDto> banDtos;
    ObjectivesDto objectivesDto;
    int teamId;
    boolean win;

    public TeamDto(
            @JsonProperty("bans") List<BanDto> banDtos
            ,@JsonProperty("objectives") ObjectivesDto objectivesDto
            ,@JsonProperty("teamId") int teamId
            ,@JsonProperty("win") boolean win) {
        this.banDtos = banDtos;
        this.objectivesDto = objectivesDto;
        this.teamId = teamId;
        this.win = win;
    }

    public List<BanDto> getBans() {
        return banDtos;
    }

    public void setBans(List<BanDto> banDtos) {
        this.banDtos = banDtos;
    }

    public ObjectivesDto getObjectives() {
        return objectivesDto;
    }

    public void setObjectives(ObjectivesDto objectivesDto) {
        this.objectivesDto = objectivesDto;
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
