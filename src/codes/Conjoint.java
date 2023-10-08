/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author khali
 */
@Entity
@Table(name = "conjoint", catalog = "agro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conjoint.findAll", query = "SELECT c FROM Conjoint c"),
    @NamedQuery(name = "Conjoint.findById", query = "SELECT c FROM Conjoint c WHERE c.id = :id"),
    @NamedQuery(name = "Conjoint.findByCompetances", query = "SELECT c FROM Conjoint c WHERE c.competances = :competances"),
    @NamedQuery(name = "Conjoint.findByActivite", query = "SELECT c FROM Conjoint c WHERE c.activite = :activite"),
    @NamedQuery(name = "Conjoint.findBySexe", query = "SELECT c FROM Conjoint c WHERE c.sexe = :sexe"),
    @NamedQuery(name = "Conjoint.findByNaissance", query = "SELECT c FROM Conjoint c WHERE c.naissance = :naissance")})
public class Conjoint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "competances")
    private int competances;
    @Basic(optional = false)
    @Column(name = "activite")
    private int activite;
    @Basic(optional = false)
    @Column(name = "sexe")
    private int sexe;
    @Basic(optional = false)
    @Column(name = "naissance")
    private int naissance;
    @JoinColumn(name = "id_personne", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personne idPersonne;

    public Conjoint() {
    }

    public Conjoint(Integer id) {
        this.id = id;
    }

    public Conjoint(Integer id, int competances, int activite, int sexe, int naissance) {
        this.id = id;
        this.competances = competances;
        this.activite = activite;
        this.sexe = sexe;
        this.naissance = naissance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCompetances() {
        return competances;
    }

    public void setCompetances(int competances) {
        this.competances = competances;
    }

    public int getActivite() {
        return activite;
    }

    public void setActivite(int activite) {
        this.activite = activite;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public int getNaissance() {
        return naissance;
    }

    public void setNaissance(int naissance) {
        this.naissance = naissance;
    }

    public Personne getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personne idPersonne) {
        this.idPersonne = idPersonne;
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
        if (!(object instanceof Conjoint)) {
            return false;
        }
        Conjoint other = (Conjoint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codes.Conjoint[ id=" + id + " ]";
    }
    
}
