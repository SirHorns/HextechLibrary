package hextechlibrary.dto.lol.match;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JsonDeserialize(builder = MetadataDto.Builder.class)
public class MetadataDto {
    final String dataVersion;
    final String matchId;
    final List<String> participants;

    private MetadataDto(@NotNull MetadataDto.Builder builder) {
        this.dataVersion = builder.dataVersion;
        this.matchId = builder.matchId;
        this.participants = builder.participants;
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public String getMatchId() {
        return matchId;
    }

    public List<String> getParticipants() {
        return participants;
    }

    @JsonPOJOBuilder
    public static class Builder{
        String dataVersion, matchId;
        List<String> participants;

        Builder withDataVersion(String dataVersion){
            this.dataVersion = dataVersion;
            return this;
        }
        Builder withMatchId(String matchId){
            this.matchId = matchId;
            return this;
        }
        Builder withParticipants(List<String> participants){
            this.participants = participants;
            return this;
        }

        public MetadataDto build(){
            MetadataDto metadataDto = new MetadataDto(this);
            validateUserObject(metadataDto);
            return metadataDto;
        }

        private void validateUserObject(MetadataDto metadataDto) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}
