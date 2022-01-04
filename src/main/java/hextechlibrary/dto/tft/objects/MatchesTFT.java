package hextechlibrary.dto.tft.objects;

import hextechlibrary.dto.tft.match.MatchDto;

import java.util.ArrayList;
import java.util.List;

class MatchesDto {
    private List<MatchDto> matchList = new ArrayList<>();

    public MatchesDto(List<MatchDto> matchList) {
        this.matchList = matchList;
    }

    public List<MatchDto> getParticipantsList() {
        return matchList;
    }

}
