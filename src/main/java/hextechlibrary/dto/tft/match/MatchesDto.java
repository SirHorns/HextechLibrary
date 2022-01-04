package hextechlibrary.dto.tft.match;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonDeserialize(builder = MatchesDto.Builder.class)
public class MatchesDto {
    private final List<String> matches;

    public MatchesDto(Builder builder) {
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

        public MatchesDto build(){
            MatchesDto matchesDto = new MatchesDto(this);
            validateUserObject(matchesDto);
            return matchesDto;
        }

        private void validateUserObject(MatchesDto matchesDto) {
            //TODO: Object Validation
        }
    }
}