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
@Table(name = "surfaceglobale", catalog = "agro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Surfaceglobale.findAll", query = "SELECT s FROM Surfaceglobale s"),
    @NamedQuery(name = "Surfaceglobale.findById", query = "SELECT s FROM Surfaceglobale s WHERE s.id = :id"),
    @NamedQuery(name = "Surfaceglobale.findByType", query = "SELECT s FROM Surfaceglobale s WHERE s.type = :type"),
    @NamedQuery(name = "Surfaceglobale.findByValeur", query = "SELECT s FROM Surfaceglobale s WHERE s.valeur = :valeur"),
    @NamedQuery(name = "Surfaceglobale.findByPotableAutre", query = "SELECT s FROM Surfaceglobale s WHERE s.potableAutre = :potableAutre"),
    @NamedQuery(name = "Surfaceglobale.findByPotableCollectif", query = "SELECT s FROM Surfaceglobale s WHERE s.potableCollectif = :potableCollectif"),
    @NamedQuery(name = "Surfaceglobale.findByPotableIndividuelle", query = "SELECT s FROM Surfaceglobale s WHERE s.potableIndividuelle = :potableIndividuelle"),
    @NamedQuery(name = "Surfaceglobale.findByCiterne", query = "SELECT s FROM Surfaceglobale s WHERE s.citerne = :citerne")})
public class Surfaceglobale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type")
    private int type;
    @Basic(optional = false)
    @Column(name = "valeur")
    private int valeur;
    @Basic(optional = false)
    @Column(name = "potable_autre")
    private int potableAutre;
    @Basic(optional = false)
    @Column(name = "potable_collectif")
    private int potableCollectif;
    @Basic(optional = false)
    @Column(name = "potable_individuelle")
    private int potableIndividuelle;
    @Basic(optional = false)
    @Column(name = "citerne")
    private int citerne;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personne idUser;

    public Surfaceglobale() {
    }

    public Surfaceglobale(Integer id) {
        this.id = id;
    }

    public Surfaceglobale(Integer id, int type, int valeur, int potableAutre, int potableCollectif, int potableIndividuelle, int citerne) {
        this.id = id;
        this.type = type;
        this.valeur = valeur;
        this.potableAutre = potableAutre;
        this.potableCollectif = potableCollectif;
        this.potableIndividuelle = potableIndividuelle;
        this.citerne = citerne;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public int getPotableAutre() {
        return potableAutre;
    }

    public void setPotableAutre(int potableAutre) {
        this.potableAutre = potableAutre;
    }

    public int getPotableCollectif() {
        return potableCollectif;
    }

    public void setPotableCollectif(int potableCollectif) {
        this.potableCollectif = potableCollectif;
    }

    public int getPotableIndividuelle() {
        return potableIndividuelle;
    }

    public void setPotableIndividuelle(int potableIndividuelle) {
        this.potableIndividuelle = potableIndividuelle;
    }

    public int getCiterne() {
        return citerne;
    }

    public void setCiterne(int citerne) {
        this.citerne = citerne;
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
        if (!(object instanceof Surfaceglobale)) {
            return false;
        }
        Surfaceglobale other = (Surfaceglobale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codes.Surfaceglobale[ id=" + id + " ]";
    }
    
}
