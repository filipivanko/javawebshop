package Servleti;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlacanjeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        izvrsiPlacanje(request, response);
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

    private void izvrsiPlacanje(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<String, String> sdkConfig = new HashMap<String, String>();
            sdkConfig.put("mode", "sandbox");
            String accessToken
                    = new OAuthTokenCredential(
                            "AUsk1X8pAbBiFtAkmSOBFpkJPLgMsHoLVavAVPWEiIQHxYq022zk_y-pfgtfeY3NAKheHi4NUgoIE0at",
                            "EGniB73jbu2D-Burh0lWUNLrT6re-FE0xsboIdM4wGaHTvYCh2XzxxQPJVe75MnkhDjbTY5KrLxGPTQH",
                            sdkConfig)
                    .getAccessToken();

            request.getSession().setAttribute("accessToken", accessToken);

            APIContext apiContext = new APIContext(accessToken);
            apiContext.setConfigurationMap(sdkConfig);

            Amount amount = new Amount();
            amount.setCurrency("USD");
            Float ukupnaCijena = (Float) request.getSession().getAttribute("ukupnaCijena");
          
            String cijenaString = String.format("%.2f", ukupnaCijena);
            amount.setTotal(cijenaString);

            Transaction transaction = new Transaction();
            transaction.setDescription("creating a payment");
            transaction.setAmount(amount);

            List<Transaction> transactions = new ArrayList<Transaction>();
            transactions.add(transaction);

            Payer payer = new Payer();
            payer.setPaymentMethod("paypal");

            Payment payment = new Payment();
            payment.setIntent("sale");
            payment.setPayer(payer);
            payment.setTransactions(transactions);
            RedirectUrls redirectUrls = new RedirectUrls();
            redirectUrls.setCancelUrl("http://javawebshop-filipivanko.rhcloud.com/greska.jsp");
            redirectUrls.setReturnUrl("http://javawebshop-filipivanko.rhcloud.com/PotvrdiKupnjuServlet");
            payment.setRedirectUrls(redirectUrls);

            Payment createdPayment = payment.create(apiContext);
            String approvalUrl = null;

            for (Links l : createdPayment.getLinks()) {
                if (l.getRel().equals("approval_url")) {
                    approvalUrl = l.getHref();
                    break;
                }
            }
            response.sendRedirect(approvalUrl);
        } catch (PayPalRESTException ex) {
            Logger.getLogger(PlacanjeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PlacanjeServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();

        }
    }
}
