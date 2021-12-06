<%-- @author Ionescu Radu
     @date 28.11.2021       --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-CONTENT/view/styles/style.css"/>
    </head>
    <body>
        <div id="logo">
            <a href="home">
                <img alt="LOGO" src="${pageContext.request.contextPath}/WEB-CONTENT/view/images/logo.png" id="logo_image">
            </a>
        </div>
        <h1>
            NEW STOCK MANAGEMENT SYSTEM
        </h1>
        <div id="lr_buttons">
            <form action="login" method="get" style="display: inline-block">
                <input class="wong" type="submit" value="Log in">
            </form>
            <form action="register" method="get" style="display: inline-block">
                <input class="wong" type="submit" value="Register">
            </form>
        </div>
    </body>
</html>