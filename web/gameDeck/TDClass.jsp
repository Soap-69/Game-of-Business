<%-- 
    Document   : TDClass
    Created on : Apr 30, 2020, 8:53:20 PM
    Author     : mingz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pop-up Example</title>
        <link href="style3.css" rel="stylesheet" type="text/css">
    </head>
    <body class="pop-up">
        <div id="pop-up">
            <img src="gameDeck/cute.png">
            <div class="container">
                <h1>Game On</h1>
                <p>Select one from following</p>
                <div class="drop-down">
                    <select name="forma" onchange="location = this.value;">
                        <option></option>
                        <option value="" Select disabled>-- Front End --</option>
                        <option value="TDIntroduction.jsp"></option>
                        <option value="MRIntroduction.jsp">Market Research</option>
                        <option value="PromotionIntroduction.jsp">Promotion</option>
                        <option value="" Select disabled>-- Infrastructure --</option>
                        <option value="" Select disabled>-- Web Services --</option>
                    </select>
                    <a href="MRIntroduction.jsp">Market Research</a><br>
                    <a href="PromotionIntroduction.jsp">Promotion</a><br>
                    <a href="TDIntroduction.jsp">Technology Development</a><br>
                    <div class="start">
                        <form action="strat2.jsp">                         
                            <button type="submit">submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
