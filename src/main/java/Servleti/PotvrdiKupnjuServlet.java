package Servleti;

import WebShop.Korisnik;
import WebShop.Narudzba;
import WebShop.Repozitorij;
import WebShop.Stavka;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PotvrdiKupnjuServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Random rand = new Random();
            Map<String, String> sdkConfig = new HashMap<String, String>();
            sdkConfig.put("mode", "sandbox");
            String accessToken = (String) request.getSession().getAttribute("accessToken");
            APIContext apiContext = new APIContext(accessToken);
            apiContext.setConfigurationMap(sdkConfig);

            Payment payment = new Payment();
            payment.setId(request.getParameter("paymentId"));
            PaymentExecution paymentExecute = new PaymentExecution();
            paymentExecute.setPayerId(request.getParameter("PayerID"));
            payment.execute(apiContext, paymentExecute);

            Repozitorij repo = new Repozitorij();
            Korisnik korisnik = (Korisnik) request.getSession().getAttribute("korisnik");
            Float iznos = (Float) request.getSession().getAttribute("ukupnaCijena");
            HashMap<String, Stavka> kosarica = (HashMap<String, Stavka>) request.getSession().getAttribute("kosarica");
            Collection<Stavka> naruceniProizvodi = new ArrayList<Stavka>();

            for (String proizvod : kosarica.keySet()) {
                naruceniProizvodi.add(kosarica.get(proizvod));
            }

            repo.spremiObjekt(new Narudzba(korisnik, new Date(), iznos, naruceniProizvodi));

            request.getSession().removeAttribute("kosarica");
            request.getSession().removeAttribute("ukupnaCijena");
            request.getSession().removeAttribute("ukupnaKolicina");

            response.sendRedirect("obavljenakupnja.jsp");
        } catch (PayPalRESTException ex) {
            Logger.getLogger(PotvrdiKupnjuServlet.class.getName()).log(Level.SEVERE, null, ex);
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
