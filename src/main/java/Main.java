
import com.fasterxml.jackson.core.JsonProcessingException;
import hextechlibrary.HextechLibrary;
import hextechlibrary.api.LeagueOfLegendsAPI;
import hextechlibrary.api.RiotAPIManager;
import hextechlibrary.callables.CareerStats;
import hextechlibrary.dto.lol.match.MatchDto;
import hextechlibrary.dto.lol.match.ParticipantDto;
import hextechlibrary.objects.lol.CareerStatInfo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    private static final String lol = "RGAPI-dbd6d858-570a-4103-a22f-76c94c370609";
    private static final String lor = "LoR_KEY";
    private static final String tft = "RGAPI-31fb5009-814c-40a5-9cb2-3fa0d3b48608";

    private static final HextechLibrary hextechLibrary = new HextechLibrary(lol,lor,tft);

    public static void main(String[] args) throws JsonProcessingException {
        LeagueOfLegendsAPI riotAPI = hextechLibrary.getRiotAPIManager().getLeagueOfLegendsAPI();
        //hextechLibrary.getRiotAPIManager().getLeagueOfLegendsAPI().getSummonerByName("Dnicky");
        //hextechLibrary.getCareerStats("Dnicky");
        //hextechLibrary.getCareerStats("JackWildBurn");
        riotAPI.getSummonerByName("JackWildBurn");

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime notToday = today.minusDays(10);
        ZoneId zone = ZoneId.of("America/Chicago");
        ZoneOffset zoneOffSet = zone.getRules().getOffset(notToday);

        RiotAPIManager riotAPIManager = hextechLibrary.getRiotAPIManager();
        LeagueOfLegendsAPI leagueOfLegendsAPI = riotAPIManager.getLeagueOfLegendsAPI();
        //System.out.println(riotAPIManager.getLoLAPI().getSummonerByName("JackWildBurn"));

        String puuid = leagueOfLegendsAPI.getSummonerByName("Penkï").getPuuid();
        //ranked, normal, tourney, tutorial
        List<String> matchIDs = leagueOfLegendsAPI.getMatchesByPUUID(puuid,notToday.toEpochSecond(zoneOffSet), today.toEpochSecond(zoneOffSet),400,"normal",0,100);

        riotAPI.getMatchesByMatchIDs(matchIDs);
    }

    static void futureTest(){
        FutureTask[] randomNumberTasks = new FutureTask[2];
        CareerStats careerStats1 = new CareerStats(hextechLibrary.getRiotAPIManager().getLeagueOfLegendsAPI(), "Dnicky",100);
        CareerStats careerStats2 = new CareerStats(hextechLibrary.getRiotAPIManager().getLeagueOfLegendsAPI(), "JackWildBurn",100);
        randomNumberTasks[0] = new FutureTask(careerStats1);
        randomNumberTasks[1] = new FutureTask(careerStats2);
        Thread t1 = new Thread(randomNumberTasks[0],"Dnicky" + "-CareerStats");
        Thread t2 = new Thread(randomNumberTasks[1],"JackWildBurn" + "-CareerStats");
        t1.start();
        t2.start();

        try {
            CareerStatInfo info = (CareerStatInfo) randomNumberTasks[0].get();
            System.out.println(info.getSummonerName());
            info = (CareerStatInfo) randomNumberTasks[1].get();
            System.out.println(info.getSummonerName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // Function to print Strings present
    // between any pair of delimiters
    static List<String> printSubsInDelimiters(String str){
        List<String> tags = new ArrayList<>();
        String ans;

        // Stores the indices of
        Stack<Integer> dels = new Stack<>();
        for(int i = 0; i < str.length(); i++)
        {

            // If opening delimiter
            // is encountered
            if (str.charAt(i) == '<')
            {
                dels.add(i);
            }

            // If closing delimiter
            // is encountered
            else if (str.charAt(i) == '>' &&
                    !dels.isEmpty())
            {

                // Extract the position
                // of opening delimiter
                int pos = dels.peek();

                dels.pop();

                // Length of subString
                int len = i - 1 - pos;

                // Extract the subString

                ans = str.substring(pos + 1, pos + 1 + len);
                tags.add(ans);
            }
        }
        return tags;
    }

    private void Testing(){
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime notToday = today.minusDays(10);
        ZoneId zone = ZoneId.of("America/Chicago");
        ZoneOffset zoneOffSet = zone.getRules().getOffset(notToday);

        RiotAPIManager riotAPIManager = hextechLibrary.getRiotAPIManager();
        LeagueOfLegendsAPI leagueOfLegendsAPI = riotAPIManager.getLeagueOfLegendsAPI();
        //System.out.println(riotAPIManager.getLoLAPI().getSummonerByName("JackWildBurn"));

        String puuid = leagueOfLegendsAPI.getSummonerByName("Penkï").getPuuid();
        //ranked, normal, tourney, tutorial
        List<String> matchIDs = leagueOfLegendsAPI.getMatchesByPUUID(puuid,notToday.toEpochSecond(zoneOffSet), today.toEpochSecond(zoneOffSet),400,"normal",0,50);
        List<MatchDto> matches = new ArrayList<>();
        for (String id:matchIDs) {
            matches.add(leagueOfLegendsAPI.getMatchByMatchID(id));
        }
        int win = 0;
        int loses = 0;
        try {
            System.out.println("Preforming 4 second sleep.");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (MatchDto match:matches) {
            for (ParticipantDto part:match.getInfo().getParticipants()) {
                if (puuid.equals(part.getPuuid())){
                    if (part.getWin()){
                        System.out.println("Win on: " + part.getChampionName());
                        win++;
                    }else{
                        System.out.println("Lose on: " + part.getChampionName());
                        loses++;
                    }

                }
            }
        }
        System.out.println("Wins: " + win);
        System.out.println("Loses: " + loses);
    }

    private static void tmp(){
        // create  instance object
        LocalDateTime Today = LocalDateTime.now();
        LocalDateTime previous = Today.minusDays(10);

        //LocalDateTime now = LocalDateTime.now();
        ZoneId zone = ZoneId.of("America/Chicago");
        ZoneOffset zoneOffSet = zone.getRules().getOffset(previous);

        System.out.println("Oie: " + previous.toEpochSecond(zoneOffSet));

        Instant instant = Instant.now();
        //Instant startTime = endTime.minus();

        // print Instant Value
        System.out.println("Instant: " + instant);
        // get epochValue using getEpochSecond
        long epochValue = instant.getEpochSecond();
        // print results
        System.out.println("Java epoch Value: " + epochValue);
    }
}

