/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Hello Java !
 */
@Entity
@Table(name = "appointment", catalog = "mapp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a")
    , @NamedQuery(name = "Appointment.findById", query = "SELECT a FROM Appointment a WHERE a.id = :id")
    , @NamedQuery(name = "Appointment.findByEnddate", query = "SELECT a FROM Appointment a WHERE a.enddate = :enddate")
    , @NamedQuery(name = "Appointment.findByStartdate", query = "SELECT a FROM Appointment a WHERE a.startdate = :startdate")
    , @NamedQuery(name = "Appointment.findByAppointmentDate", query = "SELECT a FROM Appointment a WHERE a.appointmentDate = :appointmentDate")})
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @NotNull(message = "Please *********** enter a ********** value")
    @Column(name = "enddate")
    private Short enddate;
    
    @NotNull(message = "{NotNull.appointment.startdate}")
    @Column(name = "startdate")
    private Short startdate;
    
    @NotNull(message = "{NotNull.appointment.appointmentDate}")
    @Column(name = "appointment_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;

    @JsonBackReference(value="enrolledUserMany_appointment")     
//    @JsonManagedReference(value="enrolledUserMany_appointment")     
//    @JsonIgnore
    @ManyToMany(mappedBy = "appointmentList", fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private List<EnrolledUser> enrolledUserList;

    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Company company;

    @Cascade(CascadeType.MERGE)
    @JoinColumn(name = "orderlist_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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

    public Short getEnddate() {
        return enddate;
    }

    public void setEnddate(Short enddate) {
        this.enddate = enddate;
    }

    public Short getStartdate() {
        return startdate;
    }

    public void setStartdate(Short startdate) {
        this.startdate = startdate;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public List<EnrolledUser> getEnrolledUserList() {
        return enrolledUserList;
    }

    public void setEnrolledUserList(List<EnrolledUser> enrolledUserList) {
        this.enrolledUserList = enrolledUserList;
    }

    @JsonBackReference(value="company_appointment")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @JsonBackReference(value="orderlist_appointment")
    public Orderlist getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(Orderlist orderlist) {
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
        return "mapp.entity.Appointment[ id=" + id + " ]";
    }

}
