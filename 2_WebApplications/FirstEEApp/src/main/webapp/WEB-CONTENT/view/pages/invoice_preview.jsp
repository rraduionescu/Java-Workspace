<%-- @author Ionescu Radu
     @date 28.11.2021       --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Invoice Preview</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-CONTENT/view/styles/style.css"/>
    </head>
    <body>
        <div id="logo">
            <a href="home">
                <img alt="LOGO" src="${pageContext.request.contextPath}/WEB-CONTENT/view/images/logo.png" id="logo_image">
            </a>
        </div>
        <h3>
            PREVIEW INVOICE
        </h3>
        <div style="text-align: center;">
            <form action="nir" method="get">
                <embed src="${pageContext.request.contextPath}/WEB-CONTENT/invoices/<%=request.getAttribute("file")%>" width="800px" height="650px"/><br>
                <input type="hidden" name="file" value="<%=request.getAttribute("file")%>" /><br>
                <input type="submit" value="Confirm" class="wong" id="confirm">
            </form>
        </div>
    </body>
</html>