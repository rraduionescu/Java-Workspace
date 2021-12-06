<%-- @author Ionescu Radu
     @date 28.11.2021       --%>
<%@ page import="com.ionescu.radu.firsteeapp.model.classes.NBRRates" %>
<%@ page import="com.ionescu.radu.firsteeapp.model.classes.Product" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<html>
    <head>
        <title>NIR</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-CONTENT/view/styles/style.css"/>
    </head>
    <body>
        <div id="logo">
            <a href="home">
                <img alt="LOGO" src="${pageContext.request.contextPath}/WEB-CONTENT/view/images/logo.png" id="logo_image">
            </a>
        </div>
        <h3>
            NOTA INTRARE RECEPTIE
        </h3>
        <br>
            <table id="nir_table">
                <thead>
                    <tr>
                        <th>Nr. crt.</th>
                        <th>Denumirea bunurilor receptionate</th>
                        <th>Cod</th>
                        <th>U.M.</th>
                        <th>Cant.</th>
                        <th>Cant. conf. doc.</th>
                        <th>Pret unitar achizitie (fara TVA)</th>
                        <th>Valoare neta totala de intrare</th>
                        <th>TVA unitar achizitie</th>
                        <th>TVA total achizitie</th>
                        <th>Valoare totala achizitie</th>
                        <th>Adaos comercial (%)</th>
                        <th>Adaos comercial unitar</th>
                        <th>Pret net unitar vanzare cu adaos</th>
                        <th>Valoare TVA unitar la vanzare</th>
                        <th>Pret unitar de vanzare cu TVA</th>
                        <th>Total vanzare (fara TVA)</th>
                        <th>Total TVA la vanzare</th>
                        <th>Total vanzare cu TVA</th>
                        <th>Adaos comercial total</th>
                    </tr>
                    <tr style="text-align: center">
                        <td>0</td>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                        <td>5</td>
                        <td>6</td>
                        <td>7</td>
                        <td>8</td>
                        <td>9</td>
                        <td>10</td>
                        <td>11</td>
                        <td>12</td>
                        <td>13</td>
                        <td>14</td>
                        <td>15</td>
                        <td>16</td>
                        <td>17</td>
                        <td>18</td>
                        <td>19</td>
                    </tr>
                </thead>
                <tbody>
                    <%
                    ArrayList<Product> products = (ArrayList<Product>)request.getAttribute("products");
                    int i=1;
                    int productNumber = 0;
                    double totalPrice = 0;
                    for(Product product : products)
                    {%>
                    <tr>
                        <td><%=i%></td>
                        <td><%=product.get_1()%></td>
                        <td><%=product.get_2()%></td>
                        <td><%=product.get_3()%></td>
                        <td><%=product.get_4()%></td>
                        <td><%=product.get_5()%></td>
                        <td><%=product.get_6()%></td>
                        <td><%=product.get_7()%></td>
                        <td><%=product.get_8()%></td>
                        <td><%=product.get_9()%></td>
                        <td><%=product.get_10()%></td>
                        <td><%=product.get_11()%></td>
                        <td><%=product.get_12()%></td>
                        <td><%=product.get_13()%></td>
                        <td><%=product.get_14()%></td>
                        <td><%=product.get_15()%></td>
                        <td><%=product.get_16()%></td>
                        <td><%=product.get_17()%></td>
                        <td><%=product.get_18()%></td>
                        <td><%=product.get_19()%></td>
                    </tr>
                    <%
                    productNumber += Integer.parseInt(product.getQuantity());
                    totalPrice += Double.parseDouble(product.getPriceTotal());
                    i++;
                    }
                    String price = totalPrice + "0";
                    price = price.replaceAll("\\.", ",");
                    %>
                    <tr>
                        <td colspan="20">Total number of products: <%=productNumber%> Total price: <%=price%> EUR</td>
                    </tr>
                    <tr>
                        <td colspan="20">Date: <%=NBRRates.DATE%> Rate: EUR = <%=NBRRates.EUR_RATE%> RON </td>
                    </tr>
                </tbody>
            </table>
    </body>
</html>