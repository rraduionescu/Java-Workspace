<%-- @author Ionescu Radu
     @date 28.11.2021       --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Invoice Upload</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-CONTENT/view/styles/style.css"/>
    </head>
    <script>
        document.getElementById("in_up").onchange = setFileName;
        function setFileName()
        {
            document.getElementById("label_up").innerHTML = document.getElementById("in_up").files[0].name
        }
    </script>
    <body>
        <div id="logo">
            <a href="home">
                <img alt="LOGO" src="${pageContext.request.contextPath}/WEB-CONTENT/view/images/logo.png" id="logo_image">
            </a>
        </div>
        <h3>
            UPLOAD INVOICE
        </h3>
        <div class="pdf_upload_form">
            <form action="invoice_upload" method="post" enctype="multipart/form-data">
                <label class="wong" id="label_up">
                    <input id="in_up" type="file" name="upload" accept="application/pdf">Choose file...
                </label><br>
                <input type="submit" value="Upload" class="wong">
            </form>
        </div>
    </body>
</html>
<%--document.getElementById('label_up').innerText=document.getElementById('in_up').files[0].name--%>