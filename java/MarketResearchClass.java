/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ming
 */
@WebServlet(urlPatterns = {"/MarketResearchClass"})
public class MarketResearchClass extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private int random() {//generate a random number to use as an index of cards
        Random rand = new Random();
        return rand.nextInt(9);
    }
    private int number;
    //------------------------------------------------------------------------------------------------------------------

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
        generatorArrayList(ifZero, "<h1 class=\"goodNews\">Here are some suggestions for you</h1>",
                "<img class =\"go-viral\" src=\"gameDeck/marketResearch/1.png\" alt=\"1\">");
        options.add(ifZero);
        //----------------------------------------------------------------------
        List<String> ifOne = new ArrayList<>();//Great Launch +100% launchRound
        generatorArrayList(ifOne, "<h1 class=\"goodNews\">Here are some suggestions for you</h1>",
                "<img class =\"great-launch\" src=\"gameDeck/marketResearch/2.png\" alt=\"2\">");
        options.add(ifOne);
        //----------------------------------------------------------------------
        List<String> ifTwo = new ArrayList<>();//Great MC +20% users ER
        generatorArrayList(ifTwo, "<h1 class=\"goodNews\">Here are some suggestions for you</h1>",
                "<img class =\"great-marketing-campaign\" src=\"gameDeck/marketResearch/3.png\" alt=\"3\">");
        options.add(ifTwo);
        //----------------------------------------------------------------------
        List<String> ifThree = new ArrayList<>();//Good MC +10% users ER
        generatorArrayList(ifThree, "<h1 class=\"goodNews\">Here are some suggestions for you</h1>",
                "<img class =\"good-marketing-campaign\" src=\"gameDeck/marketResearch/4.png\" alt=\"4\">");
        options.add(ifThree);
        //----------------------------------------------------------------------
        List<String> ifFour = new ArrayList<>();//OK MC +5% users ER
        generatorArrayList(ifFour, "<h1 class=\"goodNews\">Here are some suggestions for you</h1>",
                "<img class =\"OK-marketing-campaign\" src=\"gameDeck/marketResearch/5.png\" alt=\"5\">");
        options.add(ifFour);
        //----------------------------------------------------------------------
        List<String> ifFive = new ArrayList<>();//Good Strategy +10% user ER
        generatorArrayList(ifFive, "<h1 class=\"goodNews\">Here are some suggestions for you</h1>",
                "<img class =\"good-strategy\" src=\"gameDeck/marketResearch/6.png\" alt=\"6\">");
        options.add(ifFive);
        //----------------------------------------------------------------------
        List<String> ifSix = new ArrayList<>();//Alienates -10% users ER.png
        generatorArrayList(ifSix, "<h1 class=\"badNews\">Here are some suggestions for you</h1>",
                "<img class =\"Alienates-users\" src=\"gameDeck/marketResearch/7.png\" alt=\"7\">");
        options.add(ifSix);
        //----------------------------------------------------------------------
        List<String> ifSeven = new ArrayList<>();//Isn't working -20% user ER
        generatorArrayList(ifSeven, "<h1 class=\"badNews\">Here are some suggestions for you</h1>",
                "<img class =\"price-model-not-working\" src=\"gameDeck/marketResearch/8.png\" alt=\"8\">");
        options.add(ifSeven);
        //----------------------------------------------------------------------
        List<String> ifEight = new ArrayList<>();//Search fails No effect
        generatorArrayList(ifEight, "<h1 class=\"noNews\">Here are some suggestions for you</h1>",
                "<img class =\"search-failed\" src=\"gameDeck/marketResearch/9.png\" alt=\"9\">");
        options.add(ifEight);

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ConnectionClass connection = new ConnectionClass();
        connection.ConnectToDB();
        CalculationClass cal = new CalculationClass();
        String sqlcommands = "";
        Cookie[] cookie = request.getCookies();
        String username = cookie[0].getValue();
        number = random();
        load();
        cal.Setter(username);
        if (cal.cash >= 300) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel = \"stylesheet\" type= \"text/css\" href=\"Style.css\">");
            out.println("<title>Returning Result</title>");
            out.println("</head>");
            out.println("<body>");
            switch (number) {
                case 0:
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                    break;
                case 1:
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                    break;
                case 2:
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                    break;
                case 3:
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                    break;
                case 4:
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                    break;
                case 5:
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                    break;
                case 6:
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                    break;
                case 7:
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                    break;
                case 8:
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                    break;
                case 9:
                    System.out.println(options.get(number).size());
                    for (int i = 0; i < options.get(number).size(); i++) {
                        out.println(options.get(number).get(i));
                    }
                    break;
                default:
                    break;
            }
            //out.println(username);
            int cash = cal.SpentOnMarketResearch(username);
            sqlcommands = "UPDATE gameinfo "
                    + "SET cash = " + cash + " WHERE user_name = '" + username + "'";
            connection.processUpdate(sqlcommands);
            out.print("<p>Current cash: " + cash);
            out.println("<p><form method =\"post\" action=\"startInterface1.jsp\""
                    + "></p>");
            out.println("<p><input type=\"submit\" value=\"back\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.print("<h1>Insufficient cash!!!</h1>");
            out.println("<p><form method =\"post\" action=\"startInterface1.jsp\""
                    + "></p>");
            out.println("<p><input type=\"submit\" value=\"back\">");
            out.println("</form>");
        }

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        processRequest(request, response);

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }
}
