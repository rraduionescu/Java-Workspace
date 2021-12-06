<%-- @author Ionescu Radu
     @date 28.11.2021       --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<html>
    <head>
        <title>SQL Response</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-CONTENT/view/styles/style.css"/>
    </head>
    <body>
        <div id="logo">
            <a href="home">
                <img alt="LOGO" src="${pageContext.request.contextPath}/WEB-CONTENT/view/images/logo.png" id="logo_image">
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