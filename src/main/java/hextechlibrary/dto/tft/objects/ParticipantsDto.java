package hextechlibrary.dto.tft.objects;

import hextechlibrary.dto.tft.match.ParticipantDto;

import java.util.ArrayList;
import java.util.List;

public class ParticipantsDto {
    private List<ParticipantDto> participantsList = new ArrayList<>();

    public ParticipantsDto(List<ParticipantDto> participantsList) {
        this.participantsList = participantsList;
    }

    public List<hextechlibrary.dto.tft.match.ParticipantDto> getParticipantsList() {
        return participantsList;
    }

    public void setParticipantsList(List<ParticipantDto> participantsList) {
    }

    public ParticipantDto getParticipantByPUUID(String puuid){
        for(ParticipantDto participant : this.participantsList){
            if(participant.getPuuid().equals(puuid)){
                return participant;
            }
        }
        return null;
    }
}
