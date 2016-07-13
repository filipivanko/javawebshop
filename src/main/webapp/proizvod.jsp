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
                    <h3>Lorem</h3> 
                    Lorem ipsum dolor sit amet, 
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
            <div id="dvijeTrecineDesni">
                <div id="proizvodSlika">
                    <img class="slikaProizvodaVelika" src="<c:url value="${sessionScope.proizvodZaPokazati.slikaPutanja}"></c:url>">
                </div>
                <div id="proizvodOpis">
                    <div id="tekstOpisaProizvoda">
                    Naziv: <c:out value="${sessionScope.proizvodZaPokazati.naziv}"/><br/>
                   Opis: <c:out value="${sessionScope.proizvodZaPokazati.opis}"/><br/>
                    Cijena: <c:out value="${sessionScope.proizvodZaPokazati.cijena}"/> $
                    </div>
                   
                </div>
                <div id="dodajUKosaricu">
                    <br/>
                    <form method="post" action="DodajUKosaricuServlet">
                        <table id="tablicaDodajUKosaricu">
                            <tr>
                                 <th>
                                   Naziv proizvoda
                                </th>
                                <th>
                                    Cijena
                                </th>
                                 <th>
                                     Količina
                                </th>                         
                                 <th>
                              
                                </th>
                            </tr>
                               
                            
                            <tr>
                                <td>
                                    <c:out value="${sessionScope.proizvodZaPokazati.naziv}"/>
                                </td>
                                <td>
                                    <c:out value="${sessionScope.proizvodZaPokazati.cijena}"/> $
                                </td>
                                 <td>
                                     <input type="number" min="0" max="100" name="dodanaKolicina" value="0"/>
                                </td>                         
                                 <td>
                                     <input type="submit" value="Dodaj u košaricu"/>
                                </td>
                            </tr>
                        </table>
                   
                    </form>
                </div>
            </div> 
            <ws:FooterTag/>
        </div>
    </body>
</html>