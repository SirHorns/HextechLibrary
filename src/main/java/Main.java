
import com.fasterxml.jackson.core.JsonProcessingException;
import hextechlibrary.HextechLibrary;
import hextechlibrary.games.TFTManager;
import hextechlibrary.games.tft.TFTSet;
import hextechlibrary.games.tft.dto.SummonerTFT;
import hextechlibrary.games.tft.dto.match.MatchTFT;
import hextechlibrary.games.tft.dto.match.ParticipantTFT;
import hextechlibrary.games.tft.sets.five.patch1115.Champion;
import hextechlibrary.games.tft.sets.five.patch1115.Trait;
import hextechlibrary.riotapi.RAPIManager;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.util.*;
import java.util.List;


public class Main {
    private static final String lol = "RGAPI-dbd6d858-570a-4103-a22f-76c94c370609";
    //I only have a LoL API Key so these two will used the Development key
    //LoR code isn't actually implemented yet at all
    private static final String lor = "LoR_KEY";
    private static final String tft = "RGAPI-76597c59-60b9-4fac-8afd-4fd2122e94dc";

    private static final HextechLibrary hextechLibrary = new HextechLibrary(lol,lor,tft);
    private static final RAPIManager rapiManager = hextechLibrary.getRapiManager();

    public static void main(String[] args){
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
}

