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
@Table(name = "p\u00e2turages", catalog = "agro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "P\u00e2turages.findAll", query = "SELECT p FROM P\u00e2turages p"),
    @NamedQuery(name = "P\u00e2turages.findById", query = "SELECT p FROM P\u00e2turages p WHERE p.id = :id"),
    @NamedQuery(name = "P\u00e2turages.findByNom", query = "SELECT p FROM P\u00e2turages p WHERE p.nom = :nom"),
    @NamedQuery(name = "P\u00e2turages.findByDuree", query = "SELECT p FROM P\u00e2turages p WHERE p.duree = :duree")})
public class Pâturages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "duree")
    private int duree;
    @JoinColumn(name = "id_personne", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personne idPersonne;

    public Pâturages() {
    }

    public Pâturages(Integer id) {
        this.id = id;
    }

    public Pâturages(Integer id, String nom, int duree) {
        this.id = id;
        this.nom = nom;
        this.duree = duree;
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

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
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
        if (!(object instanceof Pâturages)) {
            return false;
        }
        Pâturages other = (Pâturages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codes.P\u00e2turages[ id=" + id + " ]";
    }
    
}
