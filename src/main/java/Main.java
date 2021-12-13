
import com.fasterxml.jackson.core.JsonProcessingException;
import hextechlibrary.HextechLibrary;
import hextechlibrary.games.TFTManager;
import hextechlibrary.games.tft.TFTSet;
import hextechlibrary.games.tft.dto.match.MatchTFT;
import hextechlibrary.games.tft.dto.match.ParticipantTFT;
import hextechlibrary.games.tft.dto.match.Unit;
import hextechlibrary.games.tft.objects.ParticipantsTFT;
import hextechlibrary.games.tft.sets.five.SetFive;
import hextechlibrary.games.tft.sets.five.patch1115.Champion;
import hextechlibrary.games.tft.sets.five.patch1115.Trait;
import hextechlibrary.riotapi.RAPIManager;

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


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
        //JavaGUI();
        //HTL();
        //setFive();
        String lol = "RGAPI-dbd6d858-570a-4103-a22f-76c94c370609";
        String tft = "RGAPI-1b7223f5-88e8-4dfa-b9b3-6f4445984691";

        HextechLibrary hextechLibrary = new HextechLibrary(lol,tft);
        RAPIManager rapiManager = matchTable(hextechLibrary.getRapiManager();


        try {
            rapiManager.getTFTMatchByMatchID(
                    rapiManager.getTFTMatchesByPUUID(
                            rapiManager.getSummonerTFTByName("JackWildBurn").getPuuid(), 1)
                            .get(0)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void JavaGUI(){
        //Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    }

    private static void setFive(){
        //API KEYS
        String lol = "RGAPI-dbd6d858-570a-4103-a22f-76c94c370609";
        String tft = "RGAPI-4b5d27c7-7630-4cac-a368-ae3784f8ad4c";

        HextechLibrary hextechLibrary = new HextechLibrary(lol,tft);
        TFTManager tftManager = hextechLibrary.getTftManager();
        //setInfo(tftManager);
        randomIinfo(tftManager);
    }

    private static void setInfo(TFTManager tftManager){
        TFTSet tftSet = tftManager.getSetFive();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("TFT Set: ")
                .append(tftSet.getSet())
                .append("\nTFT Patch: ")
                .append(tftSet.getPatch())
                .append("\nSet Traits: ");

        for (Trait trait: tftSet.getTraits()) {
            stringBuilder.append(trait.getName()).append(" ,");
        }
        stringBuilder.append("\n").append("Champions: ");
        for (Champion champion: tftSet.getChampions()) {
            stringBuilder.append(champion.getName()).append(" ,");
        }

        System.out.println(stringBuilder);
    }

    private static void randomIinfo(TFTManager tftManager){
        TFTSet tftSet = tftManager.getSetFive();
        StringBuilder string = new StringBuilder();
        for (Champion champ: tftSet.getChampions()) {
            string
                    .append("=========\n")
                    .append("Name: ")
                    .append(champ.getName())
                    .append("\n")
                    .append("ID: ")
                    .append(champ.getId())
                    .append("\n" )
                    .append("Cost: ")
                    .append(champ.getCost())
                    .append("\n")
                    .append("Traits: ")
                    .append(Arrays.toString(champ.getTraits()))
                    .append("\n");
        }
        System.out.println(string);
    }

    public static void matchTable(MatchTFT matchTFT) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(matchTFT.getMetadata().getMatch_id());
        Row header = sheet.createRow(0);
        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Players:");
        headerCell = header.createCell(1);
        headerCell.setCellValue("PUUID:");

        int index = 0;
        int rownum = 1;
        for (ParticipantTFT par:matchTFT.getInfo().getParticipants()) {
            Row row = sheet.createRow(rownum);
            Cell cell = row.createCell(0);
            cell.setCellValue("Joe");

            cell = row.createCell(1);
            cell.setCellValue(par.getPuuid());
            rownum++;
        }

        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "C:/Users/mgt_bsthomas4/Documents/sheet.xlsx";

        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        workbook.close();

    }

    public static void createExel(){
        // workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();
        // spreadsheet object
        XSSFSheet spreadsheet = workbook.createSheet(" Student Data ");
        // creating a row object
        XSSFRow row;
        // This data needs to be written (Object[])
        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();

        studentData.put("1", new Object[] { "Roll No", "NAME", "Year" });
        studentData.put("2", new Object[] { "128", "Aditya", "2nd year" });
        studentData.put("3", new Object[] { "129", "Narayana", "2nd year" });
        studentData.put("4", new Object[] { "130", "Mohan", "2nd year" });
        studentData.put("5", new Object[] { "131", "Radha", "2nd year" });
        studentData.put("6", new Object[] { "132", "Gopal", "2nd year" });

        Set<String> keyid = studentData.keySet();
        int rowid = 0;

        // writing the data into the sheets...
        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = studentData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File("C:/Users/mgt_bsthomas4/Documents/GFGsheet.xlsx"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            workbook.write(out);
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void HTL(){

        try {
            HextechLibrary hextechLibrary = new HextechLibrary("","");
            RAPIManager rapiManager = hextechLibrary.getRapiManager();

            String puuid = rapiManager.getSummonerTFTByName("JackWildBurn").getPuuid();
            MatchTFT matchTFT = rapiManager.getTFTMatchByMatchID(rapiManager.getTFTMatchesByPUUID(puuid,1).get(0));

            ParticipantsTFT participantsTFT = new ParticipantsTFT(matchTFT.getInfo().getParticipants());
            ParticipantTFT matchParticipant = participantsTFT.getParticipantByPUUID(puuid);


            TFTManager tftManager = new TFTManager();
            SetFive setFive = tftManager.getSetFive();

            System.out.println(setFive.getItemByID(1).getName());

            for (ParticipantTFT participantTFT:participantsTFT.getParticipantsList()) {
                System.out.println(rapiManager.getSummonerTFTByPUUID(participantTFT.getPuuid()).getName());
            }

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
                    line.append(setFive.getItemByID(item).getName())
                            .append(", ");
                }
                line.append("\n=====");
            }


            System.out.println(line);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

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
