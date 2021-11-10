package Types.dto.Match;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.jetbrains.annotations.NotNull;

@JsonDeserialize(builder = Ban.Builder.class)
public class Ban {
    private final int championId, pickTurn;

    private Ban(@NotNull Builder banBuilder) {
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

        public Ban build(){
            Ban ban = new Ban(this);
            validateUserObject(ban);
            return ban;
        }

        private void validateUserObject(Ban ban) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}
