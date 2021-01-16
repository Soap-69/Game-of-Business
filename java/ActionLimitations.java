/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/ActionLimitations"})
public class ActionLimitations extends HttpServlet {

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
            out.println("<title>Servlet ActionLimitations</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActionLimitations at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     *
     */
    protected int counter;

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
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter out = response.getWriter();
        ConnectionClass conn = new ConnectionClass();
        conn.ConnectToDB();
        Cookie[] cookie = request.getCookies();
        String username = cookie[0].getValue();
        //System.out.println(counter);
        String buttonMR = request.getParameter("MR");
        String buttonPro = request.getParameter("Pro");
        String buttonTech = request.getParameter("Tech");
        String startButton = request.getParameter("endround");
        String launch = request.getParameter("launchApp");
        if ("button1".equals(buttonMR) || "button2".equals(buttonPro) || "button3".equals(buttonTech)) {
            System.out.println("increment called");
            counter = conn.returnActionCounter(username);
            System.out.print("something" + counter);
            counter += 1;
            System.out.println("after called:" + counter);
            conn.updateActionCounter(counter, username);
        }
        System.out.println("new counter" + counter);
        if (counter <= 3) {
            if ("button1".equals(buttonMR)) {
                displayMR(response);
            } else if ("button2".equals(buttonPro)) {
                try {
                    DisplayPromotion(response, request);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if ("button3".equals(buttonTech)) {
                displayTDAction(response);
            }
        } else if (counter > 3 && !"endround".equals(startButton)) {
            out.println("<h2>You have already used all three actions in this round. No more action avaliable!</h2>");
            out.println("<p><form method =\"post\" action=\"startInterface1.jsp\"></p>");
            out.println("<p><input type=\"submit\" value=\"back\">");
            out.println("</form>");
        }

        if (counter >= 3 && "endround".equals(startButton) && !"launch".equals(launch)) {
            counter = 0;
            conn.updateActionCounter(counter, username);
            String report = "You finished your round by fully using all the actions";
            endRoundUpdate(response, request, report);

        } else if (counter < 3 && "endround".equals(startButton) && !"launch".equals(launch)) {
            String report = "You finished your round by using " + counter + " actions";
            endRoundUpdate(response, request, report);
            counter = 0;
            conn.updateActionCounter(counter, username);
        } else if (counter < 3 && "endround".equals(startButton) && "launch".equals(launch)) {
            checkToLaunch(response, request);
            String report = "You finished your round by using " + counter + " actions";
            endRoundUpdate(response, request, report);
            counter = 0;
            conn.updateActionCounter(counter, username);
        } else if (counter >= 3 && "endround".equals(startButton) && "launch".equals(launch)) {
            checkToLaunch(response, request);
            String report = "You finished your round by fully using all the actions";
            endRoundUpdate(response, request, report);
            counter = 0;
            conn.updateActionCounter(counter, username);
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

    /**
     *
     * @param response
     * @param request
     * @param report
     * @throws IOException
     */
    protected void endRoundUpdate(HttpServletResponse response, HttpServletRequest request, String report) throws IOException {
        PrintWriter out = response.getWriter();
        CalculationClass cal = new CalculationClass();
        ConnectionClass conn = new ConnectionClass();
        conn.ConnectToDB();
        Cookie[] cookie = request.getCookies();
        String username = cookie[0].getValue();

        int round = conn.selectRound(username);
        round++;
        conn.updataRound(username, round);
        String sqlcommands = "";
        int launchCheck = conn.returnLaunchNumber(username);
        int users = cal.NewUsersThisRound(username);
        int cash = cal.CashEarnedThisRound(username);
        sqlcommands = "UPDATE gameinfo "
                + "SET cash = " + cash + " WHERE user_name = '" + username + "'";
        if (launchCheck == 1) {
            conn.updateUsers(users, username);
            conn.processUpdate(sqlcommands);

        }

        out.println("<p>The Current Time is " + new java.util.Date() + "</p>");
        int[] num = conn.StoreNumbersOfCards(username);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet EndRoundResult</title>");
        out.println("</head>");
        out.println("<link href=\"styleintroduction.css\" rel=\"stylesheet\" type=\"text/css\">");
        out.print("<body class =\"game\"");
        out.println("<h1>" + report + "</h1>");
        if (round <= 15) {
            out.println("<h1>Round " + round + "</h1>");
        } else {
            out.println("<h1>Game Over! Well Played</h1>");
        }
        out.println("<p>Current Cash " + num[1] + "</p>");
        out.println("<p>Current Users " + num[2] + "</p>");
        out.println("<p>hardware " + num[3] + "</p>");
        out.println("<p>integration " + num[4] + "</p>");
        out.println("<p>multiuser " + num[5] + "</p>");
        out.println("<p>navigation " + num[6] + "</p>");
        out.println("<p>notification " + num[7] + "</p>");
        out.println("<p>search " + num[8] + "</p>");
        out.println("<p>user interface " + num[9] + "</p>");
        out.println("<p>analytics " + num[10] + "</p>");
        out.println("<p>location " + num[11] + "</p>");
        out.println("<p>market place " + num[12] + "</p>");
        out.println("<p>media " + num[13] + "</p>");
        out.println("<p>social " + num[14] + "</p>");
        out.println("<p>storage " + num[15] + "</p>");
        out.println("<p>sync " + num[16] + "</p>");
        out.println("<p>code " + num[17] + "</p>");
        out.println("<p>analytic server " + num[18] + "</p>");
        out.println("<p>application server " + num[19] + "</p>");
        out.println("<p>database server " + num[20] + "</p>");
        out.println("<p>external API " + num[21] + "</p>");
        out.println("<p>privacy " + num[22] + "</p>");
        out.println("<p>security " + num[23] + "</p>");
        out.println("<p><form method =\"post\" action=\"startInterface1.jsp\""
                + "></p>");
        out.println("<p><input type=\"submit\" value=\"continue\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

    } //This is the EndRoundResult.java

    /**
     *
     * @param response
     * @param request
     * @throws IOException
     */
    protected void checkToLaunch(HttpServletResponse response, HttpServletRequest request) throws IOException {
        int launchCheck = 0; // will be re-assign down below to prevent if the player have already launched
        PrintWriter out = response.getWriter();
        ConnectionClass connection = new ConnectionClass();
        connection.ConnectToDB();
        Cookie[] cookie = request.getCookies();    //Get username by connection
        String username = cookie[0].getValue();
        launchCheck = connection.returnLaunchNumber(username);  // re-assign the launchCheck by checking DB
        int counterForChecks = 3;
        int[] checks = connection.checkLaunchConditions(username);
        for (int i = 0; i < checks.length; i++) {
            System.out.println(checks[i]);               //by using the checkLaunch function to get an array of three cards' level, example: [1,1,1] 
            if (checks[i] < 1) {                         //if any element in the array is not above or equal to 1, it means the player is not quailfied, 
                counterForChecks--;                      //correspondent reaction reflected down below
            }
        }
        if (counter == 0 && counterForChecks == 3 && launchCheck == 0) {
            out.println("<h3>launch Passed! You successfully launch your company!</h3>");
            connection.setLaunch(username);                                           //this portion will run only if the user didn't play any action and has the three cards in hand //then it will set Launch column to 1

        } else if (counter != 0 && counterForChecks == 3 && launchCheck == 0) {  //error1: played action
            out.println("<h3>Sorry you can't play any actions if you want to launch your company at this round</h3>");
        } else if (counter == 0 && counterForChecks != 3 && launchCheck == 0) {  //error2: no enough cards 
            out.println("<h3>Sorry you didn't have enough technology cards yet, please check your cards</h3>");
        } else if (counter == 0 && counterForChecks == 3 && launchCheck != 0) {   //error3: already launched
            out.println("<h3>You have already launched.</h3>");
        }
    }

    /**
     *
     * @param response
     * @throws IOException
     */
    protected void displayMR(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Introduction Pages</title>");
        out.println("<link href=\"styleintroduction.css\" rel=\"stylesheet\" type=\"text/css\">");
        out.println("</head>");
        out.println("<body class= \"game\">");
        out.println("<h1>Welcome to Market Research Department</h1>");
        out.println("<br></br>");
        out.println("<img src=\"gameDeck/marketResearch/10.PNG\" width=\"305\" height=\"300\" border=\"1\"");
        out.println("alt=\"card description\" />");
        out.println("<div class= \"button\">");
        out.println("<form action=\"MarketResearchClass\">");
        out.println("<input type=\"submit\" value=\"get-card!\">");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    } // This is the Market Research interface

    /**
     *
     * @param response
     * @param request
     * @throws IOException
     */
    protected void DisplayPromotion(HttpServletResponse response, HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<title>Promotion</title>");
        out.println("<link rel = \"stylesheet\" type=\"text/css\" href=\"PomotionStyle.css\">");
        out.println("</head>");
        out.println("<body>");

        ConnectionClass connection = new ConnectionClass();
        connection.ConnectToDB();
        Cookie[] cookie = request.getCookies();                                             //Get username, money, users from DB
        String username = cookie[0].getValue();
        Pair<Integer, Integer> CandU = connection.getMoneyAndUsers(username);
        int money = CandU.getKey();
        int user = CandU.getValue();
        out.println("<div id=\"usernameDisplay\">");
        //out.println("<h3 id=\"usernameFromDB\"><br/>Hi " + username + "<br/>Money:" + money + "<br/>Users:" + user + "</h3>");
        out.println("</div>");

        out.println("<div class=\"Description\">");
        out.println("<h1 >Welcome to promotion department</h1> ");
        out.println("</div>");
        out.println("<div class=\"prompt\">");
        out.println("<h2>We are here to help you gain more profit by bravely taking a risk. ");
        out.println("<br/>Be prepare to receive some bad news before you make you decision!</h2>");
        out.println("<form method =\"get\" action =\"promotionServlet\">");
        out.println("<input type = \"submit\" name = \"promotionButton\" value = \"promotion\">");
        out.println("</form>");
        out.println("<form action = \"startInterface1.jsp\">");
        out.println("<input type=\"submit\" name =\"back\" value =\"back\" >");
        out.println(" </form>");
        out.println("</div>");
        out.println("<footer id = \"footer\">");
        out.println("<h5 id=\"footerInfor\">Presented by Team3</h5>");
        out.println("</footer>");
        out.println("</body>");
        out.println("</html>");

    } // Thisis the Promotion interface 

    /**
     *
     * @param response
     * @throws IOException
     */
    protected void displayTDAction(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Introduction Pages</title>");
        out.println("<link href=\"styleintroduction.css\" rel=\"stylesheet\" type=\"text/css\">");
        out.println("</head>");
        out.println("<body class=\"game\">");
        out.println("<h1>Welcome to Technology Development</h1>");
        out.println("<br></br>");
        out.println("<p>UI - Interface 200 navigation 300 notification 400 search 600 hardware 800 integration 1000 multiuser 1500");
        out.println("<p>Services - social 200 location 300 media 400 sync 600 storage 800 marketplace 1000 analytics 1500");
        out.println("<p>Data - code 200 app server 300 db server 400 api 600 privacy 800 analytics 1000 security 1500");
        out.println("<h2>You can Select up to two cards here:</h2>");
        out.println(" <style>\n"
                + "            select{\n"
                + "                width : 300px;\n"
                + "                height: 400px;\n"
                + "            }\n"
                + "        </style>");
        out.println("<form action=\"TDClass\"  method =\"get\">");
        out.println("<div>");
        out.println("<p><select id=\"action1\" name=\"action1\" onchange =\"selectionForAction1()\" "
                + "style=\"background-image: url(gameDeck/techDev/frontEnd/techDevelopment.PNG); background-size: contain; background-repeat: no-repeat; \" >");
        out.println("<option style = \"font-weight: bold\"></option>");
        out.println("<option value=\"\" Select disabled>-- Front End --</option>");
        out.println("<option value=\"hardware\" name = \"hardware\" >hardware</option>");
        out.println("<option value=\"integration\" name = \"integration\" >integration</option>");
        out.println("<option value=\"multiuser\" name = \"multiuser\" >multiuser</option>");
        out.println("<option value=\"navigation\" name = \"navigation\" >navigation</option>");
        out.println("<option value=\"notifications\" name = \"notifications\" >notifications</option>");
        out.println("<option value=\"search\" name = \"search\" >search</option>");
        out.println("<option value=\"userInterface\" name = \"user Interface\" >user interface</option>");
        out.println("</select>");

        out.println("<select id=\"action2\" name=\"action2\" onchange =\"selectionForAction2()\" "
                + "style=\"background-image: url(gameDeck/techDev/webServices/12.PNG); background-size: contain; background-repeat: no-repeat; \">  ");
        out.println("<option></option>");
        out.println("<option value=\"\" Select disabled>-- Web Service --</option>");
        out.println("<option value=\"analytics\" name = \"analytics\" >analytics</option>");
        out.println("<option value=\"location\" name = \"location\" >location</option>");
        out.println("<option value=\"marketplace\" name = \"marketplace\" >marketplace</option>");
        out.println("<option value=\"media\" name = \"media\" >media</option>");
        out.println("<option value=\"social\" name = \"social\" >social</option>");
        out.println("<option value=\"storage\" name = \"storage\" >storage</option>");
        out.println("<option value=\"sync\" name = \"sync\" >sync</option>");
        out.println("</select>");

        out.println("<select id=\"action3\" name=\"action3\" onchange =\"selectionForAction3()\" "
                + "style=\"background-image: url(gameDeck/techDev/infrastructure/19.PNG); background-size: contain; background-repeat: no-repeat; \">");
        out.println("<option></option>");
        out.println("<option value=\"\" Select disabled>-- Infrastructure --</option>");
        out.println("<option value=\"code\" name = \"code\" >code</option>");
        out.println("<option value=\"analytics_server\" name = \"analytics_server\" >analytics</option>");
        out.println("<option value=\"applicationServer\" name = \"applicationServer\" >application server</option>");
        out.println("<option value=\"databaseServer\" name = \"databaseServer\" >database server</option>");
        out.println("<option value=\"externalApi\" name = \"externalApi\" >external API</option>");
        out.println("<option value=\"privacy\" name = \"privacy\" >privacy</option>");
        out.println("<option value=\"security\" name = \"security\" >security</option>");
        out.println("</select>");
        out.println("</p>");
        out.println("</div>");
        out.println("<input type=\"submit\" value=\"Comfirm\">");
        out.println("</form>");
        out.println("<script type=\"text/javascript\">");
        out.println("function selectionForAction1() {\n"
                + "                var selection = document.getElementById(\"action1\");\n"
                + "                var selectedValue = selection.options[selection.selectedIndex].value;\n"
                + "            }");
        out.println("function selectionForAction2() {\n"
                + "                var selection = document.getElementById(\"action2\");\n"
                + "                var selectedValue = selection.options[selection.selectedIndex].value;\n"
                + "            }");
        out.println("function selectionForAction3() {\n"
                + "                var selection = document.getElementById(\"action3\");\n"
                + "                var selectedValue = selection.options[selection.selectedIndex].value;\n"
                + "            }");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    }  //This is the Tech Cards interface 
}
