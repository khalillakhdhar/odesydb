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
@Table(name = "logement", catalog = "agro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logement.findAll", query = "SELECT l FROM Logement l"),
    @NamedQuery(name = "Logement.findById", query = "SELECT l FROM Logement l WHERE l.id = :id"),
    @NamedQuery(name = "Logement.findByChambres", query = "SELECT l FROM Logement l WHERE l.chambres = :chambres"),
    @NamedQuery(name = "Logement.findByTraditionnel", query = "SELECT l FROM Logement l WHERE l.traditionnel = :traditionnel"),
    @NamedQuery(name = "Logement.findByCiment", query = "SELECT l FROM Logement l WHERE l.ciment = :ciment")})
public class Logement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "chambres")
    private int chambres;
    @Basic(optional = false)
    @Column(name = "traditionnel")
    private int traditionnel;
    @Basic(optional = false)
    @Column(name = "ciment")
    private int ciment;
    @JoinColumn(name = "id_personne", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personne idPersonne;

    public Logement() {
    }

    public Logement(Integer id) {
        this.id = id;
    }

    public Logement(Integer id, int chambres, int traditionnel, int ciment) {
        this.id = id;
        this.chambres = chambres;
        this.traditionnel = traditionnel;
        this.ciment = ciment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getChambres() {
        return chambres;
    }

    public void setChambres(int chambres) {
        this.chambres = chambres;
    }

    public int getTraditionnel() {
        return traditionnel;
    }

    public void setTraditionnel(int traditionnel) {
        this.traditionnel = traditionnel;
    }

    public int getCiment() {
        return ciment;
    }

    public void setCiment(int ciment) {
        this.ciment = ciment;
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
        if (!(object instanceof Logement)) {
            return false;
        }
        Logement other = (Logement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codes.Logement[ id=" + id + " ]";
    }
    
}
