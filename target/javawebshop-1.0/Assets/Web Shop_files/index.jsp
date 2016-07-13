
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/webshop.css"/>
        
        
        <title>Web Shop</title>
    </head>
    <body>
        <div id="mainDiv">

            


  
<div id="loginBarr">  

    <form action="AutentifikacijskiServlet" method="post">
        
            <div id="greska">
                
            </div>
            <div id="elementiForme">
                Username:<input type="text" name="korisnickoIme" class="sitnaSlova"/>
                Password:<input type="password" name="zaporka" class="sitnaSlova"/> 
                <input type="submit" value="Prijavi se" class="sitnaSlova"/> &nbsp;
                <a href="uclaniSe.jsp">Učlani Se</a>
            </div>
        
        
    </form>
</div>
<div id="header">   
    <a href="IndexServlet">
        <img src="#" id="logoSlika" alt="web shop"/>
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
                0<br/><br/>
                Iznos:<br/>
      
                    
       
            </div>
        </div>        </a>

</div>

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

                
                    <a href="KategorijaServlet?kategorijaProizvoda=SvijetlaPiva">
                            <div class="divKategorija"> 
                                <img class="slikaKategorije" src="Assets/svijetlo3.jpg" />
                        </div>
                    </a>
                
                    <a href="KategorijaServlet?kategorijaProizvoda=TamnaPiva">
                            <div class="divKategorija"> 
                                <img class="slikaKategorije" src="Assets/tamno4.jpg" />
                        </div>
                    </a>
                
                    <a href="KategorijaServlet?kategorijaProizvoda=Sastojci">
                            <div class="divKategorija"> 
                                <img class="slikaKategorije" src="Assets/sastojci2.jpg" />
                        </div>
                    </a>
                
                    <a href="KategorijaServlet?kategorijaProizvoda=Oprema">
                            <div class="divKategorija"> 
                                <img class="slikaKategorije" src="Assets/oprema2.jpg" />
                        </div>
                    </a>
                
            </div>
            <div id="desniDiv">

                   
                    <a href="ProizvodServlet?IDizabraniProizvod=12">
                            <div class="izdvojeniProizvod">
                                <div class="divSlikaIzdvojenogProizvoda">
                                    <img src="Assets/sastojci3.jpg" class="slikaIzdvojenogProizvoda"/>
                                </div>
                                <div class="tesktIzdvojenogProizvoda">
                                    Sastojak3 <br/>
                                     Cijena:526.58 kn
                                </div>

                            </div> 
                        </a>

                   
                    <a href="ProizvodServlet?IDizabraniProizvod=7">
                            <div class="izdvojeniProizvod">
                                <div class="divSlikaIzdvojenogProizvoda">
                                    <img src="Assets/sastojci.jpg" class="slikaIzdvojenogProizvoda"/>
                                </div>
                                <div class="tesktIzdvojenogProizvoda">
                                    Oprema1 <br/>
                                     Cijena:1254.05 kn
                                </div>

                            </div> 
                        </a>

                   
                    <a href="ProizvodServlet?IDizabraniProizvod=10">
                            <div class="izdvojeniProizvod">
                                <div class="divSlikaIzdvojenogProizvoda">
                                    <img src="Assets/sastojci.jpg" class="slikaIzdvojenogProizvoda"/>
                                </div>
                                <div class="tesktIzdvojenogProizvoda">
                                    Sastojak1 <br/>
                                     Cijena:102.56 kn
                                </div>

                            </div> 
                        </a>

                   
                    <a href="ProizvodServlet?IDizabraniProizvod=3">
                            <div class="izdvojeniProizvod">
                                <div class="divSlikaIzdvojenogProizvoda">
                                    <img src="Assets/svijetlo2.jpg" class="slikaIzdvojenogProizvoda"/>
                                </div>
                                <div class="tesktIzdvojenogProizvoda">
                                    Svijetlo3 <br/>
                                     Cijena:33.32 kn
                                </div>

                            </div> 
                        </a>

                   
                    <a href="ProizvodServlet?IDizabraniProizvod=10">
                            <div class="izdvojeniProizvod">
                                <div class="divSlikaIzdvojenogProizvoda">
                                    <img src="Assets/sastojci.jpg" class="slikaIzdvojenogProizvoda"/>
                                </div>
                                <div class="tesktIzdvojenogProizvoda">
                                    Sastojak1 <br/>
                                     Cijena:102.56 kn
                                </div>

                            </div> 
                        </a>

                  
            </div> 

            <div id="Footer">
                footer
            </div>
        </div>
    </body>
</html>
