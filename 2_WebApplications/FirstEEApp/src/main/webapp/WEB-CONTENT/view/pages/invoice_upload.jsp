<%--
  Created by IntelliJ IDEA.
  User: IonescuRadu
  Date: 28.11.2021
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Invoice Upload</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-CONTENT/view/styles/style.css"/>
    </head>
    <body>
        <div id="logo">
            <a href="home">
                <img src="${pageContext.request.contextPath}/WEB-CONTENT/view/images/logo.png" id="logo_image">
            </a>
        </div>
        <h3>
            UPLOAD INVOICE
        </h3>
        <div class="pdform">
            <form action="invoice_upload" method="post" enctype="multipart/form-data">
                <label class="wong">
                    <input id="in_up" type="file" name="upload" accept="application/pdf">CHOOSE FILE...
                </label><br>
                <input type="submit" value="UPLOAD" class="wong">
            </form>
        </div>
    </body>
</html>
