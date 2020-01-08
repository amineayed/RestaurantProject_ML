/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author amin-
 */
@Entity
@javax.persistence.Table(name = "table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Table.findAll", query = "SELECT t FROM Table t")
    , @NamedQuery(name = "Table.findByNumeroTable", query = "SELECT t FROM Table t WHERE t.numeroTable = :numeroTable")})
public class Table implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_table")
    private Integer numeroTable;
    @ManyToMany(mappedBy = "tableList")
    private List<Reservation> reservationList;

    public Table() {
    }

    public Table(Integer numeroTable) {
        this.numeroTable = numeroTable;
    }

    public Integer getNumeroTable() {
        return numeroTable;
    }

    public void setNumeroTable(Integer numeroTable) {
        this.numeroTable = numeroTable;
    }

    @XmlTransient
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroTable != null ? numeroTable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Table)) {
            return false;
        }
        Table other = (Table) object;
        if ((this.numeroTable == null && other.numeroTable != null) || (this.numeroTable != null && !this.numeroTable.equals(other.numeroTable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Table[ numeroTable=" + numeroTable + " ]";
    }
    
}
