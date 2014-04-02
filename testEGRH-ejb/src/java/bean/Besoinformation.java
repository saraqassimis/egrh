/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sara
 */
@Entity
@Table(name = "besoinformation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Besoinformation.findAll", query = "SELECT b FROM Besoinformation b"),
    @NamedQuery(name = "Besoinformation.findById", query = "SELECT b FROM Besoinformation b WHERE b.id = :id"),
    @NamedQuery(name = "Besoinformation.findByLibelle", query = "SELECT b FROM Besoinformation b WHERE b.libelle = :libelle"),
    @NamedQuery(name = "Besoinformation.findByCompetenceADevelloppe", query = "SELECT b FROM Besoinformation b WHERE b.competenceADevelloppe = :competenceADevelloppe"),
    @NamedQuery(name = "Besoinformation.findByResultatsAttendus", query = "SELECT b FROM Besoinformation b WHERE b.resultatsAttendus = :resultatsAttendus"),
    @NamedQuery(name = "Besoinformation.findByCommentaire", query = "SELECT b FROM Besoinformation b WHERE b.commentaire = :commentaire")})
public class Besoinformation implements Serializable {
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
    @Size(max = 254)
    @Column(name = "competenceADevelloppe")
    private String competenceADevelloppe;
    @Size(max = 254)
    @Column(name = "resultatsAttendus")
    private String resultatsAttendus;
    private String commentaire;
    @JoinColumn(name = "employe", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employe employe =new Employe();
    @OneToMany
    private List<Session> sessions;
 
    public Besoinformation() {
    }

    public Besoinformation(Integer id) {
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

    public String getCompetenceADevelloppe() {
        return competenceADevelloppe;
    }

    public void setCompetenceADevelloppe(String competenceADevelloppe) {
        this.competenceADevelloppe = competenceADevelloppe;
    }

    public String getResultatsAttendus() {
        return resultatsAttendus;
    }

    public void setResultatsAttendus(String resultatsAttendus) {
        this.resultatsAttendus = resultatsAttendus;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

 

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
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
        if (!(object instanceof Besoinformation)) {
            return false;
        }
        Besoinformation other = (Besoinformation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return libelle+""+id;
    }
    
}
