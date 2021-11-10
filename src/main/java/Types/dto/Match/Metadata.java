package Types.dto.Match;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
@JsonDeserialize(builder = Metadata.Builder.class)
public class Metadata{
    String dataVersion, matchId;
    List<String> participants;

    private Metadata(@NotNull Metadata.Builder builder) {
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

        public Metadata build(){
            Metadata metadata = new Metadata(this);
            validateUserObject(metadata);
            return metadata;
        }

        private void validateUserObject(Metadata metadata) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}
