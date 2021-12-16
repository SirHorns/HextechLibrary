
import com.fasterxml.jackson.core.JsonProcessingException;
import hextechlibrary.HextechLibrary;
import hextechlibrary.games.TFTManager;
import hextechlibrary.games.leagueoflegends.dto.match.Match;
import hextechlibrary.games.tft.TFTSet;
import hextechlibrary.games.tft.dto.SummonerTFT;
import hextechlibrary.games.tft.dto.match.MatchTFT;
import hextechlibrary.games.tft.dto.match.ParticipantTFT;
import hextechlibrary.games.tft.dto.match.Unit;
import hextechlibrary.games.tft.objects.ParticipantsTFT;
import hextechlibrary.games.tft.sets.five.SetFive;
import hextechlibrary.games.tft.sets.five.patch1115.Champion;
import hextechlibrary.games.tft.sets.five.patch1115.Trait;
import hextechlibrary.riotapi.RAPIManager;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.util.*;
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

    private static final String lol = "RGAPI-dbd6d858-570a-4103-a22f-76c94c370609";
    //I only have a LoL API Key so these two will used the Development key
    //LoR code isn't actually implemented yet at all
    private static final String lor = "LoR_KEY";
    private static final String tft = "RGAPI-ec218c8b-6d73-489d-b1a2-2636a1aa73b5";

    private static final HextechLibrary hextechLibrary = new HextechLibrary(lol,lor,tft);
    private static final RAPIManager rapiManager = hextechLibrary.getRapiManager();

    public static void main(String[] args){
        //JavaGUI();
        //HTL();
        //setFive();
        //rapiManager.getTFTMatchByMatchID("NA1_4133729909")

        /*
        You can give it 8 or fewer players
        It will check the first username in the summoner array for the match ID.
        I didn't include any intensive checks since that would be way out of scope.

        Once it is done just check your documents' folder, and it will output the Excel file there.

        Players MUST have only one unit on the board BEFORE they surrender/leave the match.
        The riot api for TFT is still a WIP, so It's impossible to really check what was the last unit gotten or other specifics in that area.
        So having one unit on the field makes this easier.
        [i.e I only coded this to check a single unit cause the riot API is really lacking]

        Notes:
        - The Excel file will be named: TFTTourny.xlsx
        - The code will skip "" in the summoner array but you still need to have the 8 spots filled.
        So you could do something like {"","","","JackWildBurn","","","MrMythik",""}
        and this would still work
        -This code will only pull the last match played & finished so if the reference player starts a new match it shouldn't pull that
        since this code and the TFT API can't look at active matches, only finished ones.
        So running this after a match ends should work just fine
        -Since this stores the player info if something breaks we can at least use their player info to find the match info later if needed.
         */

        /*
        Monstrata
        Thylako
        I PlayOnceAWeek
        Camelot
        My Left Thumb
        neoprotector
        Strategies
        doviFuneral
        Esther
        Dunkmaster69
        Just Dave 26
        Zavex
        SoulCry
        Best Sett World
        Eunovation
        morimosss
        Hailong
        Zanazerge
        Qwerty10x
        DarthLargeLoad
        Camelot
         */

        //You can run this now to test it out with just my Username as an input
        //Since its the first real username in the array it will be the Refrence Usernamer for pulling match info.
        //MrMythikk won't be refrenced for match info, just his player info recorded.
        String[] summoner = {"","JackWildBurn","","","","","MrMythikk",""};
        tft_Tourney(summoner);
    }

    /**
     * Preforms the TFT Tourny Logging Actions.
     */
    public static void tft_Tourney(String[] summoners){
        JFileChooser jFileChooser = new JFileChooser();
        FileSystemView fileSystemView = jFileChooser.getFileSystemView();
        String path = fileSystemView.getDefaultDirectory().toString() + "/TFTTourny.xlsx";

        //Check if the file exists or not then create it if it doesn't
        try{
            boolean exists = false;
            File file = new File(path);
            if(file.exists() && !file.isDirectory()) {
                exists = file.exists();
                System.out.println("TFTTourny excel file exists : " + exists);
            }
            if (!exists) {
                createExelFile();
                System.out.println("TFTTourny excel file created.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Hits the API and pulls their TFT Summoner Info
        List<SummonerTFT> summonerTFTS = new ArrayList<>();
        for (String username:summoners) {
            if (!username.equals("")){
                System.out.println("Queuering Riot API for: [" + username + "]'s summoner info.");
                try {
                    summonerTFTS.add(rapiManager.getSummonerTFTByName(username));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }

        appendSummoners(summonerTFTS);


        try {
            String puuid = summonerTFTS.get(0).getPuuid();
            String matchID = rapiManager.getTFTMatchesByPUUID(puuid,1).get(0);
            MatchTFT matchTFT = rapiManager.getTFTMatchByMatchID(matchID);
            appendMatchInfo(matchTFT);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Appends the last match id and items into items sheet.
     * @param matchTFT TFT Match Object
     */
    private static void appendMatchInfo(MatchTFT matchTFT) {
        TFTManager tftManager = new TFTManager();
        System.out.println("Appending match info to excel file");
        Workbook workbook = null;

        //get the excel file
        JFileChooser jFileChooser = new JFileChooser();
        FileSystemView fileSystemView = jFileChooser.getFileSystemView();

        String path = fileSystemView.getDefaultDirectory().toString() + "/TFTTourny.xlsx";

        FileInputStream inputStream;
        try {
            System.out.println("Getting Created Excel File.");
            inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Check if Player sheet exists
        Sheet sheet = null;
        // Check if the workbook is empty or not
        if (workbook.getNumberOfSheets() != 0) {
            System.out.println("Checking if Match Info sheet exists");
            if (workbook.getSheetName(1).equals("Match Info")) {
                System.out.println("Match Info Exists");
                sheet = workbook.getSheetAt(1);
            } else{
                sheet = workbook.createSheet("Match Info");
                System.out.println("Player Info sheet does not exists");
            }
        }
        else {
            // Create new sheet to the workbook if empty
            sheet = workbook.createSheet("Match Info");
        }

        Row row;
        Cell cell;
        //Inputting player info into the sheet
        System.out.println("Inputting match info into match Info sheet");
        int rownum = sheet.getLastRowNum() + 1;
        for (ParticipantTFT participantTFT:matchTFT.getInfo().getParticipants()) {
            SummonerTFT summonerTFT = null;
            try {
                summonerTFT = rapiManager.getSummonerTFTByPUUID(participantTFT.getPuuid());
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println("Inputting [" + summonerTFT.getName() + "]'s match info.");
            //CellStyle celltyle = workbook.createCellStyle();
            //celltyle.setShrinkToFit(true);
            //cell.setCellStyle(celltyle);

            row = sheet.createRow(rownum);
            cell = row.createCell(0);
            cell.setCellValue(matchTFT.getMetadata().getMatch_id());

            cell = row.createCell(1);
            cell.setCellValue(summonerTFT.getName());

            cell = row.createCell(2);
            cell.setCellValue(participantTFT.getUnits().get(0).getItems().get(0));

            cell = row.createCell(3);
            cell.setCellValue(
                    tftManager.getSetFive().getItemByID(
                            participantTFT.getUnits().get(0).getItems().get(0)
                    ).getName()
            );

            rownum++;
        }

        workbook.getSheetAt(1).autoSizeColumn(0);
        workbook.getSheetAt(1).autoSizeColumn(1);
        workbook.getSheetAt(1).autoSizeColumn(2);
        workbook.getSheetAt(1).autoSizeColumn(3);


        System.out.println("Closing Workbook.");
        try {
            JFileChooser fr = new JFileChooser();
            FileSystemView fw = fr.getFileSystemView();
            FileOutputStream outputStream = new FileOutputStream(fw.getDefaultDirectory().toString() + "/TFTTourny.xlsx");
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Appends given players into the excel file
     * @param summonerTFTS List of TFT Summoner Objects
     */
    public static void appendSummoners(List<SummonerTFT> summonerTFTS){
        System.out.println("Appending summoners to excel file");
        Workbook workbook = null;

        //get the excel file
        JFileChooser jFileChooser = new JFileChooser();
        FileSystemView fileSystemView = jFileChooser.getFileSystemView();

        String path = fileSystemView.getDefaultDirectory().toString() + "/TFTTourny.xlsx";

        FileInputStream inputStream;
        try {
            System.out.println("Getting Created Excel File.");
            inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Check if Player sheet exists
        Sheet sheet = null;
        // Check if the workbook is empty or not
        if (workbook.getNumberOfSheets() != 0) {
            System.out.println("Checking if Player Info sheet exists");
            if (workbook.getSheetName(0).equals("Player Info")) {
                System.out.println("Player Info Exists");
                sheet = workbook.getSheetAt(0);
            } else{
                sheet = workbook.createSheet("Player Info");
                System.out.println("Player Info sheet does not exists");
            }
        }
        else {
            // Create new sheet to the workbook if empty
            sheet = workbook.createSheet("Player Info");
        }

        Row row;
        Cell cell;
        //Inputting player info into the sheet
        System.out.println("Inputting Player Info into Player Info heet");
        int rownum = sheet.getLastRowNum() + 1;
        for (SummonerTFT summonerTFT:summonerTFTS) {
            System.out.println("Inputting [" + summonerTFT.getName() + "]'s info.");
            //CellStyle celltyle = workbook.createCellStyle();
            //celltyle.setShrinkToFit(true);
            //cell.setCellStyle(celltyle);

            row = sheet.createRow(rownum);
            cell = row.createCell(0);
            cell.setCellValue(summonerTFT.getId());

            cell = row.createCell(1);
            cell.setCellValue(summonerTFT.getAccountId());

            cell = row.createCell(2);
            cell.setCellValue(summonerTFT.getPuuid());

            cell = row.createCell(3);
            cell.setCellValue(summonerTFT.getName());

            cell = row.createCell(4);
            cell.setCellValue(summonerTFT.getProfileIconId());

            cell = row.createCell(5);
            cell.setCellValue(summonerTFT.getRevisionDate());

            cell = row.createCell(6);
            cell.setCellValue(summonerTFT.getSummonerLevel());

            rownum++;
        }

        workbook.getSheetAt(0).autoSizeColumn(0);
        workbook.getSheetAt(0).autoSizeColumn(1);
        workbook.getSheetAt(0).autoSizeColumn(3);
        workbook.getSheetAt(0).autoSizeColumn(4);
        workbook.getSheetAt(0).autoSizeColumn(5);
        workbook.getSheetAt(0).autoSizeColumn(6);


        System.out.println("Closing Workbook.");
        try {
            JFileChooser fr = new JFileChooser();
            FileSystemView fw = fr.getFileSystemView();
            FileOutputStream outputStream = new FileOutputStream(fw.getDefaultDirectory().toString() + "/TFTTourny.xlsx");
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Inserting match info in a new sheet.
        /*
        sheet = workbook.createSheet(matchTFT.getMetadata().getMatch_id());
        row = sheet.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("Players (Account Names):");
        cell = row.createCell(1);
        cell.setCellValue("PUUIDs:");
        cell = row.createCell(2);
        cell.setCellValue("Items: ");

        rownum = 1;
        int index = 0;
        for (ParticipantTFT par:matchTFT.getInfo().getParticipants()) {
            Row row = sheet.createRow(rownum);
            Cell cell = row.createCell(0);
            //CellStyle celltyle = workbook.createCellStyle();
            //celltyle.setShrinkToFit(true);
            //cell.setCellStyle(celltyle);

            cell.setCellValue(hextechLibrary.getRapiManager().getSummonerTFTByPUUID(par.getPuuid()).getName());

            cell = row.createCell(1);
            cell.setCellValue(par.getPuuid());

            cell = row.createCell(2);
            StringBuilder stringBuilder = new StringBuilder();
            List<String> items = new ArrayList<>();

            stringBuilder.append(matchTFT.getInfo().getParticipants().get(index).getUnits().get(0).getItems());

            for (Unit unit:matchTFT.getInfo().getParticipants().get(index).getUnits()) {
                if (!unit.getItems().isEmpty()){
                    for (int id: unit.getItems()) {
                        items.add(

                                tftManager
                                        .getSetFive()
                                        .getItemByID(id)
                                        .getName()
                        );
                    }

                }
            }


            //for (Unit unit:matchTFT.getInfo().getParticipants().get(index).getUnits()) {stringBuilder.append(unit.getCharacterId()).append(",");}

            cell.setCellValue(stringBuilder.toString());

            workbook.getSheetAt(0).autoSizeColumn(0);
            workbook.getSheetAt(0).autoSizeColumn(1);
            workbook.getSheetAt(0).autoSizeColumn(2);
            rownum++;
            index++;
        }
         */
    }

    /**
     * Creates the Excel File
     */
    public static void createExelFile(){
        try {
            Workbook workbook = new XSSFWorkbook();
            JFileChooser fr = new JFileChooser();
            FileSystemView fw = fr.getFileSystemView();
            FileOutputStream outputStream = new FileOutputStream(fw.getDefaultDirectory().toString() + "/TFTTourny.xlsx");
            Sheet sheet;
            Row row;
            Cell cell;
            //CellStyle style = workbook.createCellStyle(); //Create new style
            //style.setWrapText(true); //Set wordwrap
            //cell.setCellStyle(style); //Apply style to cell

            //CREATING PLAYER INFO SHEET
            sheet = workbook.createSheet("Player Info");
            System.out.println("Creating Player Info Header Row");

            row = sheet.createRow(0);

            cell = row.createCell(0);
            cell.setCellValue("id");
            cell = row.createCell(1);
            cell.setCellValue("accountID");
            cell = row.createCell(2);
            cell.setCellValue("puuid");
            cell = row.createCell(3);
            cell.setCellValue("name");
            cell = row.createCell(4);
            cell.setCellValue("profileIconId");
            cell = row.createCell(5);
            cell.setCellValue("revisionDate");
            cell = row.createCell(6);
            cell.setCellValue("summonerLevel");

            //CREATING MATCH ITEM INFO SHEET
            sheet = workbook.createSheet("Match Info");
            System.out.println("Creating Match Info Header Row");

            row = sheet.createRow(0);

            cell = row.createCell(0);
            cell.setCellValue("matchID");
            cell = row.createCell(1);
            cell.setCellValue("Player");
            cell = row.createCell(2);
            cell.setCellValue("ItemID");
            cell = row.createCell(3);
            cell.setCellValue("Item");

            workbook.write(outputStream);
            workbook.close();
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
        String tft = "RGAPI-14e6cf28-60c6-4db0-9c6c-a74903666c2b";

        HextechLibrary hextechLibrary = new HextechLibrary(lol,"LOR_Key",tft);
        TFTManager tftManager = hextechLibrary.getTftManager();
        //setInfo(tftManager);
        //randomIinfo(tftManager);
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

    //Pulls in the excel file if it already exists
    public static void appendExcelFile() {
        Workbook workbook = new XSSFWorkbook();
        JFileChooser jFileChooser = new JFileChooser();
        FileSystemView fileSystemView = jFileChooser.getFileSystemView();

        String path = fileSystemView.getDefaultDirectory().toString() + "/sheet.xlsx";

        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(new File(path));
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            HextechLibrary hextechLibrary = new HextechLibrary("","","");
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

    private static void  testerpull() throws IOException {
        //obtaining input bytes from a file
        FileInputStream fis=new FileInputStream(new File("C:\\demo\\student.xls"));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        Sheet sheet=wb.getSheetAt(0);

        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();

        for(Row row: sheet) //iteration over row using for each loop
        {
            for(Cell cell: row) //iteration over cell using for each loop
            {
                switch(formulaEvaluator.evaluateInCell(cell).getCellType())
                {
                    case NUMERIC:   //field that represents numeric cell type
                        // getting the value of the cell as a number
                        System.out.print(cell.getNumericCellValue()+ "\t\t");
                        break;
                    case STRING:    //field that represents string cell type
                        // getting the value of the cell as a string
                        System.out.print(cell.getStringCellValue()+ "\t\t");
                        break;
                }
            }
            System.out.println();
        }
    }
}

