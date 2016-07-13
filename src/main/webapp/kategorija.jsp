<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/webshop.css"/>
        <%@taglib prefix="ws" uri="WEB-INF/tlds/webShop_tagovi.tld" %>

        <title>Web Shop</title>
    </head>
    <body>
        <div id="mainDiv">
            <ws:HeaderTag/>


            <div id="jednaTrecinaLijevi">  
                <c:forEach items="${sessionScope.listaKategorija}" var="kategorija">
                    <a href="<c:url value="KategorijaServlet"> <c:param name="kategorijaProizvoda" value="${kategorija.naziv}"/></c:url>">            
                            <div class="ProizvodKategorije"> 

                                <img class="slikaKategorijeMala" src="<c:url value="${kategorija.slikaPutanja}"/>" />


                            <div class="opisKategorije">
                                <c:out value="${kategorija.naziv}"/>
                            </div>
                        </div>
                    </a>
                </c:forEach>

            </div>
            <div id="dvijeTrecineDesni">
                <c:forEach items="${sessionScope.proizvodiUKategoriji}" var="p">
                    <a href=<c:url value="ProizvodServlet"> <c:param name="IDizabraniProizvod" value="${p.idProizvod}"/>
                       </c:url>>

                        <div class="ProizvodUKategoriji">
                            <img class="slikaProizvodaMala" src="<c:url value="${p.slikaPutanja}"></c:url>">

                                <div class="opisProizvoda">
                                <c:out value="${p.naziv}" /> <br/>
                               Cijena: <c:out value="${p.cijena}" /> $ <br/>
                             Opis:<c:out value="${p.opis}" /> <br/>

                            </div> 
                        </div>

                    </a>

                </c:forEach>
            </div>



            <ws:FooterTag/>
        </div>
    </body>
</html>
