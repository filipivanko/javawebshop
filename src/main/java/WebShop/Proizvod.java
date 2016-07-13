package WebShop;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Proizvod  implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer idProizvod;
    
    @Column (length = 50)
    private String naziv;
    
    private String slikaPutanja;
    private float cijena;
    private String opis;
    
    @ManyToOne
    private Kategorija kategorija;

    public Proizvod() {
    }

    public Proizvod( String naziv,String slikaPutanja, float cijena, String opis, Kategorija kategorija) {
        this.naziv = naziv;
        this.cijena = cijena;
        this.opis = opis;
        this.kategorija = kategorija;
        this.slikaPutanja = slikaPutanja;
    }

    
    

    public Integer getIdProizvod() {
        return idProizvod;
    }


    public void setIdProizvod(Integer idProizvod) {
        this.idProizvod = idProizvod;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }


    public float getCijena() {
        return cijena;
    }


    public void setCijena(float cijena) {
        this.cijena = cijena;
    }


    public String getOpis() {
        return opis;
    }


    public void setOpis(String opis) {
        this.opis = opis;
    }


    public Kategorija getKategorija() {
        return kategorija;
    }


    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
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
