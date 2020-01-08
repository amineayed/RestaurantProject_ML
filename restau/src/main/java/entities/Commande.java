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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
    , @NamedQuery(name = "Commande.findById", query = "SELECT c FROM Commande c WHERE c.id = :id")
    , @NamedQuery(name = "Commande.findByDate", query = "SELECT c FROM Commande c WHERE c.date = :date")
    , @NamedQuery(name = "Commande.findByHeure", query = "SELECT c FROM Commande c WHERE c.heure = :heure")
    , @NamedQuery(name = "Commande.findByEtat", query = "SELECT c FROM Commande c WHERE c.etat = :etat")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heure")
    @Temporal(TemporalType.TIME)
    private Date heure;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "etat")
    private String etat;
    @JoinColumn(name = "client", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "Menu_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Menu menuid;
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Reservation reservationId;

    public Commande() {
    }

    public Commande(Integer id) {
        this.id = id;
    }

    public Commande(Integer id, Date date, Date heure, String etat) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Menu getMenuid() {
        return menuid;
    }

    public void setMenuid(Menu menuid) {
        this.menuid = menuid;
    }

    public Reservation getReservationId() {
        return reservationId;
    }

    public void setReservationId(Reservation reservationId) {
        this.reservationId = reservationId;
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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Commande[ id=" + id + " ]";
    }
    
}
