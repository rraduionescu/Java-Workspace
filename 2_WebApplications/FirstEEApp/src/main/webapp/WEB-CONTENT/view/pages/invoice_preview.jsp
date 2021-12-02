<%--
  Created by IntelliJ IDEA.
  User: IonescuRadu
  Date: 29.11.2021
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Invoice Preview</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-CONTENT/view/styles/style.css"/>
        <script>
            document.getElementById('confirm').onclick = changeColor;
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
        <h3>
            PREVIEW INVOICE
        </h3>
        <div style="text-align: center;">
            <form action="nir" method="get">
                <embed src="${pageContext.request.contextPath}/WEB-CONTENT/invoices/<%=request.getAttribute("file")%>" width="800px" height="650px"/><br>
                <input type="hidden" name="file" value="<%=request.getAttribute("file")%>" /><br>
                <input type="submit" value="CONFIRM" class="wong" id="confirm"><br>
                <img src="${pageContext.request.contextPath}/WEB-CONTENT/view/images/loading.gif" id="gif" style="display: none">
            </form>
        </div>
    </body>
</html>