<%@ page contentType="text/html;charset=UTF-8" %>

<%-- Created by Ionescu Radu Stefan --%>

<html>
    <head>
        <title>CarExpress - Menu</title>
        <link href="../styles/Style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="title">
            CarExpress
            <input class="languageIcon" type="image" src="../icons/iEN.png" align="right">
            <input class="languageIcon" type="image" src="../icons/iRO.png" align="right">
        </div>
        <div id="menuForm">
            <input class="interfaceButton" type="submit" name="bRentCar" value=" RENT A CAR "/><br/>
            <input class="interfaceButton" type="submit" name="bRentals" value="MY RENTALS"/><br/>
            <input class="interfaceButton" type="submit" name="bProfile" value=" MY PROFILE "/><br/>
            <input class="interfaceButton" type="submit" name="bAbout"   value="     ABOUT     "/><br/>
            <input class="interfaceButton" type="submit" name="bLogout"  value="   LOG OUT   "/>
        </div>
        <footer>Copyright &copy 2018 Ionescu Radu Stefan. All rights reserved.</footer>
    </body>
</html>