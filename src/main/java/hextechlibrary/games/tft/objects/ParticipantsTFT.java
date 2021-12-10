package hextechlibrary.games.tft.objects;

import hextechlibrary.games.tft.dto.match.ParticipantTFT;

import java.util.ArrayList;
import java.util.List;

public class ParticipantsTFT {
    private List<ParticipantTFT> participantsList = new ArrayList<>();

    public ParticipantsTFT(List<ParticipantTFT> participantsList) {
        this.participantsList = participantsList;
    }

    public List<hextechlibrary.games.tft.dto.match.ParticipantTFT> getParticipantsList() {
        return participantsList;
    }

    public void setParticipantsList(List<ParticipantTFT> participantsList) {
    }

    public ParticipantTFT getParticipantByPUUID(String puuid){
        for(ParticipantTFT participant : this.participantsList){
            if(participant.getPuuid().equals(puuid)){
                return participant;
            }
        }
        return null;
    }
}
