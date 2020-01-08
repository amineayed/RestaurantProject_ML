/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amin-
 */
@Entity
@Table(name = "element")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Element.findAll", query = "SELECT e FROM Element e")
    , @NamedQuery(name = "Element.findById", query = "SELECT e FROM Element e WHERE e.id = :id")
    , @NamedQuery(name = "Element.findByLibelle", query = "SELECT e FROM Element e WHERE e.libelle = :libelle")
    , @NamedQuery(name = "Element.findByType", query = "SELECT e FROM Element e WHERE e.type = :type")
    , @NamedQuery(name = "Element.findByPrix", query = "SELECT e FROM Element e WHERE e.prix = :prix")})
public class Element implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix")
    private double prix;
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Menu menuId;

    public Element() {
    }

    public Element(Integer id) {
        this.id = id;
    }

    public Element(Integer id, String libelle, String type, double prix) {
        this.id = id;
        this.libelle = libelle;
        this.type = type;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
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
        if (!(object instanceof Element)) {
            return false;
        }
        Element other = (Element) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Element[ id=" + id + " ]";
    }
    
}
