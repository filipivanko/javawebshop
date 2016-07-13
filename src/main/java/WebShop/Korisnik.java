package WebShop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public  class Korisnik implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IDKlijent;
    private String ime;
    private String prezime;
    private String email;
    @Column(unique = true)
    private String korisnickoIme;
    private String zaporka;
    private String uloga;
    @OneToMany(fetch=FetchType.EAGER)
    private Collection<Narudzba> Narudzbe;

    public Korisnik() {
    }

    public Korisnik(String ime, String prezime, String email, String korisnickoIme, String Zaporka, String uloga) {
        this.IDKlijent = IDKlijent;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.korisnickoIme = korisnickoIme;
        this.zaporka = Zaporka;
        this.uloga = uloga;
        Narudzbe = new ArrayList<Narudzba>();
    }

    /**
     * @return the IDKlijent
     */
    public Integer getIDKlijent() {
        return IDKlijent;
    }

    /**
     * @param IDKlijent the IDKlijent to set
     */
    public void setIDKlijent(Integer IDKlijent) {
        this.IDKlijent = IDKlijent;
    }

    /**
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * @param ime the ime to set
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * @return the prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * @param prezime the prezime to set
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the korisnickoIme
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * @param korisnickoIme the korisnickoIme to set
     */
    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    /**
     * @return the zaporka
     */
    public String getZaporka() {
        return zaporka;
    }

    /**
     * @param Zaporka the zaporka to set
     */
    public void setZaporka(String Zaporka) {
        this.zaporka = Zaporka;
    }

    /**
     * @return the uloga
     */
    public String getUloga() {
        return uloga;
    }

    /**
     * @param uloga the uloga to set
     */
    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    /**
     * @return the Narudzbe
     */
    public Collection<Narudzba> getNarudzbe() {
        return Narudzbe;
    }

    /**
     * @param Narudzbe the Narudzbe to set
     */
    public void setNarudzbe(Collection<Narudzba> Narudzbe) {
        this.Narudzbe = Narudzbe;
    }


}