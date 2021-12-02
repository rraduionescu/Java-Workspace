<%@ page contentType="text/html;charset=UTF-8" %>

<%-- Created by Ionescu Radu Stefan --%>

<html>
    <head>
        <title>CarExpress - Register</title>
        <link href="../styles/Style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="title">
            CarExpress
            <input class="languageIcon" type="image" src="../icons/iEN.png" align="right">
            <input class="languageIcon" type="image" src="../icons/iRO.png" align="right">
        </div>
        <div id="registerForm">
            <form action="Login.jsp" method="post">
                <input class="profilePicture"  type="image"    name="ivProfile" src="../icons/iProfile.png"><br/>
                <input class="textBox"         type="text"     name="tbFirstName" placeholder="First name"/><br/>
                <input class="textBox"         type="text"     name="tbLastName" placeholder="Last name"/><br/>
                <input class="textBox"         type="text"     name="tbEmail" placeholder="Email"/><br/>
                <input class="textBox"         type="password" name="tbPassword" placeholder="Password"/><br/>
                <input class="textBox"         type="password" name="tbPasswordConfirmation" placeholder="Password confirmation"/><br/>
                <input class="interfaceButton" type="submit"   value="                REGISTER                "/>
            </form>
        </div>
        <footer>Copyright &copy 2018 Ionescu Radu Stefan. All rights reserved.</footer>
    </body>
</html>