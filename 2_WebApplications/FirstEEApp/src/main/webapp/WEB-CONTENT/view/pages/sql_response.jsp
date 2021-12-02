<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: IonescuRadu
  Date: 28.11.2021
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>SQL Response</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-CONTENT/view/styles/style.css"/>
    </head>
    <body>
        <div id="logo">
            <a href="home">
                <img src="${pageContext.request.contextPath}/WEB-CONTENT/view/images/logo.png" id="logo_image">
            </a>
        </div>
        <%
            if(request.getAttribute("sqlResponse") != null)
            { %>
                <p> <%=request.getAttribute("sqlResponse")%> </p>
        <%  }
            else
        {
            ArrayList<String> sqlResponse = (ArrayList)request.getAttribute("sqlList");
            for(String item : sqlResponse)
            {%>
                <p> <%=item%> </p>
            <%}
        }%>
        <form action="sql" method="get" id="sql_back_Button">
            <input type="submit" value="Back">
        </form>
    </body>
</html>
