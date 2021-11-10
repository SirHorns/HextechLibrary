package Types.dto.Match;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Match.Builder.class)
public class Match {
    private final Metadata metadata;
    private final Info info;

    public Match(Builder builder) {
        this.metadata = builder.metadata;
        this.info = builder.info;
    }

    public Info getInfo() {
        return info;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private Metadata metadata;
        private Info info;

        Builder withMetadata(Metadata metadata){
            this.metadata = metadata;
            return this;
        }
        Builder withInfo(Info info){
            this.info = info;
            return this;
        }

        public Match build(){
            Match match = new Match(this);
            validateUserObject(match);
            return match;
        }

        private void validateUserObject(Match match) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}
