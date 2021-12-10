package hextechlibrary.games.tft.dto.match;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.annotation.processing.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "metadata",
        "info"
})
@Generated("jsonschema2pojo")
@JsonDeserialize(builder = MatchesTFT.Builder.class)
public class MatchesTFT {
    private final List<String> matches;

    public MatchesTFT(Builder builder) {
        this.matches = builder.matches;
    }

    public List<String> getMatches() {
        return matches;
    }

    @JsonPOJOBuilder
    public static class Builder{

        private List<String> matches;

        public Builder withMatches(List<String> match_ids) {
            this.matches = match_ids;
            return this;
        }

        public MatchesTFT build(){
            MatchesTFT matchesTFT = new MatchesTFT(this);
            validateUserObject(matchesTFT);
            return matchesTFT;
        }

        private void validateUserObject(MatchesTFT matchesTFT) {
            //TODO: Object Validation
        }
    }
}