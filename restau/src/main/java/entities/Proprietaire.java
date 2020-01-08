/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amin-
 */
@Entity
@Table(name = "proprietaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proprietaire.findAll", query = "SELECT p FROM Proprietaire p")
    , @NamedQuery(name = "Proprietaire.findById", query = "SELECT p FROM Proprietaire p WHERE p.id = :id")
    , @NamedQuery(name = "Proprietaire.findByNom", query = "SELECT p FROM Proprietaire p WHERE p.nom = :nom")
    , @NamedQuery(name = "Proprietaire.findByPrenom", query = "SELECT p FROM Proprietaire p WHERE p.prenom = :prenom")
    , @NamedQuery(name = "Proprietaire.findByNumRue", query = "SELECT p FROM Proprietaire p WHERE p.numRue = :numRue")
    , @NamedQuery(name = "Proprietaire.findByVille", query = "SELECT p FROM Proprietaire p WHERE p.ville = :ville")
    , @NamedQuery(name = "Proprietaire.findByZipCode", query = "SELECT p FROM Proprietaire p WHERE p.zipCode = :zipCode")
    , @NamedQuery(name = "Proprietaire.findByEmail", query = "SELECT p FROM Proprietaire p WHERE p.email = :email")
    , @NamedQuery(name = "Proprietaire.findByDateNaissance", query = "SELECT p FROM Proprietaire p WHERE p.dateNaissance = :dateNaissance")
    , @NamedQuery(name = "Proprietaire.findByLogin", query = "SELECT p FROM Proprietaire p WHERE p.login = :login")
    , @NamedQuery(name = "Proprietaire.findByPassword", query = "SELECT p FROM Proprietaire p WHERE p.password = :password")})
public class Proprietaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "num_rue")
    private String numRue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ville")
    private String ville;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zip_code")
    private int zipCode;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;

    public Proprietaire() {
    }

    public Proprietaire(Integer id) {
        this.id = id;
    }

    public Proprietaire(Integer id, String nom, String prenom, String numRue, String ville, int zipCode, String email, Date dateNaissance, String login, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numRue = numRue;
        this.ville = ville;
        this.zipCode = zipCode;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.login = login;
        this.password = password;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumRue() {
        return numRue;
    }

    public void setNumRue(String numRue) {
        this.numRue = numRue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Proprietaire)) {
            return false;
        }
        Proprietaire other = (Proprietaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Proprietaire[ id=" + id + " ]";
    }
    
}
