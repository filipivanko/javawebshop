/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servleti;

import WebShop.Stavka;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Filip
 */
public class PromjenaKolicineServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HashMap<String,Stavka> kosarica = (HashMap<String,Stavka>)request.getSession().getAttribute("kosarica");
            
            for (String nazivProizvoda:kosarica.keySet()) {
                kosarica.get(nazivProizvoda).setKolicina(Integer.parseInt(request.getParameter(nazivProizvoda))); 
                if (kosarica.get(nazivProizvoda).getKolicina()==0) {
                    kosarica.remove(nazivProizvoda);
                }
        }
            dodajukupnuCijenuIKolicinuUSession(kosarica, request);
            if (kosarica.isEmpty()) {
            request.getSession().removeAttribute("kosarica");
        }
            response.sendRedirect("kosarica.jsp");
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
