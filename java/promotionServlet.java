/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 19147
 */
@WebServlet(urlPatterns = {"/promotionServlet"})
public class promotionServlet extends HttpServlet {

    private int random() {//generate a random number to use as an index of cards
        Random rand = new Random();
        return rand.nextInt(10);
    }
    private int number;
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    private List<String> generatorArrayList(List<String> name, String reflection, String imageURL) {
        String openTag = "<div class=\"cards\">";
        String closeTag = "</dive>";
        name.add(openTag);
        name.add(reflection);
        name.add(imageURL);
        name.add(closeTag);
        return name;
    }

    private List<List<String>> options = new ArrayList<>();//Each arraylist in the ArrayList contains the code of a image

    private void load() {
        List<String> ifZero = new ArrayList<>();//Go viral +100% for next two round
        generatorArrayList(ifZero, "<h1 class=\"goodNews\">Congrats! We have a good news!<br/>Next two round you will have double users!</h1>",
                "<img class =\"go-viral\" src=\"images/Zero.png\" alt=\"goviral\">");
        options.add(ifZero);
        //----------------------------------------------------------------------
        List<String> ifOne = new ArrayList<>();//Great Launch +100% launchRound
        generatorArrayList(ifOne, "<h1 class=\"goodNews\">Congrats if you haven't launch yet! We have a good news for you! <br/>You will have double money bouns on your launch round!</h1>",
                "<img class =\"great-launch\" src=\"images/One.png\" alt=\"greatLaunch\">");
        options.add(ifOne);
        //----------------------------------------------------------------------
        List<String> ifTwo = new ArrayList<>();//Great MC +20% users ER
        generatorArrayList(ifTwo, "<h1 class=\"goodNews\">Congrats! We have a good news for you! <br/>You will have +20% users bouns for every upcoming round of yours!</h1>",
                "<img class =\"great-marketing-campaign\" src=\"images/Two.png\" alt=\"greatMarketingCampaign\">");
        options.add(ifTwo);
        //----------------------------------------------------------------------
        List<String> ifThree = new ArrayList<>();//Good MC +10% users ER
        generatorArrayList(ifThree, "<h1 class=\"goodNews\">Congrats! We have a good news for you! <br/>You will have +10% users bouns for every upcoming round of yours!</h1>",
                "<img class =\"good-marketing-campaign\" src=\"images/Three.png\" alt=\"goodMarketingCampaign\">");
        options.add(ifThree);
        //----------------------------------------------------------------------
        List<String> ifFour = new ArrayList<>();//OK MC +5% users ER
        generatorArrayList(ifFour, "<h1 class=\"goodNews\">Congrats! We have a good news for you! <br/>You will have +5% users bouns for every upcoming round of yours!</h1>",
                "<img class =\"OK-marketing-campaign\" src=\"images/Four.png\" alt=\"OKMarketingCampaign\">");
        options.add(ifFour);
        //----------------------------------------------------------------------
        List<String> ifFive = new ArrayList<>();//Good Strategy +10% user ER
        generatorArrayList(ifFive, "<h1 class=\"goodNews\">Congrats! We have a good news for you! <br/>You will have +10% users bouns for every upcoming round of yours!</h1>",
                "<img class =\"good-strategy\" src=\"images/Five.png\" alt=\"goodStrategy\">");
        options.add(ifFive);
        //----------------------------------------------------------------------
        List<String> ifSix = new ArrayList<>();//Alienates -10% users ER.png
        generatorArrayList(ifSix, "<h1 class=\"badNews\">OOps... This is gonna be ulgy... <br/>You will have -10% users for every upcoming round of yours... Good Luck...</h1>",
                "<img class =\"Alienates-users\" src=\"images/Six.png\" alt=\"alienatesUsers\">");
        options.add(ifSix);
        //----------------------------------------------------------------------
        List<String> ifSeven = new ArrayList<>();//Isn't working -20% user ER
        generatorArrayList(ifSeven, "<h1 class=\"badNews\">OOps... This is gonna be very ulgy... <br/>You will have -20% users for every upcoming round of yours... Good Luck...</h1>",
                "<img class =\"price-model-not-working\" src=\"images/Seven.png\" alt=\"priceModelIsn'tWorking\">");
        options.add(ifSeven);
        //----------------------------------------------------------------------
        List<String> ifEight = new ArrayList<>();//Search fails No effect
        generatorArrayList(ifEight, "<h1 class=\"noNews\">Ummmm Nothing so good, but no news is good news! <br/>Due to Search Failure.. No effect! Keep it up!</h1>",
                "<img class =\"search-failed\" src=\"images/Eight.png\" alt=\"searchFailed\">");
        options.add(ifEight);
        //----------------------------------------------------------------------
        List<String> ifNine = new ArrayList<>();//Unremarkable MC No effect
        generatorArrayList(ifNine, "<h1 class=\"noNews\">Ummmm Nothing so good, but no news is good news! <br/>Due to Unremarkable Marketing Campaign... No effect! Keep it up!</h1>",
                "<img class =\"unremarkable-MC\" src=\"images/Nine.png\" alt=\"unremarkableMC\">");
        options.add(ifNine);

    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
    private List<Integer> calcuTracker = new ArrayList<>();//containing all the percentage after shuffled out a new "everyround" card
    private int counter = 0;//for the Goviral card, will limit to create the goviral column for only one time, prevent duplicating column error

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            ConnectionClass conn = new ConnectionClass();
            conn.ConnectToDB();
            Cookie[] cookie = request.getCookies();
            String username = cookie[0].getValue();
            Pair<Integer, Integer> CandU = conn.getMoneyAndUsers(username);

            number = random();

            String name = username;
            int user = CandU.getValue();
            int money = CandU.getKey();
            int launchNumber = conn.returnLaunchNumber(username);

            if (money >= 300) {
                load();
                //load2(user, money);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Returning Result</title>");
                out.println("<link rel = \"stylesheet\" type= \"text/css\" href=\"Style.css\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<div>");
                if (number == 0) {
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                    if (counter == 0) {
                        conn.createColumnAndSetToNumber("GoViral", 2, name);
                        out.println("<h3 > We create a two counter for you!</h3>");
                        counter++;
                    } else {
                        conn.updateGoViral(2, name);
                        out.println("<h3>We refresh the counter back to two for you!</h3>");
                    }
                } else if (number == 1) {
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                    if (launchNumber == 0) {
                        conn.updateLaunchBonus(100, name);
                    } else {
                        out.println("<h3 id=\"launchWarning\"> Sorry You have already launched your company, no bouns this time!</h3>");
                    }
                } else if (number == 2) {
                    calcuTracker.add(20);
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                } else if (number == 3) {
                    calcuTracker.add(10);
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                } else if (number == 4) {
                    calcuTracker.add(5);
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                } else if (number == 5) {
                    calcuTracker.add(10);
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                } else if (number == 6) {
                    calcuTracker.add(-10);
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                } else if (number == 7) {
                    calcuTracker.add(-20);
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                } else if (number == 8) {
                    calcuTracker.add(0);
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                } else if (number == 9) {
                    calcuTracker.add(0);
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                }
                int sum = 0;
                for (int i = 0; i < calcuTracker.size(); i++) {
                    sum = sum + calcuTracker.get(i);
                }
                conn.updatePromotionBouns(sum, name); //Update how much percentage of user you will change for the next every round
                System.out.println(sum);

                money -= 1000;
                Pair<Integer, Integer> newCandU = new Pair<>(money, user);
                out.println("<h3 id=\"checkout\">You have been checked out $1000 to pay your promotion team. Thank you!</h3>");
                conn.updataMoneyAndUser(newCandU, name);

                out.println("</div>");
                out.println("<div class = \"displayMoney\">");
                out.println("<h3 id = \"newUsers\"> New users:" + user + "</h3>");
                out.println("<h3 id = \"newMoney\"> New Money amount:" + money + "</h3>");

                out.println("</div>");
                out.println("<p><form method =\"post\" action=\"startInterface1.jsp\""
                        + "></p>");
                out.println("<p><input type=\"submit\" value=\"back\">");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Returning Result</title>");
                out.println("<link rel = \"stylesheet\" type= \"text/css\" href=\"promotionServlet.css\">");
                out.println("</head>");

                out.println("<body>");
                out.println("<div>");
                out.println("<h3>No enough money for promotion</h3>");
                out.println("</div>");
                out.println("</body>");
                out.println("<p><form method =\"post\" action=\"startInterface1.jsp\""
                        + "></p>");
                out.println("<p><input type=\"submit\" value=\"back\">");
                out.println("</form>");
                out.println("</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(promotionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(promotionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(promotionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(promotionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

//private String jdbcDriver = "com.mysql.jdbc.Driver";
//    private String dataB_URL = "jdbc:mysql://localhost/practeragame";
//    private String userName = "root";
//    private String passWord = "Wc13920563167";
//
//    private Connection conn;
//    private Statement stmt;
//    private PreparedStatement pstmt;
//    private ResultSet rs;
//
//    private String grabUsername() throws SQLException, ClassNotFoundException {
//        String name;
//        Class.forName(jdbcDriver);
//        conn = DriverManager.getConnection(dataB_URL, userName, passWord);
//        stmt = conn.createStatement();
//        String sqlSelect = "select username from practeragame.playerinfor_round_1";
//        rs = stmt.executeQuery(sqlSelect);
//        while (rs.next()) {
//            name = rs.getString("username");
//            return name;
//        }
//        return null;
//    }
//
//    private int grabMoney() throws SQLException, ClassNotFoundException {
//        int money;
//        Class.forName(jdbcDriver);
//        conn = DriverManager.getConnection(dataB_URL, userName, passWord);
//        stmt = conn.createStatement();
//        String sqlSelect = "select money from practeragame.playerinfor_round_1";
//        rs = stmt.executeQuery(sqlSelect);
//        while (rs.next()) {
//            money = rs.getInt("money");
//            return money;
//        }
//        return 0;
//    }
//
//    private int grabUser() throws SQLException, ClassNotFoundException {
//        int user;
//        Class.forName(jdbcDriver);
//        System.out.println("Connecting...");
//        conn = DriverManager.getConnection(dataB_URL, userName, passWord);
//        stmt = conn.createStatement();
//        String sqlSelect = "select users from practeragame.playerinfor_round_1";
//        rs = stmt.executeQuery(sqlSelect);
//        while (rs.next()) {
//            user = rs.getInt("users");
//            return user;
//        }
//        return 0;
//    }
//
//    private void updateMoneyandUser(int money, int users, String name) throws ClassNotFoundException, SQLException {
//        Class.forName(jdbcDriver);
//        System.out.println("Connecting...");
//        conn = DriverManager.getConnection(dataB_URL, userName, passWord);
//        String sqlUpdate = "update playerinfor_round_1 set money =?, users = ? where username =?";
//        pstmt = conn.prepareStatement(sqlUpdate);
//
//        pstmt.setInt(1, money);
//        pstmt.setInt(2, users);
//        pstmt.setString(3, name);
//        pstmt.executeUpdate();
//    }
