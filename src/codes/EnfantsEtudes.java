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
@Table(name = "enfants_etudes", catalog = "agro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnfantsEtudes.findAll", query = "SELECT e FROM EnfantsEtudes e"),
    @NamedQuery(name = "EnfantsEtudes.findByMales", query = "SELECT e FROM EnfantsEtudes e WHERE e.males = :males"),
    @NamedQuery(name = "EnfantsEtudes.findByFemelles", query = "SELECT e FROM EnfantsEtudes e WHERE e.femelles = :femelles"),
    @NamedQuery(name = "EnfantsEtudes.findById", query = "SELECT e FROM EnfantsEtudes e WHERE e.id = :id")})
public class EnfantsEtudes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "males")
    private int males;
    @Basic(optional = false)
    @Column(name = "femelles")
    private int femelles;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_emp", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personne idEmp;

    public EnfantsEtudes() {
    }

    public EnfantsEtudes(Integer id) {
        this.id = id;
    }

    public EnfantsEtudes(Integer id, int males, int femelles) {
        this.id = id;
        this.males = males;
        this.femelles = femelles;
    }

    public int getMales() {
        return males;
    }

    public void setMales(int males) {
        this.males = males;
    }

    public int getFemelles() {
        return femelles;
    }

    public void setFemelles(int femelles) {
        this.femelles = femelles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Personne getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Personne idEmp) {
        this.idEmp = idEmp;
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
        if (!(object instanceof EnfantsEtudes)) {
            return false;
        }
        EnfantsEtudes other = (EnfantsEtudes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codes.EnfantsEtudes[ id=" + id + " ]";
    }
    
}
