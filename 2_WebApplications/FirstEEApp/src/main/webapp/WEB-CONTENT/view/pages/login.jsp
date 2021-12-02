<%--
  Created by IntelliJ IDEA.
  User: IonescuRadu
  Date: 28.11.2021
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-CONTENT/view/styles/style.css"/>
        <script>
            document.getElementById('login').onclick = changeColor;
            function changeColor()
            {
                document.getElementById('gif').style.display = "inline-block";
                return false;
            }
        </script>
    </head>
    <body>
        <div id="logo">
            <a href="home">
                <img src="${pageContext.request.contextPath}/WEB-CONTENT/view/images/logo.png" id="logo_image">
            </a>
        </div>
        <div class="lform">
            <form action="login" method="post" style="display: inline-block">
                <input name="l_em" type="email" class="wong" placeholder="Email"><br>
                <input name="l_pw" type="password" class="wong" placeholder="Password"><br>
                <input type="submit" class="wong" value="Log in" id="login"><br>
                <img src="${pageContext.request.contextPath}/WEB-CONTENT/view/images/loading.gif" id="gif" style="display: none">
            </form>
        </div>
    </body>
</html>
