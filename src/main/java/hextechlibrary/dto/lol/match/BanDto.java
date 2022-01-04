package hextechlibrary.dto.lol.match;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.jetbrains.annotations.NotNull;

@JsonDeserialize(builder = BanDto.Builder.class)
public class BanDto {
    private final int championId, pickTurn;

    private BanDto(@NotNull Builder banBuilder) {
        this.championId = banBuilder.championId;
        this.pickTurn = banBuilder.pickTurn;
    }

    public int getChampionId() {
        return championId;
    }

    public int getPickTurn() {
        return pickTurn;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private int championId, pickTurn;

        Builder withChampionId(int championId){
            this.championId = championId;
            return this;
        }

        Builder withPickTurn(int pickTurn){
            this.pickTurn = pickTurn;
            return this;
        }

        public BanDto build(){
            BanDto banDto = new BanDto(this);
            validateUserObject(banDto);
            return banDto;
        }

        private void validateUserObject(BanDto banDto) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}
