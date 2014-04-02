/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sara
 */
@Entity
@Table(name = "entreprise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entreprise.findAll", query = "SELECT e FROM Entreprise e"),
    @NamedQuery(name = "Entreprise.findById", query = "SELECT e FROM Entreprise e WHERE e.id = :id"),
    @NamedQuery(name = "Entreprise.findByNom", query = "SELECT e FROM Entreprise e WHERE e.nom = :nom"),
    @NamedQuery(name = "Entreprise.findBySigle", query = "SELECT e FROM Entreprise e WHERE e.sigle = :sigle"),
    @NamedQuery(name = "Entreprise.findByLogo", query = "SELECT e FROM Entreprise e WHERE e.logo = :logo"),
    @NamedQuery(name = "Entreprise.findByDateCreation", query = "SELECT e FROM Entreprise e WHERE e.dateCreation = :dateCreation"),
    @NamedQuery(name = "Entreprise.findByPays", query = "SELECT e FROM Entreprise e WHERE e.pays = :pays"),
    @NamedQuery(name = "Entreprise.findBySiege", query = "SELECT e FROM Entreprise e WHERE e.siege = :siege")})
public class Entreprise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "sigle")
    private String sigle;
    @Size(max = 254)
    @Column(name = "logo")
    private String logo;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Size(max = 254)
    @Column(name = "pays")
    private String pays;
    @Size(max = 254)
    @Column(name = "siege")
    private String siege;
    @ManyToOne
    private Responsable responsable =new Responsable();

    public Entreprise() {
    }

    public Entreprise(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getSiege() {
        return siege;
    }

    public void setSiege(String siege) {
        this.siege = siege;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entreprise)) {
            return false;
        }
        Entreprise other = (Entreprise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Entreprise[ id=" + id + " ]";
    }
    
}
