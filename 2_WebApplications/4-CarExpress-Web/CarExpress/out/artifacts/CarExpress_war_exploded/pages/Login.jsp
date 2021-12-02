<%@ page contentType="text/html;charset=UTF-8" %>

<%-- Created by Ionescu Radu Stefan --%>

<html lang="en">
    <head>
        <title>CarExpress - Log in</title>
        <link href="../styles/Style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="title">
            CarExpress
            <input class="languageIcon" type="image" src="../icons/iEN.png" align="right">
            <input class="languageIcon" type="image" src="../icons/iRO.png" align="right">
        </div>
        <div id="loginForm">
            <form action="../pages/Menu.jsp" method="post">
                <input class="textBox"         type="text"     name="tbUsername" placeholder="Email"/><br/>
                <input class="textBox"         type="password" name="tbPassword" placeholder="Password"/><br/>
                <input class="interfaceButton" type="submit"   name="bLogin"     value="                 LOG IN                   "/>
            </form>
            <form action="../pages/Register.jsp" method="post">
                <input class="interfaceButton" type="submit" value="               REGISTER                ">
            </form>
            <form action="../pages/Facebook.jsp" method="post">
                <input id="facebookButton" type="submit" value="     LOG IN WITH FACEBOOK ">
            </form>
            <form action="../pages/Google.jsp" method="post">
                <input id="googleButton" type="submit" value="       LOG IN WITH GOOGLE   ">
            </form>
        </div>
        <img src="../icons/iFB.png" id="facebookIcon">
        <img src="../icons/iGG.png" id="googleIcon">
        <footer>Copyright &copy 2018 Ionescu Radu Stefan. All rights reserved.</footer>
    </body>
</html>