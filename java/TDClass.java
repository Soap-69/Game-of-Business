/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mingz
 */
@WebServlet(urlPatterns = {"/TDClass"})
public class TDClass extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TDClass</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TDClass at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        boolean max = false;
        //connect to database
        ConnectionClass connection = new ConnectionClass();
        connection.ConnectToDB();

        //using cookie file to get username
        Cookie[] cookie = request.getCookies();
        String username = cookie[0].getValue();
        //calling calculations
        CalculationClass cal = new CalculationClass();
        int[] numcheck = connection.StoreNumbersOfCards(username);
        //print time
        out.println("<p>The Current Time is " + new java.util.Date() + "</p>");
        String action1 = request.getParameter("action1");
        String action2 = request.getParameter("action2");
        String action3 = request.getParameter("action3");
        int actionCounter = connection.returnActionCounter(username);
        System.out.println("in the TD" + actionCounter);
        if (actionCounter == 3) {
            if (action1.length() != 0 && action2.length() == 0 && action3.length() == 0) {  // if selected  one card 
                displayOneCard(response, max, numcheck, connection, username, action1, cal, actionCounter);
            } else if (action2.length() != 0 && action1.length() == 0 && action3.length() == 0) {
                displayOneCard(response, max, numcheck, connection, username, action2, cal, actionCounter);
            } else if (action3.length() != 0 && action1.length() == 0 && action2.length() == 0) {
                displayOneCard(response, max, numcheck, connection, username, action3, cal, actionCounter);
            } else if ((action1.length() != 0 && action2.length() != 0 && action3.length() == 0) || (action1.length() != 0 && action2.length() != 0 && action3.length() != 0)) { // if play three selection
                out.println("<h1>Due to the three actions limits, the maximum number of cards you can do is one!</h1>");
            } else { // Empty selection
                connection.updateActionCounter(actionCounter - 1, username);
                out.print("<h1>You haven't selected any card yet.</h1>");
                out.println("<p><form method =\"post\" action=\"startInterface1.jsp\"></p>");
                out.println("<p><input type=\"submit\" value=\"back\">");
                out.println("</form>");
            }
        } else if (actionCounter == 1 || actionCounter == 2) {
            if (action1.length() != 0 && action2.length() == 0 && action3.length() == 0) {  // if selected  one card 
                displayOneCard(response, max, numcheck, connection, username, action1, cal, actionCounter);

            } else if (action2.length() != 0 && action1.length() == 0 && action3.length() == 0) {
                displayOneCard(response, max, numcheck, connection, username, action2, cal, actionCounter);
            } else if (action3.length() != 0 && action1.length() == 0 && action2.length() == 0) {
                displayOneCard(response, max, numcheck, connection, username, action3, cal, actionCounter);
            } else if (action1.length() != 0 && action2.length() != 0 && action3.length() == 0) { //if select two cards
                displayTwoCards(response, max, numcheck, connection, username, action1, action2, cal, actionCounter);
            } else if (action1.length() != 0 && action3.length() != 0 && action2.length() == 0) {
                displayTwoCards(response, max, numcheck, connection, username, action1, action3, cal, actionCounter);
            } else if (action2.length() != 0 && action3.length() != 0 && action1.length() == 0) {
                displayTwoCards(response, max, numcheck, connection, username, action2, action3, cal, actionCounter);
            } else if (action1.length() != 0 && action2.length() != 0 && action3.length() != 0) { //if played three selection
                out.println("<h1>Due to the three actions limits, the maximum number of cards you can do is two!</h1>");
            } else { // Empty selection
                connection.updateActionCounter(actionCounter - 1, username);
                out.print("<h1>You haven't selected any card yet.</h1>");
                out.println("<p><form method =\"post\" action=\"startInterface1.jsp\"></p>");
                out.println("<p><input type=\"submit\" value=\"back\">");
                out.println("</form>");
            }
        }//----------------------------------------------------------------------------------------------------------
        else if (actionCounter == 4) {
            out.println("<h1>You have already played three actions, no cards available from here</h1>");
            out.print(action1.length() + "  " + action1.length() + " " + action3.length());
            out.println("<p><form method =\"post\" action=\"startInterface1.jsp\"></p>");
            out.println("<p><input type=\"submit\" value=\"back\">");
            out.println("</form>");
        }
    }

    protected void displayOneCard(HttpServletResponse response, boolean max, int[] numcheck,
            ConnectionClass connection, String username, String action, CalculationClass cal, int actionCounter)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        boolean isable = false;
        isable = cal.isAbleToPurchase(action, username);
        int cash = cal.SpentOnTechnology(username, action);
        if (isable == true) {
            if (numcheck[1] != cash) { // if enough cash            
                // checking for connection
                if (connection.IsConnected()) {
                    out.println("<link href=\"styleintroduction.css\" rel=\"stylesheet\" type=\"text/css\">");
                    out.print("<body class =\"game\"");
                    out.println("<p>Hi " + username + " </p>");
                    out.println("<p>Your choice is: " + action + "</p>");
                    //getting the image of player's choice
                    out.println("<p><img src=\"gameDeck/techDev/" + action + ".PNG\" alt=\"pic\"></p>");
                    String sqlcommands = "Select user_name, " + action + " from gameinfo where user_name = '" + username + "';";
                    int i = connection.CheckingCardOwned(sqlcommands, username, action);

                    switch (i) { // if card has owned then upgrade
                        case 0:
                            sqlcommands = "UPDATE gameinfo "
                                    + "SET " + action + " = 1 WHERE user_name = '" + username + "'";
                            connection.processUpdate(sqlcommands);
                            out.println("<p> " + action + " level 1</p>");
                            break;
                        case 1:
                            sqlcommands = "UPDATE gameinfo "
                                    + "SET " + action + " = 2 WHERE user_name = '" + username + "'";
                            connection.processUpdate(sqlcommands);
                            out.println("<p> " + action + " level 2</p>");
                            break;
                        case 2:
                            sqlcommands = "UPDATE gameinfo "
                                    + "SET " + action + " = 3 WHERE user_name = '" + username + "'";
                            connection.processUpdate(sqlcommands);
                            out.println("<p> " + action + " level 3</p>");
                            break;
                        default:
                            max = true;
                            out.println("<p>You have already max the card</p>");
                            break;
                    }
                    if (max == false) { // if card is maxed
                        sqlcommands = "UPDATE gameinfo "
                                + "SET cash = " + cash + " WHERE user_name = '" + username + "'";
                        connection.processUpdate(sqlcommands);
                        out.print("<p>Current cash: " + cash);
                    } else {
                        cash = cal.cash;
                        out.print("<p>Current cash: " + cash);
                    }

                    out.println("<p><form method =\"post\" action=\"startInterface1.jsp\""
                            + "></p>");
                    out.println("<p><input type=\"submit\" value=\"back\">");
                    out.println("</form>");
                    out.println("</body>");

                } else { // connection check
                    out.println("<p>Connection Error</p>");
                }
            } else { // not enough cash
                out.println("<link href=\"styleintroduction.css\" rel=\"stylesheet\" type=\"text/css\">");
                out.print("<body class =\"game\"");
                out.print("<h1>Insufficient cash!!!</h1>");
                out.println("<p><form method =\"post\" action=\"startInterface1.jsp\""
                        + "></p>");
                out.println("<p><input type=\"submit\" value=\"back\">");
                out.println("</form>");
                out.println("</body>");
            }
        } else {
            out.println("<link href=\"styleintroduction.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.print("<body class =\"game\"");
            out.println("<h1>Not fullfill the requirements</h1>");
            out.println("<p><img src=\"gameDeck/techDev/" + action + ".PNG\" alt=\"pic\"></p>");
            out.println("<p><form method =\"post\" action=\"startInterface1.jsp\""
                    + "></p>");
            out.println("<p><input type=\"submit\" value=\"back\">");
            out.println("</form>");
            out.println("</body>");

        }
    }

    protected void displayTwoCards(HttpServletResponse response, boolean max, int[] numcheck,
            ConnectionClass connection, String username, String action1, String action2, CalculationClass cal, int actionCounter)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        boolean isable = false;
        boolean isable2 = false;
        isable = cal.isAbleToPurchase(action1, username);
        isable2 = cal.isAbleToPurchase(action2, username);
        int cash = cal.SpentOnTechnology(username, action1);
        cash = cal.SpentOnTechnology(username, action2);
        System.out.println("First step");
        if (isable == true && isable2 == true) { // if you fullfill the card requirement
            System.out.println("Second step");
            if (numcheck[1] != cash) { // if enough cash 
                System.out.println("Third step");
                // checking for connection
                if (connection.IsConnected()) {
                    System.out.println("Fourth step");
                    out.println("<link href=\"styleintroduction.css\" rel=\"stylesheet\" type=\"text/css\">");
                    out.print("<body class =\"game\"");
                    out.println("<p>Hi " + username + " </p>");
                    out.println("<p>Your choices are: " + action1 + " and " + action2 + "</p>");
                    //getting the image of player's choice
                    out.println("<p><img src=\"gameDeck/techDev/" + action1 + ".PNG\" alt=\"pic\"></p>");
                    out.println("<p><img src=\"gameDeck/techDev/" + action2 + ".PNG\" alt=\"pic\"></p>");
                    connection.updateActionCounter(actionCounter + 1, username);
                    System.out.println("update two cards:" + connection.returnActionCounter(username));
                    String sqlcommands = "Select user_name, " + action1 + ", " + action2 + " from gameinfo where user_name = '" + username + "';";
                    int i = connection.CheckingCardOwned(sqlcommands, username, action1);
                    int y = connection.CheckingCardOwned(sqlcommands, username, action2);
                    switch (i) { // if the first card has owned then upgrade
                        case 0:
                            sqlcommands = "UPDATE gameinfo "
                                    + "SET " + action1 + " = 1 WHERE user_name = '" + username + "'";
                            connection.processUpdate(sqlcommands);
                            out.println("<p> " + action1 + " level 1</p>");
                            break;
                        case 1:
                            sqlcommands = "UPDATE gameinfo "
                                    + "SET " + action1 + " = 2 WHERE user_name = '" + username + "'";
                            connection.processUpdate(sqlcommands);
                            out.println("<p> " + action1 + " level 2</p>");
                            break;
                        case 2:
                            sqlcommands = "UPDATE gameinfo "
                                    + "SET " + action1 + " = 3 WHERE user_name = '" + username + "'";
                            connection.processUpdate(sqlcommands);
                            out.println("<p> " + action1 + " level 3</p>");
                            break;
                        default:
                            max = true;
                            out.println("<p>You have already max the card</p>");
                            break;
                    }
                    switch (y) { // if the second card has owned then upgrade
                        case 0:
                            sqlcommands = "UPDATE gameinfo "
                                    + "SET " + action2 + " = 1 WHERE user_name = '" + username + "'";
                            connection.processUpdate(sqlcommands);
                            out.println("<p> " + action2 + " level 1</p>");
                            break;
                        case 1:
                            sqlcommands = "UPDATE gameinfo "
                                    + "SET " + action2 + " = 2 WHERE user_name = '" + username + "'";
                            connection.processUpdate(sqlcommands);
                            out.println("<p> " + action2 + " level 2</p>");
                            break;
                        case 2:
                            sqlcommands = "UPDATE gameinfo "
                                    + "SET " + action2 + " = 3 WHERE user_name = '" + username + "'";
                            connection.processUpdate(sqlcommands);
                            out.println("<p> " + action2 + " level 3</p>");
                            break;
                        default:
                            max = true;
                            out.println("<p>You have already max the card</p>");
                            break;
                    }
                    if (max == false) { // if card is maxed
                        sqlcommands = "UPDATE gameinfo "
                                + "SET cash = " + cash + " WHERE user_name = '" + username + "'";
                        connection.processUpdate(sqlcommands);
                        out.print("<p>Current cash: " + cash);
                    } else {
                        cash = cal.cash;
                        out.print("<p>Current cash: " + cash);
                    }

                    out.println("<p><form method =\"post\" action=\"startInterface1.jsp\""
                            + "></p>");
                    out.println("<p><input type=\"submit\" value=\"back\">");
                    out.println("</form>");
                    out.println("</body>");

                } else { // connection check
                    out.println("<p>Connection Error</p>");
                }
            } else { // not enough cash
                out.println("<link href=\"styleintroduction.css\" rel=\"stylesheet\" type=\"text/css\">");
                out.print("<body class =\"game\"");
                out.print("<h1>Insufficient cash!!!</h1>");
                out.println("<p><form method =\"post\" action=\"startInterface1.jsp\""
                        + "></p>");
                out.println("<p><input type=\"submit\" value=\"back\">");
                out.println("</form>");
                out.println("</body>");
            }
        } else {
            out.println("<link href=\"styleintroduction.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.print("<body class =\"game\"");
            out.println("<h1>Not fullfill the requirements</h1>");
            out.println("<p><img src=\"gameDeck/techDev/" + action1 + ".PNG\" alt=\"pic\"></p>");
            out.println("<img src=\"gameDeck/techDev/" + action2 + ".PNG\" alt=\"pic\">");
            out.println("<p><form method =\"post\" action=\"startInterface1.jsp\""
                    + "></p>");
            out.println("<p><input type=\"submit\" value=\"back\">");
            out.println("</form>");
            out.println("</body>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
