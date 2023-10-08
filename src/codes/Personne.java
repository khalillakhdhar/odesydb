/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author khali
 */
@Entity
@Table(name = "personne", catalog = "agro", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
    @NamedQuery(name = "Personne.findById", query = "SELECT p FROM Personne p WHERE p.id = :id"),
    @NamedQuery(name = "Personne.findByNomComplet", query = "SELECT p FROM Personne p WHERE p.nomComplet = :nomComplet"),
    @NamedQuery(name = "Personne.findByGouvernorat", query = "SELECT p FROM Personne p WHERE p.gouvernorat = :gouvernorat"),
    @NamedQuery(name = "Personne.findByDelegation", query = "SELECT p FROM Personne p WHERE p.delegation = :delegation"),
    @NamedQuery(name = "Personne.findBySecteur", query = "SELECT p FROM Personne p WHERE p.secteur = :secteur"),
    @NamedQuery(name = "Personne.findBySexe", query = "SELECT p FROM Personne p WHERE p.sexe = :sexe"),
    @NamedQuery(name = "Personne.findByNaissance", query = "SELECT p FROM Personne p WHERE p.naissance = :naissance"),
    @NamedQuery(name = "Personne.findByCin", query = "SELECT p FROM Personne p WHERE p.cin = :cin"),
    @NamedQuery(name = "Personne.findByScolarite", query = "SELECT p FROM Personne p WHERE p.scolarite = :scolarite"),
    @NamedQuery(name = "Personne.findByPrincipale", query = "SELECT p FROM Personne p WHERE p.principale = :principale"),
    @NamedQuery(name = "Personne.findBySecondaire", query = "SELECT p FROM Personne p WHERE p.secondaire = :secondaire"),
    @NamedQuery(name = "Personne.findByCasSociale", query = "SELECT p FROM Personne p WHERE p.casSociale = :casSociale"),
    @NamedQuery(name = "Personne.findByExploitation", query = "SELECT p FROM Personne p WHERE p.exploitation = :exploitation"),
    @NamedQuery(name = "Personne.findByPresence", query = "SELECT p FROM Personne p WHERE p.presence = :presence"),
    @NamedQuery(name = "Personne.findByMiniProjet", query = "SELECT p FROM Personne p WHERE p.miniProjet = :miniProjet")})
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom_complet")
    private String nomComplet;
    @Basic(optional = false)
    @Column(name = "gouvernorat")
    private String gouvernorat;
    @Basic(optional = false)
    @Column(name = "delegation")
    private String delegation;
    @Basic(optional = false)
    @Column(name = "secteur")
    private String secteur;
    @Basic(optional = false)
    @Column(name = "sexe")
    private String sexe;
    @Basic(optional = false)
    @Column(name = "naissance")
    private String naissance;
    @Basic(optional = false)
    @Column(name = "Cin")
    private String cin;
    @Basic(optional = false)
    @Column(name = "scolarite")
    private String scolarite;
    @Basic(optional = false)
    @Column(name = "principale")
    private int principale;
    @Basic(optional = false)
    @Column(name = "secondaire")
    private int secondaire;
    @Basic(optional = false)
    @Column(name = "cas_sociale")
    private String casSociale;
    @Basic(optional = false)
    @Column(name = "exploitation")
    private int exploitation;
    @Basic(optional = false)
    @Column(name = "presence")
    private int presence;
    @Basic(optional = false)
    @Column(name = "mini_projet")
    private int miniProjet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Troupeau> troupeauCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Surfaceglobale> surfaceglobaleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmp")
    private Collection<EnfantsEtudes> enfantsEtudesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Surfaces> surfacesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Logement> logementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Pâturages> pâturagesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Enfants> enfantsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonne")
    private Collection<Conjoint> conjointCollection;

    public Personne() {
    }

    public Personne(Integer id) {
        this.id = id;
    }

    public Personne(Integer id, String nomComplet, String gouvernorat, String delegation, String secteur, String sexe, String naissance, String cin, String scolarite, int principale, int secondaire, String casSociale, int exploitation, int presence, int miniProjet) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.gouvernorat = gouvernorat;
        this.delegation = delegation;
        this.secteur = secteur;
        this.sexe = sexe;
        this.naissance = naissance;
        this.cin = cin;
        this.scolarite = scolarite;
        this.principale = principale;
        this.secondaire = secondaire;
        this.casSociale = casSociale;
        this.exploitation = exploitation;
        this.presence = presence;
        this.miniProjet = miniProjet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getDelegation() {
        return delegation;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getScolarite() {
        return scolarite;
    }

    public void setScolarite(String scolarite) {
        this.scolarite = scolarite;
    }

    public int getPrincipale() {
        return principale;
    }

    public void setPrincipale(int principale) {
        this.principale = principale;
    }

    public int getSecondaire() {
        return secondaire;
    }

    public void setSecondaire(int secondaire) {
        this.secondaire = secondaire;
    }

    public String getCasSociale() {
        return casSociale;
    }

    public void setCasSociale(String casSociale) {
        this.casSociale = casSociale;
    }

    public int getExploitation() {
        return exploitation;
    }

    public void setExploitation(int exploitation) {
        this.exploitation = exploitation;
    }

    public int getPresence() {
        return presence;
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public int getMiniProjet() {
        return miniProjet;
    }

    public void setMiniProjet(int miniProjet) {
        this.miniProjet = miniProjet;
    }

    @XmlTransient
    public Collection<Troupeau> getTroupeauCollection() {
        return troupeauCollection;
    }

    public void setTroupeauCollection(Collection<Troupeau> troupeauCollection) {
        this.troupeauCollection = troupeauCollection;
    }

    @XmlTransient
    public Collection<Surfaceglobale> getSurfaceglobaleCollection() {
        return surfaceglobaleCollection;
    }

    public void setSurfaceglobaleCollection(Collection<Surfaceglobale> surfaceglobaleCollection) {
        this.surfaceglobaleCollection = surfaceglobaleCollection;
    }

    @XmlTransient
    public Collection<EnfantsEtudes> getEnfantsEtudesCollection() {
        return enfantsEtudesCollection;
    }

    public void setEnfantsEtudesCollection(Collection<EnfantsEtudes> enfantsEtudesCollection) {
        this.enfantsEtudesCollection = enfantsEtudesCollection;
    }

    @XmlTransient
    public Collection<Surfaces> getSurfacesCollection() {
        return surfacesCollection;
    }

    public void setSurfacesCollection(Collection<Surfaces> surfacesCollection) {
        this.surfacesCollection = surfacesCollection;
    }

    @XmlTransient
    public Collection<Logement> getLogementCollection() {
        return logementCollection;
    }

    public void setLogementCollection(Collection<Logement> logementCollection) {
        this.logementCollection = logementCollection;
    }

    @XmlTransient
    public Collection<Pâturages> getPâturagesCollection() {
        return pâturagesCollection;
    }

    public void setPâturagesCollection(Collection<Pâturages> pâturagesCollection) {
        this.pâturagesCollection = pâturagesCollection;
    }

    @XmlTransient
    public Collection<Enfants> getEnfantsCollection() {
        return enfantsCollection;
    }

    public void setEnfantsCollection(Collection<Enfants> enfantsCollection) {
        this.enfantsCollection = enfantsCollection;
    }

    @XmlTransient
    public Collection<Conjoint> getConjointCollection() {
        return conjointCollection;
    }

    public void setConjointCollection(Collection<Conjoint> conjointCollection) {
        this.conjointCollection = conjointCollection;
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
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codes.Personne[ id=" + id + " ]";
    }
    
}
