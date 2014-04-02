/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sara
 */
@Entity
@Table(name = "organisme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organisme.findAll", query = "SELECT o FROM Organisme o"),
    @NamedQuery(name = "Organisme.findById", query = "SELECT o FROM Organisme o WHERE o.id = :id"),
    @NamedQuery(name = "Organisme.findByNom", query = "SELECT o FROM Organisme o WHERE o.nom = :nom"),
    @NamedQuery(name = "Organisme.findByDescription", query = "SELECT o FROM Organisme o WHERE o.description = :description"),
    @NamedQuery(name = "Organisme.findByLocalisation", query = "SELECT o FROM Organisme o WHERE o.localisation = :localisation")})
public class Organisme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "nom")
    private Character nom;
    @Column(name = "description")
    private Character description;
    @Size(max = 254)
    @Column(name = "localisation")
    private String localisation;
    @OneToMany
    private List<Formation> formationList;

    public Organisme() {
    }

    public Organisme(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getNom() {
        return nom;
    }

    public void setNom(Character nom) {
        this.nom = nom;
    }

    public Character getDescription() {
        return description;
    }

    public void setDescription(Character description) {
        this.description = description;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @XmlTransient
    public List<Formation> getFormationList() {
        return formationList;
    }

    public void setFormationList(List<Formation> formationList) {
        this.formationList = formationList;
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
        if (!(object instanceof Organisme)) {
            return false;
        }
        Organisme other = (Organisme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Organisme[ id=" + id + " ]";
    }
    
}
