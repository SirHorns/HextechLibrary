import HextechLibrary.HextechLibrary;
import SQLite.SQLite;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.Date;
import java.sql.SQLException;
import java.time.*;

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

    public static void main(String[] args) throws SQLException, JsonProcessingException {
        SQLite lite = new SQLite();
        lite.createNewDatabase("Riot_API_DB");
        lite.createNewTable();

        HextechLibrary hextechLibrary = new HextechLibrary();
        hextechLibrary.setRIOT_API_TOKEN("RGAPI-dbd6d858-570a-4103-a22f-76c94c370609");

        //System.out.println(hextechLibrary.GetSummoner("Dnicky").getName());
        //hextechLibrary.AddSummoner("JackWildBurn");
        //lite.GetMatches("OOYMjHMykymUP4Cag57ph-_JZ_rKDM7WZwRgc_dpazJpBv45Z45be9CB1PvxIgC2_Y1mvLe-zrcFhw", "CLASSIC");
        //hextechLibrary.GetMatchList("OOYMjHMykymUP4Cag57ph-_JZ_rKDM7WZwRgc_dpazJpBv45Z45be9CB1PvxIgC2_Y1mvLe-zrcFhw",20);

        // create  instance object
        LocalDateTime Today = LocalDateTime.now();
        LocalDateTime yesterday = Today.minusDays(1);

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

    }

}
