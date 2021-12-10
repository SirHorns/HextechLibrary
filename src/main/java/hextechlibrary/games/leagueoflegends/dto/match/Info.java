package hextechlibrary.games.leagueoflegends.dto.match;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JsonDeserialize(builder = Info.Builder.class)
public class Info {
    long gameCreation, gameDuration, gameEndTimestamp, gameId,gameStartTimestamp;
    String gameMode,gameName,gameType,gameVersion,platformId,tournamentCode;
    int mapId, queueId;
    List<Team> teams;
    List<Participant> participants;

    public Info(@NotNull Builder builder) {
        this.gameCreation = builder.gameCreation;
        this.gameDuration = builder.gameDuration;
        this.gameEndTimestamp = builder.gameEndTimestamp;
        this.gameId = builder.gameId;
        this.gameStartTimestamp = builder.gameStartTimestamp;
        this.gameMode = builder.gameMode;
        this.gameName = builder.gameName;
        this.gameType = builder.gameType;
        this.gameVersion = builder.gameVersion;
        this.platformId = builder.platformId;
        this.tournamentCode = builder.tournamentCode;
        this.mapId = builder.mapId;
        this.queueId = builder.queueId;
        this.teams = builder.teams;
        this.participants = builder.participants;
    }

    public long getGameCreation() {
        return gameCreation;
    }

    public long getGameDuration() {
        return gameDuration;
    }

    public long getGameEndTimestamp() {
        return gameEndTimestamp;
    }

    public long getGameId() {
        return gameId;
    }

    public long getGameStartTimestamp() {
        return gameStartTimestamp;
    }

    public String getGameMode() {
        return gameMode;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameType() {
        return gameType;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public String getPlatformId() {
        return platformId;
    }

    public String getTournamentCode() {
        return tournamentCode;
    }

    public int getMapId() {
        return mapId;
    }

    public int getQueueId() {
        return queueId;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    @JsonPOJOBuilder
    public static class Builder {
        long gameCreation, gameDuration, gameEndTimestamp, gameId,gameStartTimestamp;
        String gameMode,gameName,gameType,gameVersion,platformId,tournamentCode;
        int mapId, queueId;
        List<Team> teams;
        List<Participant> participants;

        Builder withGameCreation(long gameCreation){
            this.gameCreation = gameCreation;
            return this;
        }
        Builder withGameDuration(long gameDuration){
            this.gameDuration = gameDuration;
            return this;
        }
        Builder withGameEndTimestamp(long gameEndTimestamp){
            this.gameEndTimestamp = gameEndTimestamp;
            return this;
        }
        Builder withGameId(long gameId){
            this.gameId = gameId;
            return this;
        }
        Builder withGameStartTimestamp(long gameStartTimestamp){
            this.gameStartTimestamp = gameStartTimestamp;
            return this;
        }
        Builder withGameMode(String gameMode){
            this.gameMode = gameMode;
            return this;
        }
        Builder withGameName(String gameName){
            this.gameName = gameName;
            return this;
        }
        Builder withGameType(String gameType){
            this.gameType = gameType;
            return this;
        }
        Builder withGameVersion(String tournamentCode){
            this.gameVersion = tournamentCode;
            return this;
        }
        Builder withPlatformId(String platformId){
            this.platformId = platformId;
            return this;
        }
        Builder withTournamentCode(String tournamentCode){
            this.tournamentCode = tournamentCode;
            return this;
        }
        Builder withMapId(int mapId){
            this.mapId = mapId;
            return this;
        }
        Builder withQueueId(int queueId){
            this.queueId = queueId;
            return this;
        }
        Builder withTeams(List<Team> teams){
            this.teams = teams;
            return this;
        }
        Builder withParticipants(List<Participant> participants){
            this.participants = participants;
            return this;
        }

        public Info build(){
            Info info = new Info(this);
            validateUserObject(info);
            return info;
        }

        private void validateUserObject(Info info) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}
