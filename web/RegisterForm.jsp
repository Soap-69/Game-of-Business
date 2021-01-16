<%-- 
    Document   : RegisterForm
    Created on : Apr 9, 2020, 8:55:18 PM
    Author     : mingz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="StyleSheet1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <form action="CompletedRegistration" method = "get">
      <div class ="loginbox">  
                <h3><label class="serif">Registration</label></h3>
                <p><label class ="serif">Username</label></p>
                <input type="text" name ="userName" placeholder="Enter username">
                <p><label class="serif">Password</label></p>
                <input type="password" name="passWord" placeholder="Enter password">
                <p><label class="serif">re-Password</label></p>
                <input type="password" name="re-passWord" placeholder="Repeat password">
                <input type="submit" name="Register" value="Register">           
            </div>   
        </form>
    </body>
</html>
