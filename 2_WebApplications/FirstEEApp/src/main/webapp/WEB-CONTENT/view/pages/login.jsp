<%-- @author Ionescu Radu
     @date 28.11.2021       --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-CONTENT/view/styles/style.css"/>
    </head>
    <body>
        <div id="logo">
            <a href="home">
                <img alt="LOGO" src="${pageContext.request.contextPath}/WEB-CONTENT/view/images/logo.png" id="logo_image">
            </a>
        </div>
        <div class="login_form">
            <form action="login" method="post" style="display: inline-block">
                <input name="l_em" type="email" class="wong" placeholder="Email"><br>
                <input name="l_pw" type="password" class="wong" placeholder="Password"><br>
                <input type="submit" class="wong" value="Log in" id="login">
            </form>
        </div>
    </body>
</html>