package hextechlibrary.games.leagueoflegends.dto.match;

import hextechlibrary.games.leagueoflegends.dto.match.Perks.Perks;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.jetbrains.annotations.NotNull;

@JsonDeserialize(builder = Participant.Builder.class)
public class Participant {
    private final int assists,baronKills,bountyLevel,champExperience,champLevel,championId,championTransform,consumablesPurchased,damageDealtToBuildings,damageDealtToObjectives,damageDealtToTurrets
            ,damageSelfMitigated,deaths,detectorWardsPlaced,doubleKills,dragonKills,goldEarned,goldSpent,inhibitorKills,inhibitorTakedowns,inhibitorsLost
            ,item0,item1,item2,item3,item4,item5,item6,itemsPurchased,killingSprees,kills,largestCriticalStrike,largestKillingSpree,largestMultiKill,longestTimeSpentLiving
            ,magicDamageDealt,magicDamageDealtToChampions,magicDamageTaken,neutralMinionsKilled,nexusKills,nexusTakedowns,nexusLost,objectivesStolen,objectivesStolenAssists
            ,participantId,pentaKills,physicalDamageDealt,physicalDamageDealtToChampions,physicalDamageTaken,profileIcon,quadraKills,sightWardsBoughtInGame,spell1Casts,spell2Casts
            ,spell3Casts,spell4Casts,summoner1Casts,summoner1Id,summoner2Casts,summoner2Id,summonerLevel,teamId,timeCCingOthers,timePlayed,totalDamageDealt,totalDamageDealtToChampions
            ,totalDamageShieldedOnTeammates,totalDamageTaken,totalHeal,totalHealsOnTeammates,totalMinionsKilled,totalTimeCCDealt,totalTimeSpentDead,totalUnitsHealed,tripleKills
            ,trueDamageDealt,trueDamageDealtToChampions,trueDamageTaken,turretKills,turretTakedowns,turretsLost,unrealKills,visionScore,visionWardsBoughtInGame,wardsKilled,wardsPlaced;
    private final boolean firstBloodAssist,firstBloodKill,firstTowerAssist,firstTowerKill,gameEndedInEarlySurrender,gameEndedInSurrender,teamEarlySurrendered,win;
    private final String championName,individualPosition,lane,puuid,riotIdName,riotIdTagline,role,summonerId,summonerName,teamPosition;
    private final Perks perks;

    private Participant(@NotNull Builder builder) {
        this.inhibitorsLost = builder.inhibitorsLost;
        this.longestTimeSpentLiving = builder.longestTimeSpentLiving;
        this.objectivesStolenAssists = builder.objectivesStolenAssists;
        this.spell2Casts = builder.spell2Casts;
        this.totalDamageDealtToChampions = builder.totalDamageDealtToChampions;
        this.tripleKills = builder.tripleKills;
        this.assists = builder.assists;
        this.baronKills = builder.baronKills;
        this.bountyLevel = builder.bountyLevel;
        this.champExperience = builder.champExperience;
        this.champLevel = builder.champLevel;
        this.championId = builder.championId;
        this.championTransform = builder.championTransform;
        this.consumablesPurchased = builder.consumablesPurchased;
        this.damageDealtToBuildings = builder.damageDealtToBuildings;
        this.damageDealtToObjectives = builder.damageDealtToObjectives;
        this.damageDealtToTurrets = builder.damageDealtToTurrets;
        this.damageSelfMitigated = builder.damageSelfMitigated;
        this.deaths = builder.deaths;
        this.detectorWardsPlaced = builder.detectorWardsPlaced;
        this.doubleKills = builder.doubleKills;
        this.dragonKills = builder.dragonKills;
        this.goldEarned = builder.goldEarned;
        this.goldSpent = builder.goldSpent;
        this.inhibitorKills = builder.inhibitorKills;
        this.inhibitorTakedowns = builder.inhibitorTakedowns;
        this.item0 = builder.item0;
        this.item1 = builder.item1;
        this.item2 = builder.item2;
        this.item3 = builder.item3;
        this.item4 = builder.item4;
        this.item5 = builder.item5;
        this.item6 = builder.item6;
        this.itemsPurchased = builder.itemsPurchased;
        this.killingSprees = builder.killingSprees;
        this.kills = builder.kills;
        this.largestCriticalStrike = builder.largestCriticalStrike;
        this.largestKillingSpree = builder.largestKillingSpree;
        this.largestMultiKill = builder.largestMultiKill;
        this.magicDamageDealt = builder.magicDamageDealt;
        this.magicDamageDealtToChampions = builder.magicDamageDealtToChampions;
        this.magicDamageTaken = builder.magicDamageTaken;
        this.neutralMinionsKilled = builder.neutralMinionsKilled;
        this.nexusKills = builder.nexusKills;
        this.nexusTakedowns = builder.nexusTakedowns;
        this.nexusLost = builder.nexusLost;
        this.objectivesStolen = builder.objectivesStolen;
        this.participantId = builder.participantId;
        this.pentaKills = builder.pentaKills;
        this.physicalDamageDealt = builder.physicalDamageDealt;
        this.physicalDamageDealtToChampions = builder.physicalDamageDealtToChampions;
        this.physicalDamageTaken = builder.physicalDamageTaken;
        this.profileIcon = builder.profileIcon;
        this.quadraKills = builder.quadraKills;
        this.sightWardsBoughtInGame = builder.sightWardsBoughtInGame;
        this.spell1Casts = builder.spell1Casts;
        this.spell3Casts = builder.spell3Casts;
        this.spell4Casts = builder.spell4Casts;
        this.summoner1Casts = builder.summoner1Casts;
        this.summoner1Id = builder.summoner1Id;
        this.summoner2Casts = builder.summoner2Casts;
        this.summoner2Id = builder.summoner2Id;
        this.summonerLevel = builder.summonerLevel;
        this.teamId = builder.teamId;
        this.timeCCingOthers = builder.timeCCingOthers;
        this.timePlayed = builder.timePlayed;
        this.totalDamageDealt = builder.totalDamageDealt;
        this.totalDamageShieldedOnTeammates = builder.totalDamageShieldedOnTeammates;
        this.totalDamageTaken = builder.totalDamageTaken;
        this.totalHeal = builder.totalHeal;
        this.totalHealsOnTeammates = builder.totalHealsOnTeammates;
        this.totalMinionsKilled = builder.totalMinionsKilled;
        this.totalTimeCCDealt = builder.totalTimeCCDealt;
        this.totalTimeSpentDead = builder.totalTimeSpentDead;
        this.totalUnitsHealed = builder.totalUnitsHealed;
        this.trueDamageDealt = builder.trueDamageDealt;
        this.trueDamageDealtToChampions = builder.trueDamageDealtToChampions;
        this.trueDamageTaken = builder.trueDamageTaken;
        this.turretKills = builder.turretKills;
        this.turretTakedowns = builder.turretTakedowns;
        this.turretsLost = builder.turretsLost;
        this.unrealKills = builder.unrealKills;
        this.visionScore = builder.visionScore;
        this.visionWardsBoughtInGame = builder.visionWardsBoughtInGame;
        this.wardsKilled = builder.wardsKilled;
        this.wardsPlaced = builder.wardsPlaced;
        this.firstBloodAssist = builder.firstBloodAssist;
        this.firstBloodKill = builder.firstBloodKill;
        this.firstTowerAssist = builder.firstTowerAssist;
        this.firstTowerKill = builder.firstTowerKill;
        this.gameEndedInEarlySurrender = builder.gameEndedInEarlySurrender;
        this.gameEndedInSurrender = builder.gameEndedInSurrender;
        this.teamEarlySurrendered = builder.teamEarlySurrendered;
        this.win = builder.win;
        this.championName = builder.championName;
        this.individualPosition = builder.individualPosition;
        this.lane = builder.lane;
        this.puuid = builder.puuid;
        this.riotIdName = builder.riotIdName;
        this.riotIdTagline = builder.riotIdTagline;
        this.role = builder.role;
        this.summonerId = builder.summonerId;
        this.summonerName = builder.summonerName;
        this.teamPosition = builder.teamPosition;
        this.perks = builder.perks;
    }

    @JsonPOJOBuilder
    public static class Builder{
        private int assists,baronKills,bountyLevel,champExperience,champLevel,championId,championTransform,consumablesPurchased,damageDealtToBuildings,damageDealtToObjectives,damageDealtToTurrets
                ,damageSelfMitigated,deaths,detectorWardsPlaced,doubleKills,dragonKills,goldEarned,goldSpent,inhibitorKills,inhibitorTakedowns,inhibitorsLost
                ,item0,item1,item2,item3,item4,item5,item6,itemsPurchased,killingSprees,kills,largestCriticalStrike,largestKillingSpree,largestMultiKill,longestTimeSpentLiving
                ,magicDamageDealt,magicDamageDealtToChampions,magicDamageTaken,neutralMinionsKilled,nexusKills,nexusTakedowns,nexusLost,objectivesStolen,objectivesStolenAssists
                ,participantId,pentaKills,physicalDamageDealt,physicalDamageDealtToChampions,physicalDamageTaken,profileIcon,quadraKills,sightWardsBoughtInGame,spell1Casts,spell2Casts
                ,spell3Casts,spell4Casts,summoner1Casts,summoner1Id,summoner2Casts,summoner2Id,summonerLevel,teamId,timeCCingOthers,timePlayed,totalDamageDealt,totalDamageDealtToChampions
                ,totalDamageShieldedOnTeammates,totalDamageTaken,totalHeal,totalHealsOnTeammates,totalMinionsKilled,totalTimeCCDealt,totalTimeSpentDead,totalUnitsHealed,tripleKills
                ,trueDamageDealt,trueDamageDealtToChampions,trueDamageTaken,turretKills,turretTakedowns,turretsLost,unrealKills,visionScore,visionWardsBoughtInGame,wardsKilled,wardsPlaced;
        private boolean firstBloodAssist,firstBloodKill,firstTowerAssist,firstTowerKill,gameEndedInEarlySurrender,gameEndedInSurrender,teamEarlySurrendered,win;
        private String championName,individualPosition,lane,puuid,riotIdName,riotIdTagline,role,summonerId,summonerName,teamPosition;
        private Perks perks;

        public Builder withinhibitorsLost(int inhibitorsLost){
            this.inhibitorsLost = inhibitorsLost;
            return Builder.this;
        }

        public Builder withlongestTimeSpentLiving(int longestTimeSpentLiving){
            this.longestTimeSpentLiving = longestTimeSpentLiving;
            return Builder.this;
        }

        public Builder withobjectivesStolenAssists(int objectivesStolenAssists){
            this.objectivesStolenAssists = objectivesStolenAssists;
            return Builder.this;
        }

        public Builder withspell2Casts(int spell2Casts){
            this.spell2Casts = spell2Casts;
            return Builder.this;
        }

        public Builder withtotalDamageDealtToChampions(int totalDamageDealtToChampions){
            this.totalDamageDealtToChampions = totalDamageDealtToChampions;
            return Builder.this;
        }

        public Builder withtripleKills(int tripleKills){
            this.tripleKills = tripleKills;
            return Builder.this;
        }

        public Builder withassists(int assists){
            this.assists = assists;
            return Builder.this;
        }

        public Builder withbaronKills(int baronKills){
            this.baronKills = baronKills;
            return Builder.this;
        }

        public Builder withbountyLevel(int bountyLevel){
            this.bountyLevel = bountyLevel;
            return Builder.this;
        }

        public Builder withchampExperience(int champExperience){
            this.champExperience = champExperience;
            return Builder.this;
        }

        public Builder withchampLevel(int champLevel){
            this.champLevel = champLevel;
            return Builder.this;
        }

        public Builder withchampionId(int championId){
            this.championId = championId;
            return Builder.this;
        }

        public Builder withchampionTransform(int championTransform){
            this.championTransform = championTransform;
            return Builder.this;
        }

        public Builder withconsumablesPurchased(int consumablesPurchased){
            this.consumablesPurchased = consumablesPurchased;
            return Builder.this;
        }

        public Builder withdamageDealtToBuildings(int damageDealtToBuildings){
            this.damageDealtToBuildings = damageDealtToBuildings;
            return Builder.this;
        }

        public Builder withdamageDealtToObjectives(int damageDealtToObjectives){
            this.damageDealtToObjectives = damageDealtToObjectives;
            return Builder.this;
        }

        public Builder withdamageDealtToTurrets(int damageDealtToTurrets){
            this.damageDealtToTurrets = damageDealtToTurrets;
            return Builder.this;
        }

        public Builder withdamageSelfMitigated(int damageSelfMitigated){
            this.damageSelfMitigated = damageSelfMitigated;
            return Builder.this;
        }

        public Builder withdeaths(int deaths){
            this.deaths = deaths;
            return Builder.this;
        }

        public Builder withdetectorWardsPlaced(int detectorWardsPlaced){
            this.detectorWardsPlaced = detectorWardsPlaced;
            return Builder.this;
        }

        public Builder withdoubleKills(int doubleKills){
            this.doubleKills = doubleKills;
            return Builder.this;
        }

        public Builder withdragonKills(int dragonKills){
            this.dragonKills = dragonKills;
            return Builder.this;
        }

        public Builder withgoldEarned(int goldEarned){
            this.goldEarned = goldEarned;
            return Builder.this;
        }

        public Builder withgoldSpent(int goldSpent){
            this.goldSpent = goldSpent;
            return Builder.this;
        }

        public Builder withinhibitorKills(int inhibitorKills){
            this.inhibitorKills = inhibitorKills;
            return Builder.this;
        }

        public Builder withinhibitorTakedowns(int inhibitorTakedowns){
            this.inhibitorTakedowns = inhibitorTakedowns;
            return Builder.this;
        }

        public Builder withitem0(int item0){
            this.item0 = item0;
            return Builder.this;
        }

        public Builder withitem1(int item1){
            this.item1 = item1;
            return Builder.this;
        }

        public Builder withitem2(int item2){
            this.item2 = item2;
            return Builder.this;
        }

        public Builder withitem3(int item3){
            this.item3 = item3;
            return Builder.this;
        }

        public Builder withitem4(int item4){
            this.item4 = item4;
            return Builder.this;
        }

        public Builder withitem5(int item5){
            this.item5 = item5;
            return Builder.this;
        }

        public Builder withitem6(int item6){
            this.item6 = item6;
            return Builder.this;
        }

        public Builder withitemsPurchased(int itemsPurchased){
            this.itemsPurchased = itemsPurchased;
            return Builder.this;
        }

        public Builder withkillingSprees(int killingSprees){
            this.killingSprees = killingSprees;
            return Builder.this;
        }

        public Builder withkills(int kills){
            this.kills = kills;
            return Builder.this;
        }

        public Builder withlargestCriticalStrike(int largestCriticalStrike){
            this.largestCriticalStrike = largestCriticalStrike;
            return Builder.this;
        }

        public Builder withlargestKillingSpree(int largestKillingSpree){
            this.largestKillingSpree = largestKillingSpree;
            return Builder.this;
        }

        public Builder withlargestMultiKill(int largestMultiKill){
            this.largestMultiKill = largestMultiKill;
            return Builder.this;
        }

        public Builder withmagicDamageDealt(int magicDamageDealt){
            this.magicDamageDealt = magicDamageDealt;
            return Builder.this;
        }

        public Builder withmagicDamageDealtToChampions(int magicDamageDealtToChampions){
            this.magicDamageDealtToChampions = magicDamageDealtToChampions;
            return Builder.this;
        }

        public Builder withmagicDamageTaken(int magicDamageTaken){
            this.magicDamageTaken = magicDamageTaken;
            return Builder.this;
        }

        public Builder withneutralMinionsKilled(int neutralMinionsKilled){
            this.neutralMinionsKilled = neutralMinionsKilled;
            return Builder.this;
        }

        public Builder withnexusKills(int nexusKills){
            this.nexusKills = nexusKills;
            return Builder.this;
        }

        public Builder withnexusTakedowns(int nexusTakedowns){
            this.nexusTakedowns = nexusTakedowns;
            return Builder.this;
        }

        public Builder withnexusLost(int nexusLost){
            this.nexusLost = nexusLost;
            return Builder.this;
        }

        public Builder withobjectivesStolen(int objectivesStolen){
            this.objectivesStolen = objectivesStolen;
            return Builder.this;
        }

        public Builder withparticipantId(int participantId){
            this.participantId = participantId;
            return Builder.this;
        }

        public Builder withpentaKills(int pentaKills){
            this.pentaKills = pentaKills;
            return Builder.this;
        }

        public Builder withphysicalDamageDealt(int physicalDamageDealt){
            this.physicalDamageDealt = physicalDamageDealt;
            return Builder.this;
        }

        public Builder withphysicalDamageDealtToChampions(int physicalDamageDealtToChampions){
            this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
            return Builder.this;
        }

        public Builder withphysicalDamageTaken(int physicalDamageTaken){
            this.physicalDamageTaken = physicalDamageTaken;
            return Builder.this;
        }

        public Builder withprofileIcon(int profileIcon){
            this.profileIcon = profileIcon;
            return Builder.this;
        }

        public Builder withquadraKills(int quadraKills){
            this.quadraKills = quadraKills;
            return Builder.this;
        }

        public Builder withsightWardsBoughtInGame(int sightWardsBoughtInGame){
            this.sightWardsBoughtInGame = sightWardsBoughtInGame;
            return Builder.this;
        }

        public Builder withspell1Casts(int spell1Casts){
            this.spell1Casts = spell1Casts;
            return Builder.this;
        }

        public Builder withspell3Casts(int spell3Casts){
            this.spell3Casts = spell3Casts;
            return Builder.this;
        }

        public Builder withspell4Casts(int spell4Casts){
            this.spell4Casts = spell4Casts;
            return Builder.this;
        }

        public Builder withsummoner1Casts(int summoner1Casts){
            this.summoner1Casts = summoner1Casts;
            return Builder.this;
        }

        public Builder withsummoner1Id(int summoner1Id){
            this.summoner1Id = summoner1Id;
            return Builder.this;
        }

        public Builder withsummoner2Casts(int summoner2Casts){
            this.summoner2Casts = summoner2Casts;
            return Builder.this;
        }

        public Builder withsummoner2Id(int summoner2Id){
            this.summoner2Id = summoner2Id;
            return Builder.this;
        }

        public Builder withsummonerLevel(int summonerLevel){
            this.summonerLevel = summonerLevel;
            return Builder.this;
        }

        public Builder withteamId(int teamId){
            this.teamId = teamId;
            return Builder.this;
        }

        public Builder withtimeCCingOthers(int timeCCingOthers){
            this.timeCCingOthers = timeCCingOthers;
            return Builder.this;
        }

        public Builder withtimePlayed(int timePlayed){
            this.timePlayed = timePlayed;
            return Builder.this;
        }

        public Builder withtotalDamageDealt(int totalDamageDealt){
            this.totalDamageDealt = totalDamageDealt;
            return Builder.this;
        }

        public Builder withtotalDamageShieldedOnTeammates(int totalDamageShieldedOnTeammates){
            this.totalDamageShieldedOnTeammates = totalDamageShieldedOnTeammates;
            return Builder.this;
        }

        public Builder withtotalDamageTaken(int totalDamageTaken){
            this.totalDamageTaken = totalDamageTaken;
            return Builder.this;
        }

        public Builder withtotalHeal(int totalHeal){
            this.totalHeal = totalHeal;
            return Builder.this;
        }

        public Builder withtotalHealsOnTeammates(int totalHealsOnTeammates){
            this.totalHealsOnTeammates = totalHealsOnTeammates;
            return Builder.this;
        }

        public Builder withtotalMinionsKilled(int totalMinionsKilled){
            this.totalMinionsKilled = totalMinionsKilled;
            return Builder.this;
        }

        public Builder withtotalTimeCCDealt(int totalTimeCCDealt){
            this.totalTimeCCDealt = totalTimeCCDealt;
            return Builder.this;
        }

        public Builder withtotalTimeSpentDead(int totalTimeSpentDead){
            this.totalTimeSpentDead = totalTimeSpentDead;
            return Builder.this;
        }

        public Builder withtotalUnitsHealed(int totalUnitsHealed){
            this.totalUnitsHealed = totalUnitsHealed;
            return Builder.this;
        }

        public Builder withtrueDamageDealt(int trueDamageDealt){
            this.trueDamageDealt = trueDamageDealt;
            return Builder.this;
        }

        public Builder withtrueDamageDealtToChampions(int trueDamageDealtToChampions){
            this.trueDamageDealtToChampions = trueDamageDealtToChampions;
            return Builder.this;
        }

        public Builder withtrueDamageTaken(int trueDamageTaken){
            this.trueDamageTaken = trueDamageTaken;
            return Builder.this;
        }

        public Builder withturretKills(int turretKills){
            this.turretKills = turretKills;
            return Builder.this;
        }

        public Builder withturretTakedowns(int turretTakedowns){
            this.turretTakedowns = turretTakedowns;
            return Builder.this;
        }

        public Builder withturretsLost(int turretsLost){
            this.turretsLost = turretsLost;
            return Builder.this;
        }

        public Builder withunrealKills(int unrealKills){
            this.unrealKills = unrealKills;
            return Builder.this;
        }

        public Builder withvisionScore(int visionScore){
            this.visionScore = visionScore;
            return Builder.this;
        }

        public Builder withvisionWardsBoughtInGame(int visionWardsBoughtInGame){
            this.visionWardsBoughtInGame = visionWardsBoughtInGame;
            return Builder.this;
        }

        public Builder withwardsKilled(int wardsKilled){
            this.wardsKilled = wardsKilled;
            return Builder.this;
        }

        public Builder withwardsPlaced(int wardsPlaced){
            this.wardsPlaced = wardsPlaced;
            return Builder.this;
        }

        public Builder withfirstBloodAssist(boolean firstBloodAssist){
            this.firstBloodAssist = firstBloodAssist;
            return Builder.this;
        }

        public Builder withfirstBloodKill(boolean firstBloodKill){
            this.firstBloodKill = firstBloodKill;
            return Builder.this;
        }

        public Builder withfirstTowerAssist(boolean firstTowerAssist){
            this.firstTowerAssist = firstTowerAssist;
            return Builder.this;
        }

        public Builder withfirstTowerKill(boolean firstTowerKill){
            this.firstTowerKill = firstTowerKill;
            return Builder.this;
        }

        public Builder withgameEndedInEarlySurrender(boolean gameEndedInEarlySurrender){
            this.gameEndedInEarlySurrender = gameEndedInEarlySurrender;
            return Builder.this;
        }

        public Builder withgameEndedInSurrender(boolean gameEndedInSurrender){
            this.gameEndedInSurrender = gameEndedInSurrender;
            return Builder.this;
        }

        public Builder withteamEarlySurrendered(boolean teamEarlySurrendered){
            this.teamEarlySurrendered = teamEarlySurrendered;
            return Builder.this;
        }

        public Builder withwin(boolean win){
            this.win = win;
            return Builder.this;
        }

        public Builder withchampionName(String championName){
            this.championName = championName;
            return Builder.this;
        }

        public Builder withindividualPosition(String individualPosition){
            this.individualPosition = individualPosition;
            return Builder.this;
        }

        public Builder withlane(String lane){
            this.lane = lane;
            return Builder.this;
        }

        public Builder withpuuid(String puuid){
            this.puuid = puuid;
            return Builder.this;
        }

        public Builder withriotIdName(String riotIdName){
            this.riotIdName = riotIdName;
            return Builder.this;
        }

        public Builder withriotIdTagline(String riotIdTagline){
            this.riotIdTagline = riotIdTagline;
            return Builder.this;
        }

        public Builder withrole(String role){
            this.role = role;
            return Builder.this;
        }

        public Builder withsummonerId(String summonerId){
            this.summonerId = summonerId;
            return Builder.this;
        }

        public Builder withsummonerName(String summonerName){
            this.summonerName = summonerName;
            return Builder.this;
        }

        public Builder withteamPosition(String teamPosition){
            this.teamPosition = teamPosition;
            return Builder.this;
        }

        public Builder withperks(Perks perks){
            this.perks = perks;
            return Builder.this;
        }

        public Participant build() {
            Participant participant = new Participant(this);
            validateUserObject(participant);
            return participant;
        }

        private void validateUserObject(Participant participant) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }


    public int getAssists() {
        return assists;
    }

    public int getBaronKills() {
        return baronKills;
    }

    public int getBountyLevel() {
        return bountyLevel;
    }

    public int getChampExperience() {
        return champExperience;
    }

    public int getChampLevel() {
        return champLevel;
    }

    public int getChampionId() {
        return championId;
    }

    public int getChampionTransform() {
        return championTransform;
    }

    public int getConsumablesPurchased() {
        return consumablesPurchased;
    }

    public int getDamageDealtToBuildings() {
        return damageDealtToBuildings;
    }

    public int getDamageDealtToObjectives() {
        return damageDealtToObjectives;
    }

    public int getDamageDealtToTurrets() {
        return damageDealtToTurrets;
    }

    public int getDamageSelfMitigated() {
        return damageSelfMitigated;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getDetectorWardsPlaced() {
        return detectorWardsPlaced;
    }

    public int getDoubleKills() {
        return doubleKills;
    }

    public int getDragonKills() {
        return dragonKills;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public int getGoldSpent() {
        return goldSpent;
    }

    public int getInhibitorKills() {
        return inhibitorKills;
    }

    public int getInhibitorTakedowns() {
        return inhibitorTakedowns;
    }

    public int getInhibitorsLost() {
        return inhibitorsLost;
    }

    public int getItem0() {
        return item0;
    }

    public int getItem1() {
        return item1;
    }

    public int getItem2() {
        return item2;
    }

    public int getItem3() {
        return item3;
    }

    public int getItem4() {
        return item4;
    }

    public int getItem5() {
        return item5;
    }

    public int getItem6() {
        return item6;
    }

    public int getItemsPurchased() {
        return itemsPurchased;
    }

    public int getKillingSprees() {
        return killingSprees;
    }

    public int getKills() {
        return kills;
    }

    public int getLargestCriticalStrike() {
        return largestCriticalStrike;
    }

    public int getLargestKillingSpree() {
        return largestKillingSpree;
    }

    public int getLargestMultiKill() {
        return largestMultiKill;
    }

    public int getLongestTimeSpentLiving() {
        return longestTimeSpentLiving;
    }

    public int getMagicDamageDealt() {
        return magicDamageDealt;
    }

    public int getMagicDamageDealtToChampions() {
        return magicDamageDealtToChampions;
    }

    public int getMagicDamageTaken() {
        return magicDamageTaken;
    }

    public int getNeutralMinionsKilled() {
        return neutralMinionsKilled;
    }

    public int getNexusKills() {
        return nexusKills;
    }

    public int getNexusTakedowns() {
        return nexusTakedowns;
    }

    public int getNexusLost() {
        return nexusLost;
    }

    public int getObjectivesStolen() {
        return objectivesStolen;
    }

    public int getObjectivesStolenAssists() {
        return objectivesStolenAssists;
    }

    public int getParticipantId() {
        return participantId;
    }

    public int getPentaKills() {
        return pentaKills;
    }

    public int getPhysicalDamageDealt() {
        return physicalDamageDealt;
    }

    public int getPhysicalDamageDealtToChampions() {
        return physicalDamageDealtToChampions;
    }

    public int getPhysicalDamageTaken() {
        return physicalDamageTaken;
    }

    public int getProfileIcon() {
        return profileIcon;
    }

    public int getQuadraKills() {
        return quadraKills;
    }

    public int getSightWardsBoughtInGame() {
        return sightWardsBoughtInGame;
    }

    public int getSpell1Casts() {
        return spell1Casts;
    }

    public int getSpell2Casts() {
        return spell2Casts;
    }

    public int getSpell3Casts() {
        return spell3Casts;
    }

    public int getSpell4Casts() {
        return spell4Casts;
    }

    public int getSummoner1Casts() {
        return summoner1Casts;
    }

    public int getSummoner1Id() {
        return summoner1Id;
    }

    public int getSummoner2Casts() {
        return summoner2Casts;
    }

    public int getSummoner2Id() {
        return summoner2Id;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getTimeCCingOthers() {
        return timeCCingOthers;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public int getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    public int getTotalDamageShieldedOnTeammates() {
        return totalDamageShieldedOnTeammates;
    }

    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public int getTotalHeal() {
        return totalHeal;
    }

    public int getTotalHealsOnTeammates() {
        return totalHealsOnTeammates;
    }

    public int getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    public int getTotalTimeCCDealt() {
        return totalTimeCCDealt;
    }

    public int getTotalTimeSpentDead() {
        return totalTimeSpentDead;
    }

    public int getTotalUnitsHealed() {
        return totalUnitsHealed;
    }

    public int getTripleKills() {
        return tripleKills;
    }

    public int getTrueDamageDealt() {
        return trueDamageDealt;
    }

    public int getTrueDamageDealtToChampions() {
        return trueDamageDealtToChampions;
    }

    public int getTrueDamageTaken() {
        return trueDamageTaken;
    }

    public int getTurretKills() {
        return turretKills;
    }

    public int getTurretTakedowns() {
        return turretTakedowns;
    }

    public int getTurretsLost() {
        return turretsLost;
    }

    public int getUnrealKills() {
        return unrealKills;
    }

    public int getVisionScore() {
        return visionScore;
    }

    public int getVisionWardsBoughtInGame() {
        return visionWardsBoughtInGame;
    }

    public int getWardsKilled() {
        return wardsKilled;
    }

    public int getWardsPlaced() {
        return wardsPlaced;
    }

    public boolean isFirstBloodAssist() {
        return firstBloodAssist;
    }

    public boolean isFirstBloodKill() {
        return firstBloodKill;
    }

    public boolean isFirstTowerAssist() {
        return firstTowerAssist;
    }

    public boolean isFirstTowerKill() {
        return firstTowerKill;
    }

    public boolean isGameEndedInEarlySurrender() {
        return gameEndedInEarlySurrender;
    }

    public boolean isGameEndedInSurrender() {
        return gameEndedInSurrender;
    }

    public boolean isTeamEarlySurrendered() {
        return teamEarlySurrendered;
    }

    public boolean isWin() {
        return win;
    }

    public String getChampionName() {
        return championName;
    }

    public String getIndividualPosition() {
        return individualPosition;
    }

    public String getLane() {
        return lane;
    }

    public String getPuuid() {
        return puuid;
    }

    public String getRiotIdName() {
        return riotIdName;
    }

    public String getRiotIdTagline() {
        return riotIdTagline;
    }

    public String getRole() {
        return role;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public String getTeamPosition() {
        return teamPosition;
    }

    public Perks getPerks() {
        return perks;
    }

    public boolean getWin(){
        return win;
    }
}
