/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sara
 */
@Entity
@Table(name = "formation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formation.findAll", query = "SELECT f FROM Formation f"),
    @NamedQuery(name = "Formation.findById", query = "SELECT f FROM Formation f WHERE f.id = :id"),
    @NamedQuery(name = "Formation.findByLibelle", query = "SELECT f FROM Formation f WHERE f.libelle = :libelle"),
    @NamedQuery(name = "Formation.findByPrixParPersonne", query = "SELECT f FROM Formation f WHERE f.prixParPersonne = :prixParPersonne"),
    @NamedQuery(name = "Formation.findByDuree", query = "SELECT f FROM Formation f WHERE f.duree = :duree"),
    @NamedQuery(name = "Formation.findByCategorie", query = "SELECT f FROM Formation f WHERE f.categorie = :categorie"),
    @NamedQuery(name = "Formation.findByNiveau", query = "SELECT f FROM Formation f WHERE f.niveau = :niveau"),
    @NamedQuery(name = "Formation.findByDescription", query = "SELECT f FROM Formation f WHERE f.description = :description")})
public class Formation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 254)
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "prixParPersonne")
    private Integer prixParPersonne;
    @Column(name = "duree")
    private Integer duree;
    @Size(max = 254)
    @Column(name = "categorie")
    private String categorie;
    @Column(name = "niveau")
    private Integer niveau;
    @Column(name = "description")
    private Integer description;
    @JoinColumn(name = "organisme", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Organisme organisme=new Organisme();
    @JoinColumn(name = "competence", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Competence competence=new Competence();

    public Formation() {
    }

    public Formation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getPrixParPersonne() {
        return prixParPersonne;
    }

    public void setPrixParPersonne(Integer prixParPersonne) {
        this.prixParPersonne = prixParPersonne;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public Integer getDescription() {
        return description;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    public Organisme getOrganisme() {
        return organisme;
    }

    public void setOrganisme(Organisme organisme) {
        this.organisme = organisme;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
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
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Formation[ id=" + id + " ]";
    }
    
}
