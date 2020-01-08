/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author amin-
 */
@Entity
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
    , @NamedQuery(name = "Reservation.findById", query = "SELECT r FROM Reservation r WHERE r.id = :id")
    , @NamedQuery(name = "Reservation.findByDate", query = "SELECT r FROM Reservation r WHERE r.date = :date")
    , @NamedQuery(name = "Reservation.findByHeure", query = "SELECT r FROM Reservation r WHERE r.heure = :heure")
    , @NamedQuery(name = "Reservation.findByNbPersonnes", query = "SELECT r FROM Reservation r WHERE r.nbPersonnes = :nbPersonnes")
    , @NamedQuery(name = "Reservation.findByEtat", query = "SELECT r FROM Reservation r WHERE r.etat = :etat")})
public class Reservation implements Serializable {

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
    @Column(name = "nb_personnes")
    private int nbPersonnes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "etat")
    private String etat;
    @JoinTable(name = "reservation_tables", joinColumns = {
        @JoinColumn(name = "reservation", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "table_id", referencedColumnName = "numero_table")})
    @ManyToMany
    private List<entities.Table> tableList;
    @JoinColumn(name = "client", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Client client;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservationId")
    private List<Commande> commandeList;

    public Reservation() {
    }

    public Reservation(Integer id) {
        this.id = id;
    }

    public Reservation(Integer id, Date date, Date heure, int nbPersonnes, String etat) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.nbPersonnes = nbPersonnes;
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

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @XmlTransient
    public List<entities.Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<entities.Table> tableList) {
        this.tableList = tableList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @XmlTransient
    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
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
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reservation[ id=" + id + " ]";
    }
    
}
