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
@Table(name = "troupeau", catalog = "agro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Troupeau.findAll", query = "SELECT t FROM Troupeau t"),
    @NamedQuery(name = "Troupeau.findByEquide", query = "SELECT t FROM Troupeau t WHERE t.equide = :equide"),
    @NamedQuery(name = "Troupeau.findByCoprins", query = "SELECT t FROM Troupeau t WHERE t.coprins = :coprins"),
    @NamedQuery(name = "Troupeau.findByOvins", query = "SELECT t FROM Troupeau t WHERE t.ovins = :ovins"),
    @NamedQuery(name = "Troupeau.findById", query = "SELECT t FROM Troupeau t WHERE t.id = :id"),
    @NamedQuery(name = "Troupeau.findByVacheLocale", query = "SELECT t FROM Troupeau t WHERE t.vacheLocale = :vacheLocale"),
    @NamedQuery(name = "Troupeau.findByVachePure", query = "SELECT t FROM Troupeau t WHERE t.vachePure = :vachePure"),
    @NamedQuery(name = "Troupeau.findByVacheAmeliore", query = "SELECT t FROM Troupeau t WHERE t.vacheAmeliore = :vacheAmeliore"),
    @NamedQuery(name = "Troupeau.findByVacheTotale", query = "SELECT t FROM Troupeau t WHERE t.vacheTotale = :vacheTotale")})
public class Troupeau implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "equide")
    private int equide;
    @Basic(optional = false)
    @Column(name = "coprins")
    private int coprins;
    @Basic(optional = false)
    @Column(name = "ovins")
    private int ovins;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "vache_locale")
    private int vacheLocale;
    @Basic(optional = false)
    @Column(name = "vache_pure")
    private int vachePure;
    @Basic(optional = false)
    @Column(name = "vache_ameliore")
    private int vacheAmeliore;
    @Basic(optional = false)
    @Column(name = "vache_totale")
    private int vacheTotale;
    @JoinColumn(name = "id_personne", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personne idPersonne;

    public Troupeau() {
    }

    public Troupeau(Integer id) {
        this.id = id;
    }

    public Troupeau(Integer id, int equide, int coprins, int ovins, int vacheLocale, int vachePure, int vacheAmeliore, int vacheTotale) {
        this.id = id;
        this.equide = equide;
        this.coprins = coprins;
        this.ovins = ovins;
        this.vacheLocale = vacheLocale;
        this.vachePure = vachePure;
        this.vacheAmeliore = vacheAmeliore;
        this.vacheTotale = vacheTotale;
    }

    public int getEquide() {
        return equide;
    }

    public void setEquide(int equide) {
        this.equide = equide;
    }

    public int getCoprins() {
        return coprins;
    }

    public void setCoprins(int coprins) {
        this.coprins = coprins;
    }

    public int getOvins() {
        return ovins;
    }

    public void setOvins(int ovins) {
        this.ovins = ovins;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVacheLocale() {
        return vacheLocale;
    }

    public void setVacheLocale(int vacheLocale) {
        this.vacheLocale = vacheLocale;
    }

    public int getVachePure() {
        return vachePure;
    }

    public void setVachePure(int vachePure) {
        this.vachePure = vachePure;
    }

    public int getVacheAmeliore() {
        return vacheAmeliore;
    }

    public void setVacheAmeliore(int vacheAmeliore) {
        this.vacheAmeliore = vacheAmeliore;
    }

    public int getVacheTotale() {
        return vacheTotale;
    }

    public void setVacheTotale(int vacheTotale) {
        this.vacheTotale = vacheTotale;
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
        if (!(object instanceof Troupeau)) {
            return false;
        }
        Troupeau other = (Troupeau) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codes.Troupeau[ id=" + id + " ]";
    }
    
}
