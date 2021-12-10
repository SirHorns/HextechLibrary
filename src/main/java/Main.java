
import com.fasterxml.jackson.core.JsonProcessingException;
import hextechlibrary.HextechLibrary;
import hextechlibrary.games.tft.dto.match.MatchTFT;
import hextechlibrary.games.tft.dto.match.ParticipantTFT;
import hextechlibrary.games.tft.dto.match.Unit;
import hextechlibrary.games.tft.objects.ParticipantsTFT;
import hextechlibrary.games.tft.sets.five.SetFiveManager;

import java.util.List;


public class Main {
    /*
    {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36",
    "Accept-Language": "en-US,en;q=0.9",
    "Accept-Charset": "application/x-www-form-urlencoded; charset=UTF-8",
    "Origin": "https://developer.riotgames.com",
    "X-Riot-Token": "RGAPI-dbd6d858-570a-4103-a22f-76c94c370609"
    }
    * */

    public static void main(String[] args) throws JsonProcessingException {
        HextechLibrary hextechLibrary = new HextechLibrary("RGAPI-dbd6d858-570a-4103-a22f-76c94c370609");
        String puuid = hextechLibrary.getRapiManager().getSummonerTFTByName("JackWildBurn").getPuuid();
        System.out.println(puuid);

        List<String> matchIds = hextechLibrary.getRapiManager().getTFTMatchesByPUUID(puuid,1);
        String matchId = matchIds.get(0);
        System.out.println(matchId);

        MatchTFT matchTFT = hextechLibrary.getRapiManager().getTFTMatchByMatchID(matchId);
        ParticipantsTFT participantTFT = new ParticipantsTFT(matchTFT.getInfo().getParticipants());
        ParticipantTFT matchParticipant = participantTFT.getParticipantByPUUID(puuid);
        SetFiveManager setFiveManager = new SetFiveManager();;

        StringBuilder line = new  StringBuilder();
        for (Unit unit: matchParticipant.getUnits()) {
            line
                    .append("\nName: ")
                    .append(unit.getName())
                    .append("\nCharacterID:")
                    .append(unit.getCharacterId())
                    .append("\nTier:")
                    .append(unit.getTier())
                    .append("\nRarity:")
                    .append(unit.getRarity())
                    .append("\n")
                    .append("Items: ");
            for (int item: unit.getItems()) {
                line.append(setFiveManager.getItemByID(item).getName())
                        .append(", ");
            }
            line.append("\n=====");
        }
        System.out.println(line);

        /*
        // create  instance object
        LocalDateTime Today = LocalDateTime.now();
        LocalDateTime yesterday = Today.minusDays(10);

        LocalDateTime now = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        ZoneOffset zoneOffSet = zone.getRules().getOffset(yesterday);

        System.out.println("Oie: " + yesterday.toEpochSecond(zoneOffSet));

        Instant instant = Instant.now();
        //Instant startTime = endTime.minus();

        // print Instant Value
        System.out.println("Instant: " + instant);
        // get epochValue using getEpochSecond
        long epochValue = instant.getEpochSecond();
        // print results
        System.out.println("Java epoch Value: " + epochValue);
        */
    }

}
