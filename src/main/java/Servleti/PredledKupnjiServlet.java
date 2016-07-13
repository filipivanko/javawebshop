package Servleti;

import WebShop.Korisnik;
import WebShop.Narudzba;
import WebShop.Repozitorij;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Filip
 */
public class PredledKupnjiServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            Korisnik korisnik = (Korisnik) request.getSession().getAttribute("korisnik");
            Repozitorij repo = new Repozitorij();
            List <Narudzba> listaNarudzbi;
            listaNarudzbi = repo.dohvatiObjektePoNazivuKlase("Narudzba", request);
            
            if(korisnik.getUloga().equals("admin")){
                request.getSession().setAttribute("listaNarudzbi", listaNarudzbi);
            }
            else{
                
                List <Narudzba>  listaNarudzbiKupca = new ArrayList();
                for (Narudzba narudzba:listaNarudzbi) {
                    if (korisnik.getIDKlijent() == narudzba.getKlijent().getIDKlijent()) {
                        listaNarudzbiKupca.add(narudzba);
                    }
                }
                
                request.getSession().setAttribute("listaNarudzbi", listaNarudzbiKupca);
            }
            response.sendRedirect("narudzbe.jsp");
        } catch (IOException ex) {
            Logger.getLogger(PredledKupnjiServlet.class.getName()).log(Level.SEVERE, null, ex);
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
