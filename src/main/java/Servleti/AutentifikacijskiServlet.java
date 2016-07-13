package Servleti;

import WebShop.Korisnik;
import WebShop.Repozitorij;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutentifikacijskiServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String korisnickoIme = request.getParameter("korisnickoIme");
        String zaporka = request.getParameter("zaporka");

        Repozitorij repo = new Repozitorij();
        String referer =  request.getHeader("Referer");
        if (repo.postojiKorisnik(korisnickoIme)) {
            Korisnik korisnik = repo.dohvatiKorisnikaPoKorisnickomImenu(korisnickoIme);
             
            if (korisnik.getZaporka().equals(zaporka)) {
                request.getSession().setAttribute("korisnik", korisnik);
             
                response.sendRedirect(referer);

            } else {
                request.getSession().setAttribute("autentifikacijskaGreska", "Kriva zaporka");
                response.sendRedirect(referer);
            }

        } else {

            request.getSession().setAttribute("autentifikacijskaGreska", "Ne postoji user");
            response.sendRedirect(referer);

        }

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
