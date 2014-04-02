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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "poste")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poste.findAll", query = "SELECT p FROM Poste p"),
    @NamedQuery(name = "Poste.findById", query = "SELECT p FROM Poste p WHERE p.id = :id"),
    @NamedQuery(name = "Poste.findByEmpid", query = "SELECT p FROM Poste p WHERE p.empid = :empid"),
    @NamedQuery(name = "Poste.findByLibelle", query = "SELECT p FROM Poste p WHERE p.libelle = :libelle"),
    @NamedQuery(name = "Poste.findByEstOccupe", query = "SELECT p FROM Poste p WHERE p.estOccupe = :estOccupe"),
    @NamedQuery(name = "Poste.findBySalaire", query = "SELECT p FROM Poste p WHERE p.salaire = :salaire"),
    @NamedQuery(name = "Poste.findByHeurParJour", query = "SELECT p FROM Poste p WHERE p.heurParJour = :heurParJour")})
public class Poste implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "Emp_id")
    private Integer empid;
    @Size(max = 254)
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "estOccupe")
    private Boolean estOccupe;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salaire")
    private Float salaire;
    @Size(max = 254)
    @Column(name = "heurParJour")
    private String heurParJour;
    @OneToMany
    private List<Employe> employeList;
    @JoinColumn(name = "Com_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Competence competence=new Competence();
    @JoinColumn(name = "Ser_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Service service=new Service();

    public Poste() {
    }

    public Poste(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Boolean getEstOccupe() {
        return estOccupe;
    }

    public void setEstOccupe(Boolean estOccupe) {
        this.estOccupe = estOccupe;
    }

    public Float getSalaire() {
        return salaire;
    }

    public void setSalaire(Float salaire) {
        this.salaire = salaire;
    }

    public String getHeurParJour() {
        return heurParJour;
    }

    public void setHeurParJour(String heurParJour) {
        this.heurParJour = heurParJour;
    }

    @XmlTransient
    public List<Employe> getEmployeList() {
        return employeList;
    }

    public void setEmployeList(List<Employe> employeList) {
        this.employeList = employeList;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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
        if (!(object instanceof Poste)) {
            return false;
        }
        Poste other = (Poste) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return libelle;
    }
    
}
