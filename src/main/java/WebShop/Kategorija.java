
package WebShop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kategorija implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKategorija;
    
    private String naziv;
    private String slikaPutanja;
    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Proizvod> proizvodi = new ArrayList<Proizvod>();

    public Kategorija(String naziv,String slikaPutanja) {
        this.naziv = naziv;
        this.slikaPutanja = slikaPutanja;
    }
 
    public Kategorija(){
    }

    /**
     * @return the idKategorija
     */
    public Integer getIdKategorija() {
        return idKategorija;
    }

    /**
     * @param idKategorija the idKategorija to set
     */
    public void setIdKategorija(Integer idKategorija) {
        this.idKategorija = idKategorija;
    }

    /**
     * @return the naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * @param naziv the naziv to set
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * @return the proizvodi
     */
    public Collection<Proizvod> getProizvodi() {
        return proizvodi;
    }

    /**
     * @param proizvodi the proizvodi to set
     */
    public void setProizvodi(Collection<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }

    /**
     * @return the slikaPutanja
     */
    public String getSlikaPutanja() {
        return slikaPutanja;
    }

    /**
     * @param slikaPutanja the slikaPutanja to set
     */
    public void setSlikaPutanja(String slikaPutanja) {
        this.slikaPutanja = slikaPutanja;
    }
}
