package Types.dto.Match;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JsonDeserialize(builder = MatchList.Builder.class)
public class MatchList {
    private final List<String> matchList;

    public MatchList(@NotNull Builder builder) {
        this.matchList = builder.matchList;
    }

    public List<String> getMatchList() {
        return matchList;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private List<String> matchList;

        Builder withMatchList(List<String> matchList){
            this.matchList = matchList;
            return this;
        }

        public MatchList build(){
            MatchList matchList = new MatchList(this);
            validateUserObject(matchList);
            return matchList;
        }

        private void validateUserObject(MatchList matchList) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}
