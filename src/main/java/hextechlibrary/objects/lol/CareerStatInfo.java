package hextechlibrary.objects.lol;

import hextechlibrary.dto.lol.SummonerDto;

import java.util.List;

public class CareerStatInfo {
    private final String summonerName;

    private SummonerDto summoner;

    private List<String> matchIDList;
    private List<String> championList;
    private List<ChampPick> championPickInfoList;
    List<ChampPick> mostPlayedList;
    List<ChampPick> highestKDAList;
    List<ChampPick> lowestKDAList;


    private int gameCount;
    private int playerWins;
    private int playerLoses;
    private int totalKills;
    private int totalDeaths;
    private int totalAssists;


    public CareerStatInfo(String summonerName) {
        this.summonerName = summonerName;
    }


    /**
     *
     * @return
     */
    public double getWinRate() {
        return (double) playerWins / (playerWins + playerLoses);
    }

    /**
     *
     * @return
     */
    public double getKillDeathRatio() {
        return (double) totalKills / Math.max(totalDeaths, 1);
    }

    /**
     *
     * @return
     */
    public double getKillDeathAssistRatio() {
        return (double) (totalKills + totalAssists) / Math.max(totalDeaths, 1);
    }

    /**
     *
     * @return
     */
    public double getDominanceRatio() {
        return (double )((2 * totalKills) + totalAssists) / (2 * totalDeaths);
    }

    /**
     *
     * @return
     */
    public int getDominanceFactor() {
        return ((2 * totalKills) + totalAssists) - (2 * totalKills);
    }


    //GETTERS

    /**
     *
     * @return
     */
    public String getSummonerName() {
        return summonerName;
    }

    /**
     *
     * @return
     */
    public SummonerDto getSummoner() {
        return summoner;
    }

    /**
     *
     * @return
     */
    public List<String> getMatchIDList() {
        return matchIDList;
    }

    /**
     *
     * @return
     */
    public List<ChampPick> getChampionPickInfoList() {
        return championPickInfoList;
    }

    /**
     *
     * @return
     */
    public List<ChampPick> getMostPlayedList() {
        return mostPlayedList;
    }

    /**
     *
     * @return
     */
    public List<ChampPick> getHighestKDAList() {
        return highestKDAList;
    }

    /**
     *
     * @return
     */
    public List<ChampPick> getLowestKDAList() {
        return lowestKDAList;
    }

    /**
     *
     * @return
     */
    public int getGameCount() {
        return gameCount;
    }

    /**
     *
     * @return
     */
    public int getPlayerWins() {
        return playerWins;
    }

    /**
     *
     * @return
     */
    public int getPlayerLoses() {
        return playerLoses;
    }

    /**
     *
     * @return
     */
    public int getTotalKills() {
        return totalKills;
    }

    /**
     *
     * @return
     */
    public int getTotalDeaths() {
        return totalDeaths;
    }

    /**
     *
     * @return
     */
    public int getTotalAssists() {
        return totalAssists;
    }

    /**
     *
     * @return
     */
    public List<String> getChampionList() {
        return championList;
    }

    //SETTERS

    /**
     *
     * @param summoner
     */
    public void setSummoner(SummonerDto summoner) {
        this.summoner = summoner;
    }

    /**
     *
     * @param matchIDList
     */
    public void setMatchIDList(List<String> matchIDList) {
        this.matchIDList = matchIDList;
        this.gameCount = matchIDList.size();
    }

    /**
     *
     * @param championPickInfoList
     */
    public void setChampionPickInfoList(List<ChampPick> championPickInfoList) {
        this.championPickInfoList = championPickInfoList;
    }

    /**
     *
     * @param mostPlayedList
     */
    public void setMostPlayedList(List<ChampPick> mostPlayedList) {
        this.mostPlayedList = mostPlayedList;
    }

    /**
     *
     * @param highestKDAList
     */
    public void setHighestKDAList(List<ChampPick> highestKDAList) {
        this.highestKDAList = highestKDAList;
    }

    /**
     *
     * @param lowestKDAList
     */
    public void setLowestKDAList(List<ChampPick> lowestKDAList) {
        this.lowestKDAList = lowestKDAList;
    }

    /**
     *
     * @param playerWins
     */
    public void setPlayerWins(int playerWins) {
        this.playerWins = playerWins;
    }

    /**
     *
     * @param playerLoses
     */
    public void setPlayerLoses(int playerLoses) {
        this.playerLoses = playerLoses;
    }

    /**
     *
     * @param totalKills
     */
    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    /**
     *
     * @param totalDeaths
     */
    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    /**
     *
     * @param totalAssists
     */
    public void setTotalAssists(int totalAssists) {
        this.totalAssists = totalAssists;
    }

    /**
     *
     * @param championList
     */
    public void setChampionList(List<String> championList) {
        this.championList = championList;
    }




    public static class ChampPick{
        String name;
        int pickCount;

        //TODO: Implement K/D/A & KDR recording within CareerStats Calculations.
        int kills;
        int deaths;
        int assists;

        int wins;
        int loses;
        double winRate;

        double killDeathAssistRatio;
        double killDeathRatio;
        double pickRatio;

        public ChampPick() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWins() {
            return wins;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public int getLoses() {
            return loses;
        }

        public void setLoses(int loses) {
            this.loses = loses;
        }

        public double getWinRate() {
            return winRate;
        }

        public void setWinRate(double winRate) {
            this.winRate = winRate;
        }

        public int getPickCount() {
            return pickCount;
        }

        public void setPickCount(int pickCount) {
            this.pickCount = pickCount;
        }

        public double getPickRatio() {
            return pickRatio;
        }

        public void setPickRatio(double pickRatio) {
            this.pickRatio = pickRatio;
        }

        public double getKillDeathAssistRatio() {
            return killDeathAssistRatio;
        }

        public void setKillDeathAssistRatio(double killDeathAssistRatio) {
            this.killDeathAssistRatio = killDeathAssistRatio;
        }

        public int getKills() {
            return kills;
        }

        public void setKills(int kills) {
            this.kills = kills;
        }

        public int getDeaths() {
            return deaths;
        }

        public void setDeaths(int deaths) {
            this.deaths = deaths;
        }

        public int getAssists() {
            return assists;
        }

        public void setAssists(int assists) {
            this.assists = assists;
        }

        public double getKillDeathRatio() {
            return killDeathRatio;
        }

        public void setKillDeathRatio(double killDeathRatio) {
            this.killDeathRatio = killDeathRatio;
        }
    }
}
