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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sara
 */
@Entity
@Table(name = "emploiprecedent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emploiprecedent.findAll", query = "SELECT e FROM Emploiprecedent e"),
    @NamedQuery(name = "Emploiprecedent.findById", query = "SELECT e FROM Emploiprecedent e WHERE e.id = :id"),
    @NamedQuery(name = "Emploiprecedent.findByDateDebut", query = "SELECT e FROM Emploiprecedent e WHERE e.dateDebut = :dateDebut"),
    @NamedQuery(name = "Emploiprecedent.findByDateFin", query = "SELECT e FROM Emploiprecedent e WHERE e.dateFin = :dateFin"),
    @NamedQuery(name = "Emploiprecedent.findByEntreprise", query = "SELECT e FROM Emploiprecedent e WHERE e.entreprise = :entreprise"),
    @NamedQuery(name = "Emploiprecedent.findByPost", query = "SELECT e FROM Emploiprecedent e WHERE e.post = :post"),
    @NamedQuery(name = "Emploiprecedent.findByDescription", query = "SELECT e FROM Emploiprecedent e WHERE e.description = :description")})
public class Emploiprecedent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateDebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Column(name = "dateFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Column(name = "entreprise")
    private Character entreprise;
    @Column(name = "post")
    private Character post;
    @Column(name = "description")
    private Character description;
    @JoinColumn(name = "Employe", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employe employe=new Employe();
    @JoinColumn(name = "contrat", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Contrat contrat=new Contrat();
    

    public Emploiprecedent() {
    }

    public Emploiprecedent(Integer id) {
        this.id = id;
    }
  public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Character getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Character entreprise) {
        this.entreprise = entreprise;
    }

    public Character getPost() {
        return post;
    }

    public void setPost(Character post) {
        this.post = post;
    }

    public Character getDescription() {
        return description;
    }

    public void setDescription(Character description) {
        this.description = description;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }


    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
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
        if (!(object instanceof Emploiprecedent)) {
            return false;
        }
        Emploiprecedent other = (Emploiprecedent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Emploiprecedent[ id=" + id + " ]";
    }
    
}
