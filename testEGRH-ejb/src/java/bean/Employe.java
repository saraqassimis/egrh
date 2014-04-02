/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sara
 */
@Entity
@Table(name = "employe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employe.findAll", query = "SELECT e FROM Employe e"),
    @NamedQuery(name = "Employe.findById", query = "SELECT e FROM Employe e WHERE e.id = :id"),
    @NamedQuery(name = "Employe.findByNom", query = "SELECT e FROM Employe e WHERE e.nom = :nom"),
    @NamedQuery(name = "Employe.findByPrenom", query = "SELECT e FROM Employe e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Employe.findByTelephonePro", query = "SELECT e FROM Employe e WHERE e.telephonePro = :telephonePro"),
    @NamedQuery(name = "Employe.findByTelephoneMobile", query = "SELECT e FROM Employe e WHERE e.telephoneMobile = :telephoneMobile"),
    @NamedQuery(name = "Employe.findByTelephonePerso", query = "SELECT e FROM Employe e WHERE e.telephonePerso = :telephonePerso"),
    @NamedQuery(name = "Employe.findByFax", query = "SELECT e FROM Employe e WHERE e.fax = :fax"),
    @NamedQuery(name = "Employe.findByDateNaissance", query = "SELECT e FROM Employe e WHERE e.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Employe.findByEmail", query = "SELECT e FROM Employe e WHERE e.email = :email"),
    @NamedQuery(name = "Employe.findByAdrRue", query = "SELECT e FROM Employe e WHERE e.adrRue = :adrRue"),
    @NamedQuery(name = "Employe.findByAdrVille", query = "SELECT e FROM Employe e WHERE e.adrVille = :adrVille"),
    @NamedQuery(name = "Employe.findByDescription", query = "SELECT e FROM Employe e WHERE e.description = :description"),
    @NamedQuery(name = "Employe.findByNbEnfants", query = "SELECT e FROM Employe e WHERE e.nbEnfants = :nbEnfants"),
    @NamedQuery(name = "Employe.findByDateEntreeFonction", query = "SELECT e FROM Employe e WHERE e.dateEntreeFonction = :dateEntreeFonction"),
    @NamedQuery(name = "Employe.findByCivilite", query = "SELECT e FROM Employe e WHERE e.civilite = :civilite"),
    @NamedQuery(name = "Employe.findByNumeroAssuranceSociale", query = "SELECT e FROM Employe e WHERE e.numeroAssuranceSociale = :numeroAssuranceSociale"),
    @NamedQuery(name = "Employe.findByDateEmbauche", query = "SELECT e FROM Employe e WHERE e.dateEmbauche = :dateEmbauche"),
    @NamedQuery(name = "Employe.findByDateDepart", query = "SELECT e FROM Employe e WHERE e.dateDepart = :dateDepart")})
public class Employe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
   @Column(name = "id")
    private Integer id;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 254)
    @Column(name = "telephonePro")
    private String telephonePro;
    @Size(max = 254)
    @Column(name = "telephoneMobile")
    private String telephoneMobile;
    @Size(max = 254)
    @Column(name = "telephonePerso")
    private String telephonePerso;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "fax")
    private String fax;
    @Column(name = "dateNaissance")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "email")
    private String email;
    @Size(max = 254)
    @Column(name = "adrRue")
    private String adrRue;
    @Size(max = 254)
    @Column(name = "adrVille")
    private String adrVille;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @Column(name = "nbEnfants")
    private Integer nbEnfants;
    @Column(name = "dateEntreeFonction")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEntreeFonction;
    @Size(max = 254)
    @Column(name = "civilite")
    private String civilite;
    @Size(max = 254)
    @Column(name = "numeroAssuranceSociale")
    private String numeroAssuranceSociale;
    @Column(name = "dateEmbauche")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEmbauche;
    @Column(name = "dateDepart")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDepart;
    private boolean etat_inscription_formation;
    @OneToMany
    private List<Evalueremploye> evalueremployeList = new ArrayList<Evalueremploye>();
    @JoinColumn(name = "Poste_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Poste poste;
    @OneToMany
    private List<Besoinformation> besoinformationList = new ArrayList<Besoinformation>();
    @OneToMany
    private List<Diplome> diplomeList =new ArrayList <Diplome>();
    @OneToMany
    private List<Emploiprecedent> emploiprecedentList =new ArrayList <Emploiprecedent>();

    public Employe() {
    }

    public Employe(Integer id) {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephonePro() {
        return telephonePro;
    }

    public void setTelephonePro(String telephonePro) {
        this.telephonePro = telephonePro;
    }

    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    public void setTelephoneMobile(String telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
    }

    public String getTelephonePerso() {
        return telephonePerso;
    }

    public void setTelephonePerso(String telephonePerso) {
        this.telephonePerso = telephonePerso;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdrRue() {
        return adrRue;
    }

    public void setAdrRue(String adrRue) {
        this.adrRue = adrRue;
    }


    public String getAdrVille() {
        return adrVille;
    }

    public void setAdrVille(String adrVille) {
        this.adrVille = adrVille;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNbEnfants() {
        return nbEnfants;
    }

    public void setNbEnfants(Integer nbEnfants) {
        this.nbEnfants = nbEnfants;
    }

    public Date getDateEntreeFonction() {
        return dateEntreeFonction;
    }

    public void setDateEntreeFonction(Date dateEntreeFonction) {
        this.dateEntreeFonction = dateEntreeFonction;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNumeroAssuranceSociale() {
        return numeroAssuranceSociale;
    }

    public void setNumeroAssuranceSociale(String numeroAssuranceSociale) {
        this.numeroAssuranceSociale = numeroAssuranceSociale;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    @XmlTransient
    public List<Evalueremploye> getEvalueremployeList() {
        return evalueremployeList;
    }

    public void setEvalueremployeList(List<Evalueremploye> evalueremployeList) {
        this.evalueremployeList = evalueremployeList;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

   

    @XmlTransient
    public List<Besoinformation> getBesoinformationList() {
        return besoinformationList;
    }

    public void setBesoinformationList(List<Besoinformation> besoinformationList) {
        this.besoinformationList = besoinformationList;
    }

    @XmlTransient
    public List<Diplome> getDiplomeList() {
        return diplomeList;
    }

    public void setDiplomeList(List<Diplome> diplomeList) {
        this.diplomeList = diplomeList;
    }

    @XmlTransient
    public List<Emploiprecedent> getEmploiprecedentList() {
        return emploiprecedentList;
    }

    public void setEmploiprecedentList(List<Emploiprecedent> emploiprecedentList) {
        this.emploiprecedentList = emploiprecedentList;
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
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom+" "+prenom;
    }
    
}
