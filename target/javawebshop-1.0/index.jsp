<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/webshop.css"/>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="ws" uri="WEB-INF/tlds/webShop_tagovi.tld" %>
        <title>Web Shop</title>
    </head>
    <body>
        <div id="mainDiv">

            <ws:HeaderTag/>

            <div id="lijeviDiv">
                <div> <h3> O nama</h3><br/></div>
                <div> Lorem ipsum dolor sit amet, 
                    ne quaeque facilisi antiopam per,
                    duo mutat hendrerit persecuti ne.
                    Alienum posidonium neglegentur
                    ex vis, cu has tritani conceptam.
                    Etiam verear qui cu. Sonet mollis
                    apeirian an vix.
                    At prima vivendum dissentiet per,
                    nominavi mandamus recteque sea eu.
                    Duo id munere postea aperiam, aliquip 
                    pertinax imperdiet qui et. Cu vim decore vivendum signiferumque,
                    ad est graecis torquatos. At corpora nostrum principes usu, 
                    ex duo alienum tincidunt concludaturque. Ea quo primis vituperata interesset,
                    ne erat saperet est.
                </div>
            </div>
            <div id="srednjiDiv">  
                <div><big>Kategorije</big></div>

                <c:forEach items="${sessionScope.listaKategorija}" var="kategorija">
                    <a href="<c:url value="KategorijaServlet"> <c:param name="kategorijaProizvoda" value="${kategorija.naziv}"/></c:url>">
                            <div class="divKategorija"> 
                                <img class="slikaKategorije" src="<c:url value="${kategorija.slikaPutanja}"/>" />
                        </div>
                    </a>
                </c:forEach>
            </div>
            <div id="desniDiv">

                <c:forEach items="${sessionScope.istaknutiProizvodi}" var="i" >   
                    <a href="<c:url value="ProizvodServlet"><c:param name="IDizabraniProizvod" value="${i.idProizvod}"/></c:url>">
                            <div class="izdvojeniProizvod">
                                <div class="divSlikaIzdvojenogProizvoda">
                                    <img src="<c:url value="${i.slikaPutanja}"/>" class="slikaIzdvojenogProizvoda"/>
                                </div>
                                <div class="tesktIzdvojenogProizvoda">
                                    <c:out value="${i.naziv}"/> <br/>
                                     Cijena:<c:out value="${i.cijena}"/> $
                                </div>

                            </div> 
                        </a>

                </c:forEach>  
            </div> 

            <ws:FooterTag/>
        </div>
    </body>
</html>
