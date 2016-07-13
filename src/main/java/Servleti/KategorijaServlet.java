package Servleti;

import WebShop.Proizvod;
import WebShop.Repozitorij;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class KategorijaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      List<Proizvod> proizvodiUKategoriji = new ArrayList<Proizvod>();
      List<Proizvod> sviProizvodi = new ArrayList<Proizvod>(){};
      
      
       Repozitorij repo =  new Repozitorij();
       sviProizvodi = repo.dohvatiObjektePoNazivuKlase("Proizvod", request);
      
         for(Proizvod p: sviProizvodi){
             if (p.getKategorija().getNaziv().equals(request.getParameter("kategorijaProizvoda"))) {
                 proizvodiUKategoriji.add(p);
             }
         }
       
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("proizvodiUKategoriji", proizvodiUKategoriji);

      response.sendRedirect("kategorija.jsp");
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
