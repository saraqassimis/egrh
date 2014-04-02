/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sara
 */
@Entity
@Table(name = "session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Session.findAll", query = "SELECT s FROM Session s"),
    @NamedQuery(name = "Session.findById", query = "SELECT s FROM Session s WHERE s.id = :id"),
    @NamedQuery(name = "Session.findByPlaid", query = "SELECT s FROM Session s WHERE s.plaid = :plaid"),
    @NamedQuery(name = "Session.findByForid", query = "SELECT s FROM Session s WHERE s.forid = :forid"),
    @NamedQuery(name = "Session.findByDateDebut", query = "SELECT s FROM Session s WHERE s.dateDebut = :dateDebut")})
public class Session implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Pla_id")
    private int plaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "For_id")
    private int forid;
    @Column(name = "dateDebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
  
    @ManyToOne
    private Besoinformation besoinformation =new Besoinformation();

    public Session() {
    }

    public Session(Integer id) {
        this.id = id;
    }

    public Session(Integer id, int plaid, int forid) {
        this.id = id;
        this.plaid = plaid;
        this.forid = forid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPlaid() {
        return plaid;
    }

    public void setPlaid(int plaid) {
        this.plaid = plaid;
    }

    public int getForid() {
        return forid;
    }

    public void setForid(int forid) {
        this.forid = forid;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Besoinformation getBesoinformation() {
        return besoinformation;
    }

    public void setBesoinformation(Besoinformation besoinformation) {
        this.besoinformation = besoinformation;
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
        if (!(object instanceof Session)) {
            return false;
        }
        Session other = (Session) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Session[ id=" + id + " ]";
    }
    
}
