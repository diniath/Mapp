/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.entity;

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

/**
 *
 * @author Hello Java !
 */
@Entity
@Table(name = "schedule", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s")
    , @NamedQuery(name = "Schedule.findById", query = "SELECT s FROM Schedule s WHERE s.id = :id")
    , @NamedQuery(name = "Schedule.findByDay", query = "SELECT s FROM Schedule s WHERE s.day = :day")
    , @NamedQuery(name = "Schedule.findByOpentime", query = "SELECT s FROM Schedule s WHERE s.opentime = :opentime")
    , @NamedQuery(name = "Schedule.findByClosetime", query = "SELECT s FROM Schedule s WHERE s.closetime = :closetime")
    , @NamedQuery(name = "Schedule.findByReopentime", query = "SELECT s FROM Schedule s WHERE s.reopentime = :reopentime")
    , @NamedQuery(name = "Schedule.findByReclosetime", query = "SELECT s FROM Schedule s WHERE s.reclosetime = :reclosetime")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "day")
    private int day;
    @Basic(optional = false)
    @NotNull
    @Column(name = "opentime")
    private short opentime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "closetime")
    private short closetime;
    @Column(name = "reopentime")
    private Short reopentime;
    @Column(name = "reclosetime")
    private Short reclosetime;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Company company;

    public Schedule() {
    }

    public Schedule(Integer id) {
        this.id = id;
    }

    public Schedule(Integer id, int day, short opentime, short closetime) {
        this.id = id;
        this.day = day;
        this.opentime = opentime;
        this.closetime = closetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public short getOpentime() {
        return opentime;
    }

    public void setOpentime(short opentime) {
        this.opentime = opentime;
    }

    public short getClosetime() {
        return closetime;
    }

    public void setClosetime(short closetime) {
        this.closetime = closetime;
    }

    public Short getReopentime() {
        return reopentime;
    }

    public void setReopentime(Short reopentime) {
        this.reopentime = reopentime;
    }

    public Short getReclosetime() {
        return reclosetime;
    }

    public void setReclosetime(Short reclosetime) {
        this.reclosetime = reclosetime;
    }

    public Company getCompanyId() {
        return company;
    }

    public void setCompanyId(Company company) {
        this.company = company;
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
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapp.Schedule[ id=" + id + " ]";
    }
    
}
