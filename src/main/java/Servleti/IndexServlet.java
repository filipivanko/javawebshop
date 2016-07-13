package Servleti;

import WebShop.Kategorija;
import WebShop.Proizvod;
import WebShop.Repozitorij;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        
        Repozitorij repo = new Repozitorij();
     // repo.dropajSveTablicaUBazi();
     // repo.napuniBazu();
        
        List<Proizvod> sviProizvodi = new ArrayList<Proizvod>();
        ArrayList<Proizvod> istaknutiProizvodi = new ArrayList<Proizvod>();

        sviProizvodi = repo.dohvatiObjektePoNazivuKlase("Proizvod", request);

        if (sviProizvodi.size() >= 5) {
            napuniListuIstaknutihProizvodaIzBaze(istaknutiProizvodi, sviProizvodi);

        } else {
            napuniListIstaknutihProizvodaPraznimVrijednostima(istaknutiProizvodi);

        }

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("istaknutiProizvodi", istaknutiProizvodi);
        napuniKategroije(repo, request);

        response.sendRedirect("index.jsp");

    }

    private void napuniKategroije(Repozitorij repo, HttpServletRequest request) {
        List<Kategorija> kategorije = repo.dohvatiSveKategorije();
        request.getSession().setAttribute("listaKategorija", kategorije);

    }

    private void napuniListuIstaknutihProizvodaIzBaze(ArrayList<Proizvod> istaknutiProizvodi, List<Proizvod> sviProizvodi) {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            istaknutiProizvodi.add(sviProizvodi.get(rand.nextInt(sviProizvodi.size())));
        }
    }

    private void napuniListIstaknutihProizvodaPraznimVrijednostima(ArrayList<Proizvod> istaknutiProizvodi) {
        istaknutiProizvodi.addAll(Arrays.asList(new Proizvod("Nepostojeći proizvod", "Assets/nemaSlike.jpg", 0, "nema proizvoda u bazi", new Kategorija("Nema Kategorije", "Assets/nemaSlike.jpg")),
                new Proizvod("Nepostojeći proizvod", "Assets/nemaSlike.jpg", 0, "nema proizvoda u bazi", new Kategorija("Nema Kategorije", "Assets/nemaSlike.jpg")),
                new Proizvod("Nepostojeći proizvod", "Assets/nemaSlike.jpg", 0, "nema proizvoda u bazi", new Kategorija("Nema Kategorije", "Assets/nemaSlike.jpg")),
                new Proizvod("Nepostojeći proizvod", "Assets/nemaSlike.jpg", 0, "nema proizvoda u bazi", new Kategorija("Nema Kategorije", "Assets/nemaSlike.jpg")),
                new Proizvod("Nepostojeći proizvod", "Assets/nemaSlike.jpg", 0, "nema proizvoda u bazi", new Kategorija("Nema Kategorije", "Assets/nemaSlike.jpg"))
        ));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
