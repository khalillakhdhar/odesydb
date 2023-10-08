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
@Table(name = "enfants", catalog = "agro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfants.findAll", query = "SELECT e FROM Enfants e"),
    @NamedQuery(name = "Enfants.findById", query = "SELECT e FROM Enfants e WHERE e.id = :id"),
    @NamedQuery(name = "Enfants.findByA", query = "SELECT e FROM Enfants e WHERE e.a = :a"),
    @NamedQuery(name = "Enfants.findByMoins6", query = "SELECT e FROM Enfants e WHERE e.moins6 = :moins6"),
    @NamedQuery(name = "Enfants.findByA1", query = "SELECT e FROM Enfants e WHERE e.a1 = :a1"),
    @NamedQuery(name = "Enfants.findByBesoinSpecifique", query = "SELECT e FROM Enfants e WHERE e.besoinSpecifique = :besoinSpecifique")})
public class Enfants implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "6_18")
    private int a;
    @Basic(optional = false)
    @Column(name = "moins_6")
    private int moins6;
    @Basic(optional = false)
    @Column(name = "18_40")
    private int a1;
    @Basic(optional = false)
    @Column(name = "besoin_specifique")
    private int besoinSpecifique;
    @JoinColumn(name = "id_personne", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personne idPersonne;

    public Enfants() {
    }

    public Enfants(Integer id) {
        this.id = id;
    }

    public Enfants(Integer id, int a, int moins6, int a1, int besoinSpecifique) {
        this.id = id;
        this.a = a;
        this.moins6 = moins6;
        this.a1 = a1;
        this.besoinSpecifique = besoinSpecifique;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getMoins6() {
        return moins6;
    }

    public void setMoins6(int moins6) {
        this.moins6 = moins6;
    }

    public int getA1() {
        return a1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public int getBesoinSpecifique() {
        return besoinSpecifique;
    }

    public void setBesoinSpecifique(int besoinSpecifique) {
        this.besoinSpecifique = besoinSpecifique;
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
        if (!(object instanceof Enfants)) {
            return false;
        }
        Enfants other = (Enfants) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codes.Enfants[ id=" + id + " ]";
    }
    
}
