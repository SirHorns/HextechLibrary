package hextechlibrary.dto.lol.match;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JsonDeserialize(builder = InfoDto.Builder.class)
public class InfoDto {
    final long gameCreation;
    final long gameDuration;
    final long gameEndTimestamp;
    final long gameId;
    final long gameStartTimestamp;
    final String gameMode;
    final String gameName;
    final String gameType;
    final String gameVersion;
    final String platformId;
    final String tournamentCode;
    final int mapId;
    final int queueId;
    final List<TeamDto> teamDtos;
    final List<ParticipantDto> participantDtos;

    public InfoDto(@NotNull Builder builder) {
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
        this.teamDtos = builder.teamDtos;
        this.participantDtos = builder.participantDtos;
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

    public List<TeamDto> getTeams() {
        return teamDtos;
    }

    public List<ParticipantDto> getParticipants() {
        return participantDtos;
    }

    @JsonPOJOBuilder
    public static class Builder {
        long gameCreation, gameDuration, gameEndTimestamp, gameId,gameStartTimestamp;
        String gameMode,gameName,gameType,gameVersion,platformId,tournamentCode;
        int mapId, queueId;
        List<TeamDto> teamDtos;
        List<ParticipantDto> participantDtos;

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
        Builder withTeams(List<TeamDto> teamDtos){
            this.teamDtos = teamDtos;
            return this;
        }
        Builder withParticipants(List<ParticipantDto> participantDtos){
            this.participantDtos = participantDtos;
            return this;
        }

        public InfoDto build(){
            InfoDto infoDto = new InfoDto(this);
            validateUserObject(infoDto);
            return infoDto;
        }

        private void validateUserObject(InfoDto infoDto) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}
