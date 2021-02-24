package mapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "appointment", catalog = "mapp", schema = "")
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Property enddate cannot be null")
    @Column(name = "enddate")
    private Short enddate;

    @NotNull(message = "Property startdate cannot be null")
    @Column(name = "startdate")
    private Short startdate;

    @NotNull(message = "Property appointmentDate cannot be null")
    @Column(name = "appointment_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;

    @JsonBackReference(value = "appointment_enrolledUser")
    @JoinColumn(name = "enrolled_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private EnrolledUser enrolledUser;

    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Company company;

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Product product;

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

    public EnrolledUser getEnrolledUser() {
        return enrolledUser;
    }

    public void setEnrolledUser(EnrolledUser enrolledUser) {
        this.enrolledUser = enrolledUser;
    }

    @JsonBackReference(value = "company_appointment")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @JsonBackReference(value = "orderlist_appointment")
    public Orderlist getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(Orderlist orderlist) {
        this.orderlist = orderlist;
    }

    @JsonBackReference(value = "product_appointment")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
