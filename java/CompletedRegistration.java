/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mingz
 */
public class CompletedRegistration extends HttpServlet {

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
            out.println("<title>Servlet CompletedRegistration</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CompletedRegistration at " + request.getContextPath() + "</h1>");
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
        ConnectionClass connection = new ConnectionClass();
        connection.ConnectToDB();
        String username = request.getParameter("userName");
        String password = request.getParameter("passWord");
        String re_password = request.getParameter("re-passWord");
        if (connection.IsConnected()) { // checking for connection
            if (username.length() == 0 || password.length() == 0) { // checking for empty input
                out.println("<p>Username and Password are required</p>");
            } else {
                if (password.equals(re_password)) {
                    // Save data into cookie
                    Cookie cookieUsername = new Cookie("username", username);
                    response.addCookie(cookieUsername);
                    Cookie cookiePassword = new Cookie("password", password);
                    response.addCookie(cookiePassword);

                    RegisterInfomationSheet rifs = new RegisterInfomationSheet();
                    rifs.setUsername(username);
                    rifs.setPassword(password);
                    // get an HttpSession or create one if it does not exsit
                    HttpSession httpSession = request.getSession();
                    // store user info to the session
                    httpSession.setAttribute("Account Info", rifs);
                    out.println("You entered the following data");
                    out.println("<p>Username: </p>" + username);
                    out.println("<p>Password: </p>" + password);
                   // connection.createColumnAndSetToNumber("launch", 0, username);//Create the launch column for every new user
                   // connection.createColumnAndSetToNumber("totalBonusFromPromotion", 0, username); //create the promotion bouns column for every new userS
                   // connection.createColumnAndSetToNumber("launchBonus", 0, username);//create the launch bonus column 
                    out.println("<p><form method =\"post\" action="
                            + "CompletedRegistration></p>");
                    out.println("<p><input type=\"submit\" value=\"Comfirm\">");
                    out.println("</form>");
                    
                } else {
                    out.println("<p>Password are not matching</p>");
                }
            }
        } else { // connection check
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
        // connection to database
        ConnectionClass connection = new ConnectionClass();
        connection.ConnectToDB();
        // Set response type and output stream to the browser
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cookie[] cookie = request.getCookies();
        //Obtain the HttpSession
        HttpSession httpSession = request.getSession();
        // Get the Account Info object in the httpSession
        RegisterInfomationSheet rifs
                = (RegisterInfomationSheet) (httpSession.getAttribute("Account Info"));

        String sqlcomand = "SELECT * "
                + "FROM gameinfo Where (user_name) = ('"
                + rifs.getUsername() + "')";

        if (connection.isUserExsit(sqlcomand) == true) {
            out.println("<p>User Already Exist</p>");
        } else {
            sqlcomand = "Insert INTO gameinfo(user_name, pass_word)"
                    + "value ('" + rifs.getUsername() + "','" + rifs.getPassword()
                    + "');";
            connection.processInsertInto(sqlcomand);
            out.println("<p>" + rifs.getUsername() + " " + rifs.getPassword()
                    + " is now registered in the database</p>");
        }

        out.println("<p><form method =\"post\" action="
                + "index.html></p>");
        out.println("<p><input type=\"submit\" value=\"Comfirm\">");
        out.println("</form>");

        out.close();
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
