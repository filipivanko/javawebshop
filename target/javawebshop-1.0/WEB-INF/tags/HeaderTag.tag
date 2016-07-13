<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="HeaderTag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="loginBarr">  

    <form action="AutentifikacijskiServlet" method="post">
        <c:if test="${empty sessionScope.korisnik}">
            <div id="greska">
                <c:if test="${not empty sessionScope.autentifikacijskaGreska}">
                    <c:out value="${sessionScope.autentifikacijskaGreska}"/>
                    <c:remove var="autentifikacijskaGreska" scope="session" />
                </c:if>
            </div>
            <div id="elementiForme">
                Username:<input type="text" name="korisnickoIme" class="sitnaSlova"/>
                Password:<input type="password" name="zaporka" class="sitnaSlova"/> 
                <input type="submit" value="Prijavi se" class="sitnaSlova"/> &nbsp;
                <a href="uclaniSe.jsp">Učlani Se</a>
            </div>
        </c:if>
        <c:if test="${not empty sessionScope.korisnik}">
            <div id="korisnidkiPodatci">
                <span id="pozdravnaPoruka">Korisnik: &nbsp; <c:out value="${sessionScope.korisnik.ime}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
                 <a href="PredledKupnjiServlet"> Predled kupnji</a>&nbsp;&nbsp;&nbsp; <a href="OdjavaServlet"> Odjavi se</a>

            </div>


        </c:if>
    </form>
</div>
<div id="header">   
    <a href="IndexServlet">
        <img src="Assets/logo.png" id="logoSlika" alt="web shop"/>
    </a>
    <a href="kosarica.jsp">
        <div id ="kosarica">

            <div>
                <br/>
                Košarica
                <hr/>
            </div>
            <div>
                Komada<br/>
                <c:out value="${sessionScope.ukupnaKolicina}" default="0"/><br/><br/>
                Iznos:<br/>
      
                    <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2"> <c:out value="${sessionScope.ukupnaCijena}"/> </fmt:formatNumber>
       
            </div>
        </div>        </a>

</div>