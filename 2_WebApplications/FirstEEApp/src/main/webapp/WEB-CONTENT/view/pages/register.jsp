<%-- @author Ionescu Radu
     @date 28.11.2021       --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-CONTENT/view/styles/style.css"/>
    </head>
    <body>
        <div id="logo">
            <a href="home">
                <img alt="LOGO" src="${pageContext.request.contextPath}/WEB-CONTENT/view/images/logo.png" id="logo_image">
            </a>
        </div>
        <div class="registration_form">
            <form action="register" method="post" style="display: inline-block">
                <input name="r_fn" type="text" class="wong" placeholder="First Name"><br>
                <input name="r_ln" type="text" class="wong" placeholder="Last Name"><br>
                <input name="r_em" type="email" class="wong" placeholder="Email"><br>
                <input name="r_pw" type="password" class="wong" placeholder="Password"><br>
                <input name="r_rp" type="password" class="wong" placeholder="Retype Password"><br>
                <input type="submit" class="wong" value="Register">
            </form>
        </div>
    </body>
</html>