package SQLite;

import Types.dto.Summoner.Summoner;

import java.io.File;
import java.sql.*;
import java.time.Instant;

//Notes
/*
https://www.sqlitetutorial.net/sqlite-java/
https://www.mathworks.com/matlabcentral/answers/270561-how-to-enable-foreign-key-for-sqlite-database
https://www.baeldung.com/jackson-deserialize-immutable-objects
https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/
*/

/**
 *
 * @author sirhorns
 */
public class SQLite {

    String database = "jdbc:sqlite:D:/Projects/SQLite/HexDB/Riot_API_DB.db";
    
    
    /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    public void createNewDatabase(String fileName) {


        try (Connection conn = DriverManager.getConnection(database)) {
            File tempFile = new File("c:/temp/temp.txt");
            boolean exists = tempFile.exists();

            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createNewTable() {

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS summoners(" +
                "accountId text PRIMARY KEY," +
                "id text," +
                "name text," +
                "profileIconId integer," +
                "revisionDate integer," +
                "summonerLevel integer," +
                "puuid text" +
                ")";

        String sql2 = "CREATE TABLE IF NOT EXISTS matchList(" +
                "matchId string PRIMARY KEY)";

        String sql3 =
                "CREATE TABLE IF NOT EXISTS matchinfo(" +
                        "puuid string," +
                        "matchId string," +
                        "gameMode string," +
                        "win boolean," +
                        "kills int," +
                        "deaths int," +
                        "assists int," +
                        "minionsKilled int," +
                        "physicalDamageDealt int," +
                        "magicDamageDealt int," +
                        "trueDamageDealt int," +
                        "physicalDamageDealtToChampions int," +
                        "magicDamageDealtToChampions int," +
                        "trueDamageDealtToChampions int," +
                        "physicalDamageTaken int," +
                        "magicDamageTaken int," +
                        "trueDamageTaken int," +
                        "totalDamageDealt int," +
                        "totalDamageDealtToChampions int," +
                        "totalDamageTaken int," +
                        "CONSTRAINT pk_ID PRIMARY KEY (puuid,matchId)" +
                        ")";

        //summoner_puuid integer,FOREIGN KEY (summoner_puuid) REFERENCES summoners(puuid)

        try (Connection conn = DriverManager.getConnection(database);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            stmt.execute(sql2);
            stmt.execute(sql3);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void CreateNewPlayerTable(String username) {

        // SQL statement for creating a new table
        String playerMatchInfoTable =
                "CREATE TABLE IF NOT EXISTS " + username + "MatchInfo(" +
                        "puuid string," +
                        "matchId string," +
                        "gameMode string," +
                        "win boolean," +
                        "kills int," +
                        "deaths int," +
                        "assists int," +
                        "minionsKilled int," +
                        "physicalDamageDealt int," +
                        "magicDamageDealt int," +
                        "trueDamageDealt int," +
                        "physicalDamageDealtToChampions int," +
                        "magicDamageDealtToChampions int," +
                        "trueDamageDealtToChampions int," +
                        "physicalDamageTaken int," +
                        "magicDamageTaken int," +
                        "trueDamageTaken int," +
                        "totalDamageDealt int," +
                        "totalDamageDealtToChampions int," +
                        "totalDamageTaken int" +
                        ")";

        try (Connection conn = DriverManager.getConnection(database);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(playerMatchInfoTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param puuid
     * @param matchId
     * @param gameMode
     * @param win
     * @param kills
     * @param deaths
     * @param assists
     * @param minionsKilled
     * @param magicDamageDealt
     * @param magicDamageDealtToChampions
     * @param magicDamageTaken
     * @param physicalDamageDealt
     * @param physicalDamageDealtToChampions
     * @param physicalDamageTaken
     * @param trueDamageDealt
     * @param trueDamageDealtToChampions
     * @param trueDamageTaken
     * @param totalDamageDealt
     * @param totalDamageDealtToChampions
     * @param totalDamageTaken
     */
    public void insertMatchInfo(
            String puuid,
            String matchId,
            String gameMode,
            boolean win,
            int kills,
            int deaths,
            int assists,
            int minionsKilled,
            int magicDamageDealt,
            int magicDamageDealtToChampions,
            int magicDamageTaken,
            int physicalDamageDealt,
            int physicalDamageDealtToChampions,
            int physicalDamageTaken,
            int trueDamageDealt,
            int trueDamageDealtToChampions,
            int trueDamageTaken,
            int totalDamageDealt,
            int totalDamageDealtToChampions,
            int totalDamageTaken
            ) {
        String sql = "INSERT INTO matchinfo(" +
                "puuid," +
                "matchId," +
                "gameMode," +
                "win," +
                "kills," +
                "deaths," +
                "assists," +
                "minionsKilled," +
                "magicDamageDealt," +
                "magicDamageDealtToChampions," +
                "magicDamageTaken," +
                "physicalDamageDealt," +
                "physicalDamageDealtToChampions," +
                "physicalDamageTaken," +
                "trueDamageDealt," +
                "trueDamageDealtToChampions," +
                "trueDamageTaken," +
                "totalDamageDealt," +
                "totalDamageDealtToChampions," +
                "totalDamageTaken" +
                ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,puuid);
            pstmt.setString(2,matchId);
            pstmt.setString(3,gameMode);
            pstmt.setBoolean(4,win);
            pstmt.setInt(5,kills);
            pstmt.setInt(6,deaths);
            pstmt.setInt(7,assists);
            pstmt.setInt(8,minionsKilled);
            pstmt.setInt(9,magicDamageDealt);
            pstmt.setInt(10,magicDamageDealtToChampions);
            pstmt.setInt(11,magicDamageTaken);
            pstmt.setInt(12,physicalDamageDealt);
            pstmt.setInt(13,physicalDamageDealtToChampions);
            pstmt.setInt(14,physicalDamageTaken);
            pstmt.setInt(15,trueDamageDealt);
            pstmt.setInt(16,trueDamageDealtToChampions);
            pstmt.setInt(17,trueDamageTaken);
            pstmt.setInt(18,totalDamageDealt);
            pstmt.setInt(19,totalDamageDealtToChampions);
            pstmt.setInt(20,totalDamageTaken);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Insert a new row into the warehouses table
     *
     * @param accountId id of summoner account
     * @param id id of summoner
     * @param name name of summoner
     * @param profileIconId id of summoner profile icon
     * @param revisionDate date of revision
     * @param summonerLevel level of summoner
     * @param puuid puuid of summoner
     */
    public void insertSummoner(String accountId, String id, String name, int profileIconId, long revisionDate, long summonerLevel, String puuid) {
        String sql = "INSERT INTO summoners(accountId,id,name,profileIconId,revisionDate,summonerLevel,puuid) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, accountId);
            pstmt.setString(2,id);
            pstmt.setString(3,name);
            pstmt.setInt(4,profileIconId);
            pstmt.setLong(5,revisionDate);
            pstmt.setLong(6,summonerLevel);
            pstmt.setString(7,puuid);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param matchId id of match
     */
    public void insertMatch(String matchId) {
        String sql = "INSERT INTO matchList(matchId) VALUES(?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, matchId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * select all rows in the warehouses table
     */
    public void selectSummoner(){
        String sql = "SELECT accountId, name, summonerLevel FROM summoners";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(
                        rs.getString("accountId") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getLong("summonerLevel"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return Returns a Summoner Object
     */
    public Boolean SummonerExist(String username) {
        String sql = "SELECT * FROM summoners WHERE name = ?";
        boolean check = false;

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, username);

            try( ResultSet rs  = pstmt.executeQuery()){
                if(rs.next()){
                    check = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

    public Summoner getSummoner(String username){
        Summoner summoner = new Summoner.Builder()
                .withName("INIT_name")
                .withId("INIT_id")
                .withPuuid("INIT_puuid")
                .withAccountId("INIT_accountId")
                .withProfileIconId(1)
                .withRevisionDate(1)
                .withSummonerLevel(1)
                .build();
        String accountId = "INI_accountId";

        String sql1 = "SELECT accountId FROM summoners WHERE name = ?";

        String sql2 = "SELECT accountId, name, summonerLevel, id, puuid, accountId, revisionDate "
                + "FROM summoners WHERE accountId = ?";

        //Get AccountID
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql1)){
            pstmt.setString(1, username);
            ResultSet rs  = pstmt.executeQuery();
                accountId = rs.getString("accountId");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        //Get Summoner Entry
        try (Connection conn = this.connect();

             PreparedStatement pstmt  = conn.prepareStatement(sql2)){
            pstmt.setString(1, accountId);
            ResultSet rs  = pstmt.executeQuery();

            summoner = new Summoner.Builder()
                    .withName(rs.getString("name"))
                    .withId(rs.getString("id"))
                    .withPuuid(rs.getString("puuid"))
                    .withAccountId(accountId)
                    .withProfileIconId(rs.getInt("name"))
                    .withRevisionDate(rs.getLong("revisionDate"))
                    .withSummonerLevel(rs.getLong("summonerLevel"))
                    .build();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return summoner;
    }

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(database);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Update data of a warehouse specified by the id
     *
     * @param accountId id of summoner account
     * @param name name of the summoner
     * @param profileIconId ID of the profile icon
     * @param revisionDate date of revision
     * @param summonerLevel level of the summoner
     */
    public void updateSummoner(String accountId, String name, int profileIconId, long revisionDate, long summonerLevel) {
        String sql =
                "UPDATE summoners SET name = ? , "
                + "profileIconId = ? , " + "revisionDate = ? , " + "summonerLevel = ? "
                + "WHERE accountId = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(5, accountId);
            pstmt.setString(1, name);
            pstmt.setInt(2, profileIconId);
            pstmt.setLong(3, revisionDate);
            pstmt.setLong(4, summonerLevel);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void GetMatches(String puuid, String gameMode){
        String sql = "SELECT * FROM matchinfo WHERE puuid = ? AND gameMode = ?";

        //Get Summoner Entry
        try (Connection conn = this.connect();

             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setString(1, puuid);
            pstmt.setString(2, gameMode);
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            int wins = 0;
            int loses = 0;
            while (rs.next()) {
                String win;
                switch (rs.getInt("win")) {
                    case 1 -> {
                        win = "Won";
                        wins = wins + 1;
                    }
                    case 0 -> {
                        win = "Won";
                        loses = loses + 1;
                    }
                }

                System.out.println(
                        rs.getString("puuid") +  "\t" +
                                rs.getString("matchId") + "\t" +
                                rs.getString("gameMode") + "\t" +
                                rs.getInt("win")
                );
            }
            System.out.println(
                    "Wins: " +  "\t" + wins + "\t" +
                            "Loses: " +  "\t" + loses
            );

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}

