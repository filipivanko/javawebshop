/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Filip
 */
public class Repozitorij {

    SessionFactory sessionFactory;
    Session hibernateSession;

    public <T> List<T> dohvatiObjektePoNazivuKlase(String nazivObjekta, HttpServletRequest request) {
        Query query;

        otvoriHibernateSession();

        List<T> sviObjekti = new ArrayList<T>();
        query = hibernateSession.createQuery("from " + nazivObjekta);
        sviObjekti = query.list();
        HttpSession httpSession = request.getSession();

        zatvoriHibernateSession();
        return sviObjekti;
    }

    public <T> void spremiObjekt(T objekt) {
        otvoriHibernateSession();
        hibernateSession.save(objekt);
        zatvoriHibernateSession();

    }

    public Korisnik dohvatiKorisnikaPoKorisnickomImenu(String korisnickoIme) {
        Query query;
        otvoriHibernateSession();
        query = hibernateSession.createQuery("from Korisnik as K where K.korisnickoIme = '" + korisnickoIme + "'");
        Korisnik postojeciKorisnik = (Korisnik) query.list().get(0);
        zatvoriHibernateSession();
        return postojeciKorisnik;
    }

    public Proizvod dohvatiProizvodPoIDu(String id) {
        Query query;
        otvoriHibernateSession();
        query = hibernateSession.createQuery("from Proizvod as P where P.idProizvod = " + id);
        Proizvod proizvod = (Proizvod) query.list().get(0);
        zatvoriHibernateSession();
        return proizvod;
    }

    private void otvoriHibernateSession() {
        String dbHost = System.getenv("OPENSHIFT_POSTGRESQL_DB_HOST");
        String dbPort = System.getenv("OPENSHIFT_POSTGRESQL_DB_PORT");

        Configuration configuration = new Configuration().configure();

        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://" + dbHost + ":" + dbPort + "/javawebshop")
                .setProperty("hibernate.connection.username", "admindzb63m2")
                .setProperty("hibernate.connection.password", "hPGJBG-Me6Ap")
                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("hibernate.cache.provider_class", "org.hibernate.cache.internal.NoCacheProvider")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.connection.pool_size", "5");

        sessionFactory = configuration.buildSessionFactory();
        hibernateSession = sessionFactory.openSession();
        hibernateSession.beginTransaction();
    }

    private void zatvoriHibernateSession() {
        hibernateSession.getTransaction().commit();
        hibernateSession.flush();
        hibernateSession.close();
    }

    public boolean postojiKorisnik(String korisnickoIme) {
        Query query;
        otvoriHibernateSession();
        query = hibernateSession.createQuery("from Korisnik as K where K.korisnickoIme = '" + korisnickoIme + "'");
        List<Korisnik> rezultat = query.list();
        zatvoriHibernateSession();
        if (rezultat.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public List<Kategorija> dohvatiSveKategorije() {
        List<Kategorija> kategorije;

        Query query;
        otvoriHibernateSession();
        query = hibernateSession.createQuery("from Kategorija");
        kategorije = query.list();
        return kategorije;

    }

    public void dropajSveTablicaUBazi() {
        try {
            String dbHost = System.getenv("OPENSHIFT_POSTGRESQL_DB_HOST");
            String dbPort = System.getenv("OPENSHIFT_POSTGRESQL_DB_PORT");

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://" + dbHost + ":" + dbPort + "/javawebshop", "admindzb63m2", "hPGJBG-Me6Ap");

            Statement st = con.createStatement();

            st.execute("drop table if exists Kategorija_Proizvod");
            st.execute("drop table if exists Korisnik_Narudzba");
            st.execute("drop table if exists Narudzba_Stavka");
            st.execute("drop table if exists Stavka");
            st.execute("drop table if exists Narudzba");
            st.execute("drop table if exists Proizvod");
            st.execute("drop table if exists Kategorija");
            st.execute("drop table if exists Klijent");
            st.execute("drop table if exists Korisnik");

            st.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Repozitorij.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Repozitorij.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void napuniBazu() {
try{
        Configuration configuration = new Configuration().configure();

        otvoriHibernateSession();

        Korisnik korisnik1 = new Korisnik("korisnik1", "korisnik1", "korisnik1", "korisnik1", "korisnik1", "korisnik1");
        Korisnik korisnik2 = new Korisnik("korisnik2", "korisnik2", "korisnik2", "korisnik2", "korisnik2", "korisnik2");
        Korisnik korisnik3 = new Korisnik("korisnik3", "korisnik3", "korisnik3", "korisnik3", "korisnik3", "korisnik3");

        Korisnik admin = new Korisnik("admin", "admin", "admin", "admin", "admin", "admin");

        hibernateSession.save(korisnik1);
        hibernateSession.save(korisnik2);
        hibernateSession.save(korisnik3);
        hibernateSession.save(admin);

        Kategorija svijetlaPiva = new Kategorija("SvijetlaPiva", "Assets/svijetlo3.jpg");
        Kategorija tamnaPiva = new Kategorija("TamnaPiva", "Assets/tamno4.jpg");
        Kategorija sastojci = new Kategorija("Sastojci", "Assets/sastojci2.jpg");
        Kategorija oprema = new Kategorija("Oprema", "Assets/oprema2.jpg");

        Proizvod svijetlo1 = new Proizvod("Svijetlo1", "Assets/svijetlo3.jpg", 20.55f, "Lagano svijetlo pivo", svijetlaPiva);
        Proizvod svijetlo2 = new Proizvod("Svijetlo2", "Assets/svijetlo.jpg", 11.54f, "Lagano svijetlo pivo", svijetlaPiva);
        Proizvod svijetlo3 = new Proizvod("Svijetlo3", "Assets/svijetlo2.jpg", 33.32f, "Lagano svijetlo pivo", svijetlaPiva);

        hibernateSession.save(svijetlo1);
        hibernateSession.save(svijetlo2);
        hibernateSession.save(svijetlo3);

        svijetlaPiva.getProizvodi().addAll(Arrays.asList(svijetlo1, svijetlo2, svijetlo3));
        hibernateSession.save(svijetlaPiva);

        Proizvod tamno1 = new Proizvod("Tamno1", "Assets/tamno.jpg", 21.52f, "Lagano Tamno pivo", tamnaPiva);
        Proizvod tamno2 = new Proizvod("Tamno2", "Assets/tamno2.jpg", 32.25f, "Lagano Tamno pivo", tamnaPiva);
        Proizvod tamno3 = new Proizvod("Tamno3", "Assets/tamno3.png", 55.30f, "Lagano Tamno pivo", tamnaPiva);

        hibernateSession.save(tamno1);
        hibernateSession.save(tamno2);
        hibernateSession.save(tamno3);
        tamnaPiva.getProizvodi().addAll(Arrays.asList(tamno1, tamno2, tamno3));
        hibernateSession.save(tamnaPiva);

        Proizvod sastojak1 = new Proizvod("Sastojak1", "Assets/sastojci.jpg", 102.56f, "Najvažniji Sastojak", sastojci);
        Proizvod sastojak2 = new Proizvod("Sastojak2", "Assets/sastojci2.jpg", 84.75f, "Najvažniji Sastojak", sastojci);
        Proizvod sastojak3 = new Proizvod("Sastojak3", "Assets/sastojci3.jpg", 526.58f, "Najvažniji Sastojak", sastojci);

        hibernateSession.save(sastojak1);
        hibernateSession.save(sastojak2);
        hibernateSession.save(sastojak3);

        sastojci.getProizvodi().addAll(Arrays.asList(sastojak1, sastojak2, sastojak3));
        hibernateSession.save(sastojci);

        Proizvod dioPivarskeOpreme1 = new Proizvod("Oprema1", "Assets/oprema.jpg", 1254.05f, "Ključni dio Opreme", oprema);
        Proizvod dioPivarskeOpreme2 = new Proizvod("Oprema2", "Assets/oprema2.jpg", 1254.20f, "Ključni dio Opreme", oprema);
        Proizvod dioPivarskeOpreme3 = new Proizvod("Oprema3", "Assets/oprema3.png", 1254.11f, "Ključni dio Opreme", oprema);

        hibernateSession.save(dioPivarskeOpreme1);
        hibernateSession.save(dioPivarskeOpreme2);
        hibernateSession.save(dioPivarskeOpreme3);

        oprema.getProizvodi().addAll(Arrays.asList(dioPivarskeOpreme1, dioPivarskeOpreme2, dioPivarskeOpreme3));
        hibernateSession.save(oprema);

        zatvoriHibernateSession();
}catch(Exception ex){
ex.printStackTrace();
}

    }

}
