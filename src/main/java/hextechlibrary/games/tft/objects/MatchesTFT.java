package hextechlibrary.games.tft.objects;

import hextechlibrary.games.tft.dto.match.MatchTFT;

import java.util.ArrayList;
import java.util.List;

public class MatchesTFT {
    private List<MatchTFT> matchList = new ArrayList<>();

    public MatchesTFT(List<MatchTFT> matchList) {
        this.matchList = matchList;
    }

    public List<MatchTFT> getParticipantsList() {
        return matchList;
    }

}
