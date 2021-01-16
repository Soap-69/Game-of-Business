/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Pair;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mingz
 */
public class ConnectionClass {
    //connection for the database

    /**
     *
     */

    protected Connection connection;

    // Statement to execute SQL commands

    /**
     *
     */
    protected Statement statement;

    /**
     *
     */
    protected PreparedStatement prepareStatement;
    // 

    /**
     *
     */
    protected ResultSet result_set;
    //DBC info for a database connection
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/BusinessGame";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "I937146zxcvb!";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private boolean connected = false;

    ConnectionClass() {

    }

    //Connect to DB

    /**
     *
     */
    protected void ConnectToDB() {

        String driver = DRIVER;
        String url = DATABASE_URL;
        String username = DATABASE_USERNAME;
        String password = DATABASE_PASSWORD;

        /*
        String driver = DRIVER;
        String url= DATABASE_URL;
        String username = this.username.getText().trim();
        String password = this.password.getText().trim();
         */
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            // connect.setText("Connected");
            this.connected = true;
        } catch (java.lang.Exception ex) {
            // connect.setText("Not Connected");
            this.connected = false;
            ex.printStackTrace();
        }

    }

    /**
     *
     * @return
     */
    protected boolean IsConnected() {
        return connected;
    }

    /**
     *
     * @param sqlCommand
     */
    protected void processSQLSelect(String sqlCommand) {
        try {
            // get a new Statement for current connnectin
            statement = connection.createStatement();
            //Execute a SELECT SQL command
            result_set = statement.executeQuery(sqlCommand);
            //Find the number of columns in the result set
            int columnCount = result_set.getMetaData().getColumnCount();
            String row = "";

            for (int i = 1; i <= columnCount; i++) {
                row += result_set.getMetaData().getColumnName(i) + "\t";
                System.out.print(result_set.getMetaData().getColumnName(i) + "\t");

            }
            while (result_set.next()) {
                //reset row to empty
                row = "";
                for (int i = 1; i <= columnCount; i++) {
                    // A non-String column is converted to a string
                    row += result_set.getString(i) + "\t";
                    System.out.print(result_set.getString(i) + "\t");

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param sqlCommand
     */
    protected void processInsertInto(String sqlCommand) {
        try {
            // get a new Statement for current connnectin
            statement = connection.createStatement();
            //Execute a SELECT SQL command
            statement.executeUpdate(sqlCommand);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param sqlCommand
     */
    protected void processUpdate(String sqlCommand) {
        try {
            // get a new Statement for current connnectin
            statement = connection.createStatement();
            //Execute a SELECT SQL command
            statement.executeUpdate(sqlCommand);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param sqlCommand
     * @param s
     * @param n
     * @return
     */
    protected int CheckingCardOwned(String sqlCommand, String s, String n) {
        int i = 0;
        try {
            // get a new Statement for current connnectin
            statement = connection.createStatement();
            //Execute a SELECT SQL command
            result_set = statement.executeQuery(sqlCommand);
            while (result_set.next()) {
                i = result_set.getInt(n);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return i;
    }

    /**
     *
     * @param n
     * @return
     */
    protected int[] StoreNumbersOfCards(String n) {
        int[] num = new int[24];
        try {
            String sqlCommand = "SELECT round, cash, users, hardware, integration, multiuser, navigation,"
                    + "notifications, search, userInterface, analytics, location, marketplace, media,"
                    + "social, storage, sync, code, analytics_server, applicationServer, databaseServer,"
                    + "externalApi, privacy, security FROM gameinfo WHERE user_name = '" + n + "';";
            // get a new Statement for current connnectin
            statement = connection.createStatement();
            //Execute a SELECT SQL command
            result_set = statement.executeQuery(sqlCommand);

            while (result_set.next()) {
                for (int i = 1; i < 25; i++) {
                    num[i - 1] = result_set.getInt(i);
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return num;
    }

    /**
     *
     */
    protected void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }

    /**
     *
     * @param sqlCommand
     * @return
     */
    protected boolean isUserExsit(String sqlCommand) { // check if user exsits
        boolean e = false;

        try {
            // get a new Statement for current connnectin
            statement = connection.createStatement();
            //Execute a SELECT SQL command
            result_set = statement.executeQuery(sqlCommand);

            if (result_set.next()) { // if successfully execute the sql commands
                e = true;
            } else {
                e = false;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }

    //-------------------------------------------------------------------------------------

    /**
     *
     * @param n
     * @return
     */
    protected int selectRound(String n) {
        int round;
        try {
            statement = connection.createStatement();
            String sql = "select round from gameinfo where user_name = '" + n + "';";
            result_set = statement.executeQuery(sql);
            while (result_set.next()) {
                round = result_set.getInt("round");
                return round;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return round = -1;
    }

    /**
     *
     * @param n
     * @param round
     */
    protected void updataRound(String n, int round) {
        try {
            String sql = "update gameinfo set round = ? where user_name = ?";
            prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, round);
            prepareStatement.setString(2, n);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param n
     */
    protected void setLaunch(String n) {
        try {
            statement = connection.createStatement();
            String sql = "update gameinfo set launch = ? where user_name = ?";
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, 1);
            prepareStatement.setString(2, n);
            prepareStatement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param n
     * @return
     */
    protected Pair<Integer, Integer> getMoneyAndUsers(String n) {
        Pair<Integer, Integer> CandU = null;
        try {
            statement = connection.createStatement();
            String sql = "select cash, users FROM gameinfo WHERE user_name = '" + n + "';";
            result_set = statement.executeQuery(sql);
            while (result_set.next()) {
                int cash = result_set.getInt("cash");
                int users = result_set.getInt("users");
                CandU = new Pair<>(cash, users);
                return CandU;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return CandU;
    }

    /**
     *
     * @param CandU
     * @param n
     */
    protected void updataMoneyAndUser(Pair<Integer, Integer> CandU, String n) {
        String sql = "update gameinfo set cash = ?, users = ? where user_name = ?";
        try {
            prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, CandU.getKey());
            prepareStatement.setInt(2, CandU.getValue());
            prepareStatement.setString(3, n);
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param number
     * @param n
     */
    protected void updateUsers(int number, String n){
        String sql = "update gameinfo set users = ? where user_name = ?";
        try {
            prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, number);
            prepareStatement.setString(2, n);
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param n
     * @return
     */
    protected int[] checkLaunchConditions(String n) {
        int[] checks = new int[3];
        try {
            statement = connection.createStatement();

            String sql = "select code, userInterface, applicationServer FROM gameinfo WHERE user_name = '" + n + "';";
            result_set = statement.executeQuery(sql);

            while (result_set.next()) {
                for (int i = 0; i < checks.length; i++) {
                    checks[i] = result_set.getInt(i + 1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checks;
    }

    /**
     *
     * @param n
     * @return
     */
    protected int returnLaunchNumber(String n) {
        try {
            statement = connection.createStatement();
            String sql = "select launch from gameinfo where user_name = '" + n + "';";
            result_set = statement.executeQuery(sql);
            while (result_set.next()) {
                int launch = result_set.getInt("launch");
                return launch;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     *
     * @param nameOfColumn
     * @param defaultNumber
     * @param n
     */
    protected void createColumnAndSetToNumber(String nameOfColumn, int defaultNumber, String n) {
        try {
            statement = connection.createStatement();
            String sql = "ALTER TABLE gameinfo ADD COLUMN " + nameOfColumn + " INT NOT NULL;";
            statement.execute(sql);

            String sql2 = "update gameinfo set " + nameOfColumn + " =? where user_name = ?";
            prepareStatement = connection.prepareCall(sql2);
            prepareStatement.setInt(1, defaultNumber);
            prepareStatement.setString(2, n);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param number
     * @param n
     */
    protected void updateGoViral(int number, String n){
        String sql = "update gameinfo set GoViral = ? where user_name = ?";
        try {
            prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, number);
            prepareStatement.setString(2, n);
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param sum
     * @param n
     */
    protected void updatePromotionBouns(int sum, String n) {
        String sql = "update gameinfo set totalBonusFromPromotion = ? where user_name = ?";
        try {
            prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, sum);
            prepareStatement.setString(2, n);
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param num
     * @param n
     */
    protected void updateLaunchBonus(int num, String n){
        String sql = "update gameinfo set launchBonus = ? where user_name = ?";
        try {
            prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, num);
            prepareStatement.setString(2, n);
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param n
     * @param column
     * @return
     */
    protected int returnBonus(String n, String column){
        int Bonus = 0;
        try {
            statement = connection.createStatement();
            String sql = "select " + column + " from gameinfo where user_name = '" + n + "';";
            result_set = statement.executeQuery(sql);
            while (result_set.next()) {
                 Bonus = result_set.getInt(column); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Bonus;
    }
    protected void updateActionCounter(int num, String n){
        String sql = "update gameinfo set actionCounter = ? where user_name = ?";
        try {
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, num);
            prepareStatement.setString(2, n);
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected int returnActionCounter(String n){
        try {
            statement = connection.createStatement();
            String sql = "select actionCounter from gameinfo where user_name = '" + n + "';";
            result_set = statement.executeQuery(sql);
            while (result_set.next()) {
                int actionCounter = result_set.getInt("actionCounter");
                return actionCounter;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    protected void updateTechCard(int num, String n){
        String sql = "update gameinfo set techCardAmount = ? where user_name = ?";
        try {
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, num);
            prepareStatement.setString(2, n);
            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected int returnTechCard(String n){
        try {
            statement = connection.createStatement();
            String sql = "select techCardAmount from gameinfo where user_name = '" + n + "';";
            result_set = statement.executeQuery(sql);
            while (result_set.next()) {
                int actionCounter = result_set.getInt("actionCounter");
                return actionCounter;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
}
