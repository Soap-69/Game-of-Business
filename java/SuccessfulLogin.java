/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/SuccessfulLogIn"})
public class SuccessfulLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SuccessfulLogIn</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SuccessfulLogIn at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Obtain parameters from the client
        String username = request.getParameter("userName");
        String password = request.getParameter("passWord");

        ConnectionClass connection = new ConnectionClass();
        connection.ConnectToDB();
        int num[] = connection.StoreNumbersOfCards(username);
        
        out.println("<p>The Current Time is " + new java.util.Date() + "</p>");
        if (connection.IsConnected()) { // checking for connection
            if (username.length() == 0 || password.length() == 0) { // checking for empty input
                out.println("Invalid Username or Password");
            } else { // not empty input
                String command = "SELECT * "
                        + "FROM gameinfo Where (user_name, pass_word) = ('"
                        + username + "','" + password + "')";
                if (connection.isUserExsit(command) == true) { // if user exists
                    Cookie cookieUsername = new Cookie("username", username);
                    response.addCookie(cookieUsername);
                    out.print("<body>");
                    out.print("<style>");
                    out.print("body {"
                           + "background-image:url('gameDeck/gameinfobackground.PNG');");
                    out.print("background-repeat:no-repeat;");
                    out.print("background-size:80% 80%;");
                    out.print("background-position:center;");
                    out.print("}");
                    out.println("</style>");
                    out.print("</body>");
                    out.println("<p>Welcome " + username + "</p>");
                    out.println("<p><form method =\"post\" action=\"startInterface1.jsp\""
                            + "></p>");
                    out.println("<p><input type=\"submit\" value=\"Start Game\">");
                    out.println("</form>");
                    /*for(int i = 0; i < 24; i ++ ){
                        out.print(num[i] + " ");
                    }*/
                } else { // if user does not exist
                    out.println("<p>User Not exist, please register</p>");
                }
            }
        } else { // connection
            out.println("<p>Connection Error</p>");
        }

        out.close();
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
