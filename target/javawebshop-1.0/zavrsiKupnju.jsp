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
                                            <c:out value="${stavka.value.kolicina}"/>

                                        </td>
                                        <td>

                                            <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2">   <c:out value="${stavka.value.ukupniIznos}"/> </fmt:formatNumber> $
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
                       
                                    </tr>
                                </table>
                            </form>     
                            <table class="tablicaZaPrikazKosarice">
                                <tr>
                                    <td>
                                        <form method="get" action="kosarica.jsp">
                                            <input type="submit" value="<< Povratak"/>
                                        </form> 
                                    </td>
                                    <td> </td>
                                    <td> </td>
                                    <td> </td>
                                    <td> </td>
                                    <td>
                                        <form method="get" action="PlacanjeServlet">
                                            <input type="submit" value="Plati PayPal-om >>"/>
                                        </form>    
                                    </td>

                                </tr>

                            </table>

                    </c:if>


                    <c:if test="${empty sessionScope.kosarica}">
                        <h2>Nemate ni jedan proizvod u košarici</h2>
                    </c:if>


                </div>

            </div>
           <ws:FooterTag/>
        </div>
    </body>
</html>
