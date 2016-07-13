<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/webshop.css"/>
        <%@taglib prefix="ws" uri="WEB-INF/tlds/webShop_tagovi.tld" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Web Shop</title>
    </head>
    <body>
        <div id="mainDiv">
            <ws:HeaderTag/>
            <div id="prikazSadrzajaKosarice">
                <h1>Hvala vam na kupnji</h1><br/>
                <c:out value="${sessionScope.cijenaSrring}"/> 
                
                <form method="get" action="IndexServlet">
                    <input type="submit" value="Povratak na naslovnu"/>
                </form>    

            </div>
            <ws:FooterTag/>
        </div>
    </body>
</html>
