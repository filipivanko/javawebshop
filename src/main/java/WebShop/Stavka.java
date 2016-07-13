
package WebShop;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Stavka implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IDStavka;
    private Integer kolicina;
    private float ukupniIznos;
    @ManyToOne
    private Proizvod proizvod;
    @ManyToOne
    private Narudzba narudzba;

    
    public Stavka(){}
    public Stavka( Integer kolicina, Proizvod proizvod) {
        this.kolicina = kolicina;
        this.ukupniIznos = kolicina*proizvod.getCijena();
        this.proizvod = proizvod;
    }


    public Integer getIDStavka() {
        return IDStavka;
    }

    public void setIDStavka(Integer IDStavka) {
        this.IDStavka = IDStavka;
    }

    /**
     * @return the kolicina
     */
    public Integer getKolicina() {
        return kolicina;
    }

    /**
     * @param kolicina the kolicina to set
     */
    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
        this.setUkupniIznos(kolicina * this.getProizvod().getCijena());
      
    }

    /**
     * @return the proizvod
     */
    public Proizvod getProizvod() {
        return proizvod;
    }

    /**
     * @param proizvod the proizvod to set
     */
    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    /**
     * @return the narudzba
     */
    public Narudzba getNarudzba() {
        return narudzba;
    }

    /**
     * @param narudzba the narudzba to set
     */
    public void setNarudzba(Narudzba narudzba) {
        this.narudzba = narudzba;
    }

    /**
     * @return the ukupniIznos
     */
    public float getUkupniIznos() {
        return ukupniIznos;
    }

    /**
     * @param ukupniIznos the ukupniIznos to set
     */
    public void setUkupniIznos(float ukupniIznos) {
        this.ukupniIznos = ukupniIznos;
    }

    /**
     * @return the ukupniIznos
     */
   
}
