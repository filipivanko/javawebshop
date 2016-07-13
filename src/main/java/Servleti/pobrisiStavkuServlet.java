
package Servleti;

import WebShop.Proizvod;
import WebShop.Stavka;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class pobrisiStavkuServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String stavkaKljuc = request.getParameter("stavka");
        HashMap<String,Stavka> kosarica = (HashMap<String,Stavka>)request.getSession().getAttribute("kosarica");
        kosarica.remove(stavkaKljuc);
        request.setAttribute("kosarica", kosarica);
        dodajukupnuCijenuIKolicinuUSession(kosarica, request);
        response.sendRedirect("kosarica.jsp");
    }
    private void dodajukupnuCijenuIKolicinuUSession(HashMap<String, Stavka> kosarica, HttpServletRequest request) {
        Integer ukupnaKolicina = 0;
        float ukupnaCijena = 0f;
        for (String proizvod : kosarica.keySet()) {
            ukupnaKolicina += kosarica.get(proizvod).getKolicina();
            ukupnaCijena += kosarica.get(proizvod).getProizvod().getCijena() * ukupnaKolicina;
        }
        request.getSession().setAttribute("ukupnaCijena", ukupnaCijena);
        request.getSession().setAttribute("ukupnaKolicina", ukupnaKolicina);
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
