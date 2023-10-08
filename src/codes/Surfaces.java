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
@Table(name = "surfaces", catalog = "agro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Surfaces.findAll", query = "SELECT s FROM Surfaces s"),
    @NamedQuery(name = "Surfaces.findByPreri", query = "SELECT s FROM Surfaces s WHERE s.preri = :preri"),
    @NamedQuery(name = "Surfaces.findByArbre", query = "SELECT s FROM Surfaces s WHERE s.arbre = :arbre"),
    @NamedQuery(name = "Surfaces.findByPleuvial", query = "SELECT s FROM Surfaces s WHERE s.pleuvial = :pleuvial"),
    @NamedQuery(name = "Surfaces.findByIrrigu\u00e9", query = "SELECT s FROM Surfaces s WHERE s.irrigu\u00e9 = :irrigu\u00e9"),
    @NamedQuery(name = "Surfaces.findById", query = "SELECT s FROM Surfaces s WHERE s.id = :id")})
public class Surfaces implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "preri")
    private int preri;
    @Basic(optional = false)
    @Column(name = "arbre")
    private int arbre;
    @Basic(optional = false)
    @Column(name = "pleuvial")
    private int pleuvial;
    @Basic(optional = false)
    @Column(name = "irrigu\u00e9")
    private int irrigué;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personne idUser;

    public Surfaces() {
    }

    public Surfaces(Integer id) {
        this.id = id;
    }

    public Surfaces(Integer id, int preri, int arbre, int pleuvial, int irrigué) {
        this.id = id;
        this.preri = preri;
        this.arbre = arbre;
        this.pleuvial = pleuvial;
        this.irrigué = irrigué;
    }

    public int getPreri() {
        return preri;
    }

    public void setPreri(int preri) {
        this.preri = preri;
    }

    public int getArbre() {
        return arbre;
    }

    public void setArbre(int arbre) {
        this.arbre = arbre;
    }

    public int getPleuvial() {
        return pleuvial;
    }

    public void setPleuvial(int pleuvial) {
        this.pleuvial = pleuvial;
    }

    public int getIrrigué() {
        return irrigué;
    }

    public void setIrrigué(int irrigué) {
        this.irrigué = irrigué;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Personne getIdUser() {
        return idUser;
    }

    public void setIdUser(Personne idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof Surfaces)) {
            return false;
        }
        Surfaces other = (Surfaces) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codes.Surfaces[ id=" + id + " ]";
    }
    
}
