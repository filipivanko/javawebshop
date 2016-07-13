<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/webshop.css"/>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="ws" uri="WEB-INF/tlds/webShop_tagovi.tld" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
        <title>Web Shop</title>
    </head>
    <body>
        <div id="mainDiv">
            <ws:HeaderTag/>
            <div id="prikazSadrzajaKosarice">
                <div id="TablecaKosarica">
                    <c:if test="${not empty sessionScope.listaNarudzbi}"> 

                        <table class="tablicaZaPrikazKosarice">
                            <tr>
                                <th>
                                    Korisnik
                                </th>
                                <th>
                                    Datum
                                </th>
                                <th>
                                    Iznos
                                </th>

                            </tr>
                            <c:forEach items="${sessionScope.listaNarudzbi}" var="narudzba">
                                <tr>
                                    <td>
                                        <c:out value="${narudzba.klijent.ime}"/>
                                    </td>
                                    <td>
                                        <c:out value="${narudzba.vrijeme}"/>
                                    </td>
                                    <td>
                                        <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2">   <c:out value="${narudzba.iznosNarudžbe}"/> </fmt:formatNumber> $

                                        </td>
                                    </tr>
                            </c:forEach> 
                        </table>
                        <form method="get" action="IndexServlet">
                            <input type="submit" value="Povratak na naslovnu"/>
                        </form> 


                    </c:if>


                    <c:if test="${empty sessionScope.listaNarudzbi}">
                        <h2>Nema Narudžbi</h2>
                    </c:if>


                </div>

            </div>
            <ws:FooterTag/>
        </div>
    </body>
</html>
