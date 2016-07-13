package WebShop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Narudzba implements Serializable {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNarudzba;
    @ManyToOne
    private Korisnik klijent;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date vrijeme;
    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Stavka> naruceniProizvodi = new ArrayList<Stavka>();
    private Float iznosNarudžbe;

    public Narudzba() {
    }

    public Narudzba(Korisnik klijent, Date vrijeme, float iznosNarudžbe , Collection<Stavka> naruceniProizvod) {
        this.klijent = klijent;
        this.vrijeme = vrijeme;
        this.iznosNarudžbe = iznosNarudžbe;
    }

    /**
     * @return the idNarudzba
     */
    public Integer getIdNarudzba() {
        return idNarudzba;
    }

    /**
     * @param idNarudzba the idNarudzba to set
     */
    public void setIdNarudzba(Integer idNarudzba) {
        this.idNarudzba = idNarudzba;
    }

    /**
     * @return the klijent
     */
    public Korisnik getKlijent() {
        return klijent;
    }

    /**
     * @param klijent the klijent to set
     */
    public void setKlijent(Korisnik klijent) {
        this.klijent = klijent;
    }

    /**
     * @return the vrijeme
     */
    public Date getVrijeme() {
        return vrijeme;
    }

    /**
     * @param vrijeme the vrijeme to set
     */
    public void setVrijeme(Date vrijeme) {
        this.vrijeme = vrijeme;
    }

    /**
     * @return the naruceniProizvodi
     */
    public Collection<Stavka> getNaruceniProizvodi() {
        return naruceniProizvodi;
    }

    /**
     * @param naruceniProizvodi the naruceniProizvodi to set
     */
    public void setNaruceniProizvodi(Collection<Stavka> naruceniProizvodi) {
        this.naruceniProizvodi = naruceniProizvodi;
    }

    /**
     * @return the iznosNarudžbe
     */
    public float getIznosNarudžbe() {
        return iznosNarudžbe;
    }

    /**
     * @param iznosNarudžbe the iznosNarudžbe to set
     */
    public void setIznosNarudžbe(float iznosNarudžbe) {
        this.iznosNarudžbe = iznosNarudžbe;
    }
    
    
    
    
}
