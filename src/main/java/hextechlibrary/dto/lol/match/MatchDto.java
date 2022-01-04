package hextechlibrary.dto.lol.match;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = MatchDto.Builder.class)
public class MatchDto {
    private final MetadataDto metadataDto;
    private final InfoDto infoDto;

    public MatchDto(Builder builder) {
        this.metadataDto = builder.metadataDto;
        this.infoDto = builder.infoDto;
    }

    public InfoDto getInfo() {
        return infoDto;
    }

    public MetadataDto getMetadata() {
        return metadataDto;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private MetadataDto metadataDto;
        private InfoDto infoDto;

        Builder withMetadata(MetadataDto metadataDto){
            this.metadataDto = metadataDto;
            return this;
        }
        Builder withInfo(InfoDto infoDto){
            this.infoDto = infoDto;
            return this;
        }

        public MatchDto build(){
            MatchDto matchDto = new MatchDto(this);
            validateUserObject(matchDto);
            return matchDto;
        }

        private void validateUserObject(MatchDto matchDto) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}
