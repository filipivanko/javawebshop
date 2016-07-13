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
  
            <div id="dvijeTrecineLijevi">
                <div id="dvijeTrecinePodloga">
                    <div id="SignUpForma">
                        <form action="UpisniServlet" method="post">
                            <table>

                                <tr>
                                    <td id="privaCelija">Ime:</td>
                                    <td id="drugaCelija"><input type="text" name="ime"/></td>    
                                </tr>

                                <tr>
                                    <td id="privaCelija">
                                        Prezime:
                                    </td>
                                    <td id="drugaCelija">
                                        <input type="text" name="prezime"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td id="privaCelija">
                                        Email:
                                    </td>
                                    <td id="drugaCelija">
                                        <input type="text" name="email"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td id="privaCelija">
                                        Korisničko Ime:
                                    </td>
                                    <td  id="drugaCelija">
                                        <input type="text" name="korisnickoIme"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td id="privaCelija">
                                        Zaporka:
                                    </td>
                                    <td  id="drugaCelija">
                                        <input type="password" name="zaporka"/>
                                    </td>
                                </tr>
                                
                                     <tr>
                                    <td id="privaCelija">
                                        Ponovi Zaporku:
                                    </td>
                                    <td  id="drugaCelija">
                                        <input type="password" name="ponovljinaZaporka"/>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td colspan="2"><input type="submit" value="Učlani se"/></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                      <div id="greska">
                    <c:if test="${not empty sessionScope.upisGreska }">
                        <c:out value="${sessionScope.upisGreska}"/>
                        <c:remove var="upisGreska" scope="session" />
                    </c:if>
                </div>
                </div>             
            </div>

            <div id="jednaTrecinaDesni">
                <img id="uclaniSeSlika" src="Assets/uclani.jpg"/>
            </div>
            <ws:FooterTag/>
        </div>
    </body>
</html>
