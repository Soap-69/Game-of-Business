<%-- 
    Document   : startInterface1
    Created on : Apr 30, 2020, 3:56:06 PM
    Author     : mingz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pop-up Example</title>
        <link href="style3.css" rel="stylesheet" type="text/css">
        <link href="styleintroduction.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="game">
            <nav>
                <h1>Welcome to Game!</h1>
                <ul>
                    <li><a href="#">Front End</a>
                        <ul>
                            <li><a href="gameDeck/techDev/hardware.PNG">hardware</a></li>
                            <form>
                                <input type="button" value="Go back!" onclick="history.back()">
                            </form>
                            <li><a href="gameDeck/techDev/integration.PNG">integration</a></li>
                            <li><a href="gameDeck/techDev/multiuser.PNG">multiuser</a></li>
                            <li><a href="gameDeck/techDev/navigation.PNG">navigation</a></li>
                            <li><a href="gameDeck/techDev/notifications.PNG">notifications</a></li>
                            <li><a href="gameDeck/techDev/search.PNG">search</a></li>
                            <li><a href="gameDeck/techDev/userInterface.PNG">userInterface</a></li>

                        </ul></li>
                    <li><a href="#">Web Service</a>
                        <ul>
                            <li><a href="gameDeck/techDev/analytics.PNG">analytics</a></li>
                            <li><a href="gameDeck/techDev/location.PNG">location</a></li>
                            <li><a href="gameDeck/techDev/marketplace.PNG">marketplace</a></li>
                            <li><a href="gameDeck/techDev/media.PNG">media</a></li>
                            <li><a href="gameDeck/techDev/social.PNG">social</a></li>
                            <li><a href="gameDeck/techDev/storage.PNG">storage</a></li>
                            <li><a href="gameDeck/techDev/sync.PNG">sync</a></li>

                        </ul></li>

                    <li><a href="#">Infrastructure</a>
                        <ul>
                            <li><a href="gameDeck/techDev/code.PNG">code</a></li>
                            <li><a href="gameDeck/techDev/analytics_server.PNG">analytics</a></li>
                            <li><a href="gameDeck/techDev/applicationServer.PNG">application Server</a></li>
                            <li><a href="gameDeck/techDev/databaseServer.PNG">database server</a></li>
                            <li><a href="gameDeck/techDev/externalApi.PNG">external Api</a></li>
                            <li><a href="gameDeck/techDev/privacy.PNG">privacy</a></li>
                            <li><a href="gameDeck/techDev/security.PNG">security</a></li>

                        </ul></li>
                </ul>
            </nav>
    </body>
    <div class="pop-up">
        <div id="pop-up">
            <img src="gameDeck/cute.png">
            <div class="container">
                <h1>Game On</h1>
                <p>Select one from following</p>
                <form action = "ActionLimitations" method = "get">  
                    <button type = "submit" name = "MR" value = "button1">Market Research</button>
                    <button type = "submit" name = "Pro" value = "button2">Promotion</button>
                    <button type = "submit" name = "Tech" value = "button3">Technology Cards</button>        
                    <div>
                        <br>
                        <input id ="l" type="checkbox" name="launchApp" value="launch">Launch
                    </div>
                    <br>
                    <div class="start">
                        <button type="submit" name = "endround" value = "endround">End Round</button>                
                </form>  
            </div>
        </div>
    </div>   
</div>
</body>

</html>
