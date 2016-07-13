package Servleti;

import WebShop.Proizvod;
import WebShop.Stavka;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DodajUKosaricuServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HashMap<String, Stavka> kosarica;
        Stavka dadanaStavka;
        Proizvod dodaniProizvod;
        Integer dodanaKolicina;
        dodaniProizvod = (Proizvod) request.getSession().getAttribute("proizvodZaPokazati");
        dodanaKolicina = Integer.parseInt(request.getParameter("dodanaKolicina"));
       
        
        if (dodanaKolicina != 0) {
            if (!postojiKosarica(request)) {

                kosarica = new HashMap<String, Stavka>();

                kosarica.put(dodaniProizvod.getNaziv(), new Stavka(dodanaKolicina, dodaniProizvod));
                request.getSession().setAttribute("kosarica", kosarica);

                dodajukupnuCijenuIKolicinuUSession(kosarica, request);

            } else {
                kosarica = (HashMap<String, Stavka>) request.getSession().getAttribute("kosarica");

                if (kosarica.containsKey(dodaniProizvod.getNaziv())) {

                    Stavka stavkaKojaSePovecava = kosarica.get(dodaniProizvod.getNaziv());
                    stavkaKojaSePovecava.setKolicina(stavkaKojaSePovecava.getKolicina() + dodanaKolicina);
                    dodajukupnuCijenuIKolicinuUSession(kosarica, request);

                } else {
                    kosarica.put(dodaniProizvod.getNaziv(), new Stavka(dodanaKolicina, dodaniProizvod));
                    request.getSession().setAttribute("kosarica", kosarica);

                    dodajukupnuCijenuIKolicinuUSession(kosarica, request);
                }

            }
        }
        response.sendRedirect("index.jsp");
    }

    private static boolean postojiKosarica(HttpServletRequest request) {
        
        List<String> sessionAtributi = Collections.list(request.getSession().getAttributeNames());
        return sessionAtributi.contains("kosarica");
    }

    private void dodajukupnuCijenuIKolicinuUSession(HashMap<String, Stavka> kosarica, HttpServletRequest request) {
        Integer ukupnaKolicina = 0;
        Float ukupnaCijena = 0f;
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
