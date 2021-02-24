
package mapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "ordering", catalog = "mapp", schema = "")
public class Ordering implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull(message = "Property orderdate cannot be null")
    @Column(name = "orderdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderdate;
    
    @Basic(optional = false)
    @NotNull(message = "Property paymentMethod cannot be null")
    @Size(min = 1, max = 45)
    @Column(name = "payment_method")
    private String paymentMethod;

    @JoinColumn(name = "enrolled_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private EnrolledUser enrolledUser;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordering")
    private List<Orderlist> orderlistList;

    public Ordering() {
    }

    public Ordering(Integer id) {
        this.id = id;
    }

    public Ordering(Integer id, LocalDate orderdate, String paymentMethod) {
        this.id = id;
        this.orderdate = orderdate;
        this.paymentMethod = paymentMethod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(LocalDate orderdate) {
        this.orderdate = orderdate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @JsonBackReference(value="enrolledUser_ordering")
    public EnrolledUser getEnrolledUser() {
        return enrolledUser;
    }

    public void setEnrolledUser(EnrolledUser enrolledUser) {
        this.enrolledUser = enrolledUser;
    }

    @JsonManagedReference(value="orderlist_ordering")
    public List<Orderlist> getOrderlistList() {
        return orderlistList;
    }

    public void setOrderlistList(List<Orderlist> orderlistList) {
        this.orderlistList = orderlistList;
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
        if (!(object instanceof Ordering)) {
            return false;
        }
        Ordering other = (Ordering) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapp.entity.Ordering[ id=" + id + " ]";
    }

}
