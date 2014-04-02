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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sara
 */
@Entity
@Table(name = "evalueremploye")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evalueremploye.findAll", query = "SELECT e FROM Evalueremploye e"),
    @NamedQuery(name = "Evalueremploye.findById", query = "SELECT e FROM Evalueremploye e WHERE e.id = :id"),
    @NamedQuery(name = "Evalueremploye.findByQualite", query = "SELECT e FROM Evalueremploye e WHERE e.qualite = :qualite"),
    @NamedQuery(name = "Evalueremploye.findByRythmeTravail", query = "SELECT e FROM Evalueremploye e WHERE e.rythmeTravail = :rythmeTravail"),
    @NamedQuery(name = "Evalueremploye.findByCapaciteAdaptation", query = "SELECT e FROM Evalueremploye e WHERE e.capaciteAdaptation = :capaciteAdaptation"),
    @NamedQuery(name = "Evalueremploye.findByDiscretionConfidentalite", query = "SELECT e FROM Evalueremploye e WHERE e.discretionConfidentalite = :discretionConfidentalite"),
    @NamedQuery(name = "Evalueremploye.findByEspritInitiativeInovation", query = "SELECT e FROM Evalueremploye e WHERE e.espritInitiativeInovation = :espritInitiativeInovation"),
    @NamedQuery(name = "Evalueremploye.findByMethodeOrde", query = "SELECT e FROM Evalueremploye e WHERE e.methodeOrde = :methodeOrde"),
    @NamedQuery(name = "Evalueremploye.findByPonctualite", query = "SELECT e FROM Evalueremploye e WHERE e.ponctualite = :ponctualite"),
    @NamedQuery(name = "Evalueremploye.findByRelationInterpersonnelle", query = "SELECT e FROM Evalueremploye e WHERE e.relationInterpersonnelle = :relationInterpersonnelle"),
    @NamedQuery(name = "Evalueremploye.findBySensResponsabilite", query = "SELECT e FROM Evalueremploye e WHERE e.sensResponsabilite = :sensResponsabilite"),
    @NamedQuery(name = "Evalueremploye.findByCommunication", query = "SELECT e FROM Evalueremploye e WHERE e.communication = :communication"),
    @NamedQuery(name = "Evalueremploye.findByDateEvaluation", query = "SELECT e FROM Evalueremploye e WHERE e.dateEvaluation = :dateEvaluation"),
    @NamedQuery(name = "Evalueremploye.findByCommentaire", query = "SELECT e FROM Evalueremploye e WHERE e.commentaire = :commentaire"),
    @NamedQuery(name = "Evalueremploye.findByNote", query = "SELECT e FROM Evalueremploye e WHERE e.note = :note")})
public class Evalueremploye implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 254)
    @Column(name = "qualite")
    private String qualite;
    @Size(max = 254)
    @Column(name = "rythmeTravail")
    private String rythmeTravail;
    @Size(max = 254)
    @Column(name = "capaciteAdaptation")
    private String capaciteAdaptation;
    @Size(max = 254)
    @Column(name = "discretionConfidentalite")
    private String discretionConfidentalite;
    @Size(max = 254)
    @Column(name = "espritInitiativeInovation")
    private String espritInitiativeInovation;
    @Size(max = 254)
    @Column(name = "methodeOrde")
    private String methodeOrde;
    @Size(max = 254)
    @Column(name = "ponctualite")
    private String ponctualite;
    @Size(max = 254)
    @Column(name = "relationInterpersonnelle")
    private String relationInterpersonnelle;
    @Size(max = 254)
    @Column(name = "sensResponsabilite")
    private String sensResponsabilite;
    @Size(max = 254)
    @Column(name = "communication")
    private String communication;
    @Column(name = "dateEvaluation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEvaluation;
    @Size(max = 254)
    @Column(name = "commentaire")
    private String commentaire;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "note")
    private Float note;
    @JoinColumn(name = "Employe_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employe empid;

    public Evalueremploye() {
    }

    public Evalueremploye(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQualite() {
        return qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public String getRythmeTravail() {
        return rythmeTravail;
    }

    public void setRythmeTravail(String rythmeTravail) {
        this.rythmeTravail = rythmeTravail;
    }

    public String getCapaciteAdaptation() {
        return capaciteAdaptation;
    }

    public void setCapaciteAdaptation(String capaciteAdaptation) {
        this.capaciteAdaptation = capaciteAdaptation;
    }

    public String getDiscretionConfidentalite() {
        return discretionConfidentalite;
    }

    public void setDiscretionConfidentalite(String discretionConfidentalite) {
        this.discretionConfidentalite = discretionConfidentalite;
    }

    public String getEspritInitiativeInovation() {
        return espritInitiativeInovation;
    }

    public void setEspritInitiativeInovation(String espritInitiativeInovation) {
        this.espritInitiativeInovation = espritInitiativeInovation;
    }

    public String getMethodeOrde() {
        return methodeOrde;
    }

    public void setMethodeOrde(String methodeOrde) {
        this.methodeOrde = methodeOrde;
    }

    public String getPonctualite() {
        return ponctualite;
    }

    public void setPonctualite(String ponctualite) {
        this.ponctualite = ponctualite;
    }

    public String getRelationInterpersonnelle() {
        return relationInterpersonnelle;
    }

    public void setRelationInterpersonnelle(String relationInterpersonnelle) {
        this.relationInterpersonnelle = relationInterpersonnelle;
    }

    public String getSensResponsabilite() {
        return sensResponsabilite;
    }

    public void setSensResponsabilite(String sensResponsabilite) {
        this.sensResponsabilite = sensResponsabilite;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public Date getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(Date dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public Employe getEmpid() {
        return empid;
    }

    public void setEmpid(Employe empid) {
        this.empid = empid;
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
        if (!(object instanceof Evalueremploye)) {
            return false;
        }
        Evalueremploye other = (Evalueremploye) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Evalueremploye[ id=" + id + " ]";
    }
    
}
