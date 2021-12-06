<%-- @author Ionescu Radu
     @date 28.11.2021       --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>SQL Statement</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-CONTENT/view/styles/style.css"/>
    </head>
    <body>
        <div id="logo">
            <a href="home">
                <img alt="LOGO" src="${pageContext.request.contextPath}/WEB-CONTENT/view/images/logo.png" id="logo_image">
            </a>
        </div>
        <div id="sql_div">
            <form id="sql_form" action="sql" method="post">
                <label for="statement">SQL Statement</label><br>
                <textarea rows="10" cols="100" id="statement" name="statement"></textarea><br>
                <input type="submit" value="Execute"/>
            </form>
        </div>
    </body>
</html>
<%--
CREATE TABLE user
(
id BIGINT(8) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(40) NOT NULL,
password VARCHAR(50) NOT NULL,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL
);
--%>