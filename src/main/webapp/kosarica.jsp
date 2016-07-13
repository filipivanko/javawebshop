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
                    <c:if test="${not empty sessionScope.kosarica}"> 
                        <form action="PromjenaKolicineServlet" method="post">  
                            <table class="tablicaZaPrikazKosarice">
                                <tr>
                                    <th>
                                        Naziv
                                    </th>
                                    <th>
                                        Cijena
                                    </th>
                                    <th>
                                        Količina
                                    </th>
                                    <th>
                                        Iznos
                                    </th>
                                    <th>
                                        Pobriši
                                    </th>
                                </tr>
                                <c:forEach items="${sessionScope.kosarica}" var="stavka">
                                    <tr>
                                        <td>
                                            <c:out value="${stavka.value.proizvod.naziv}"/>
                                        </td>
                                        <td>
                                            <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2">  <c:out value="${stavka.value.proizvod.cijena}"/></fmt:formatNumber>
                                            </td>
                                            <td>
                                                <input onchange="this.form.submit()" type="number" min ="0" max="100" name="${stavka.value.proizvod.naziv}" value="${stavka.value.kolicina}"/>

                                        </td>
                                        <td>

                                            <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2">   <c:out value="${stavka.value.ukupniIznos}"/> </fmt:formatNumber> $
                                            </td> 
                                            <td>
                                                <a href="<c:url value="pobrisiStavkuServlet"><c:param name="stavka" value="${stavka.key}"/></c:url>">
                                                    pobriši 
                                                </a>
                                            </td> 
                                        </tr>
                                </c:forEach> 
                                <tr>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                    <td>
                                        <b> Ukupni iznos:</b>  

                                    </td>
                                    <td>

                                        <b>  
                                            <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2">   <c:out value="${sessionScope.ukupnaCijena}"/></fmt:formatNumber> $
                                            </b>

                                        </td> 
                                        <td>

                                        </td> 
                                    </tr>
                                </table>
                            </form>     
                                            <form method="get" action="zavrsiKupnju.jsp">
                                                <input type="submit" value="Završite Kupovinu"/>
                                            </form>
                    </c:if>


                    <c:if test="${empty sessionScope.kosarica}">
                        <h2>Nemate ni jedan proizvod u košarici</h2>
                        <form method="get" action="IndexServlet">
                            <input type="submit" value="Povratak na naslovnu"/>
                        </form> 
                    </c:if>


                </div>

            </div>
           <ws:FooterTag/>
        </div>
    </body>
</html>
