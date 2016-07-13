package Servleti;

import WebShop.Korisnik;
import WebShop.Repozitorij;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpisniServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String email = request.getParameter("email");
        String korisnickoIme = request.getParameter("korisnickoIme");
        String zaporka = request.getParameter("zaporka");
        String ponovjenaZaporka = request.getParameter("ponovljinaZaporka");
        Repozitorij repo = new Repozitorij();

        if (!repo.postojiKorisnik(korisnickoIme)) {
            if (!zaporka.equals(ponovjenaZaporka)) {
                request.getSession().setAttribute("upisGreska", "Zaporke nisu jednake!");
                response.sendRedirect("uclaniSe.jsp");

            } else {
                Korisnik noviKlijent = new Korisnik(ime, prezime, email, korisnickoIme, zaporka, "klijent");
                repo.spremiObjekt(noviKlijent);
                request.getSession().setAttribute("korisnik", noviKlijent);
                response.sendRedirect("IndexServlet");
            }

        } else {
            request.getSession().setAttribute("upisGreska", "Korisnicko ime je zauzeto");
            response.sendRedirect("uclaniSe.jsp");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
