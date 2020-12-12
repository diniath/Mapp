/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "appointment", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a")
    , @NamedQuery(name = "Appointment.findById", query = "SELECT a FROM Appointment a WHERE a.id = :id")
    , @NamedQuery(name = "Appointment.findByEnddate", query = "SELECT a FROM Appointment a WHERE a.enddate = :enddate")
    , @NamedQuery(name = "Appointment.findByStartdate", query = "SELECT a FROM Appointment a WHERE a.startdate = :startdate")
    , @NamedQuery(name = "Appointment.findByDay", query = "SELECT a FROM Appointment a WHERE a.day = :day")})
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "enddate")
    private short enddate;
    @Column(name = "startdate")
    private short startdate;
    @Column(name = "day")
    private short day;
    @JoinTable(name = "client_appointment", joinColumns = {
        @JoinColumn(name = "appointment_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "client_id", referencedColumnName = "id")})
    @ManyToMany
    private List<EnrolledUser> enrolledUserList;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Company company;
    @JoinColumn(name = "orderlist_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Orderlist orderlist;

    public Appointment() {
    }

    public Appointment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getEnddate() {
        return enddate;
    }

    public void setEnddate(short enddate) {
        this.enddate = enddate;
    }

    public short getStartdate() {
        return startdate;
    }

    public void setStartdate(short startdate) {
        this.startdate = startdate;
    }

    public short getDay() {
        return day;
    }

    public void setDay(short day) {
        this.day = day;
    }

    public List<EnrolledUser> getEnrolledUserList() {
        return enrolledUserList;
    }

    public void setEnrolledUserList(List<EnrolledUser> enrolledUserList) {
        this.enrolledUserList = enrolledUserList;
    }

    public Company getCompanyId() {
        return company;
    }

    public void setCompanyId(Company company) {
        this.company = company;
    }

    public Orderlist getOrderlistId() {
        return orderlist;
    }

    public void setOrderlistId(Orderlist orderlist) {
        this.orderlist = orderlist;
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
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapp.Appointment[ id=" + id + " ]";
    }
    
}
