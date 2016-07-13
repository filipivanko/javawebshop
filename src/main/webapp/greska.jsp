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
            <div id="prikazSadrzajaKosarice">
                <h1>Dogodila se greška pri plaćanju<br/> Molimo vas pokušajte ponovo</h1>
                <form method="get" action="KosaricaServlet">
                    <input type="submit" value="Povratak na košaricu"/>
                </form>    

            </div>
            <ws:FooterTag/>
        </div>
    </body>
</html>
