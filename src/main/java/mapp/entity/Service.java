/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Hello Java !
 */
@Entity
@Table(name = "service", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s")
    , @NamedQuery(name = "Service.findById", query = "SELECT s FROM Service s WHERE s.id = :id")
    , @NamedQuery(name = "Service.findByDescription", query = "SELECT s FROM Service s WHERE s.description = :description")
    , @NamedQuery(name = "Service.findByPrice", query = "SELECT s FROM Service s WHERE s.price = :price")
    , @NamedQuery(name = "Service.findByRating", query = "SELECT s FROM Service s WHERE s.rating = :rating")
    , @NamedQuery(name = "Service.findByDuration", query = "SELECT s FROM Service s WHERE s.duration = :duration")
    , @NamedQuery(name = "Service.findByStatus", query = "SELECT s FROM Service s WHERE s.status = :status")})
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "rating")
    private Integer rating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration")
    private int duration;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @ManyToMany(mappedBy = "serviceList")
    private List<ImageUrl> imageUrlList;
    @ManyToMany(mappedBy = "serviceList")
    private List<EnrolledUser> enrolledUserList;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Company companyId;
    @JoinColumn(name = "subcategory_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Subcategory subcategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceId")
    private List<Orderlist> orderlistList;

    public Service() {
    }

    public Service(Integer id) {
        this.id = id;
    }

    public Service(Integer id, String description, BigDecimal price, int duration, boolean status) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<ImageUrl> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(List<ImageUrl> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }

    public List<EnrolledUser> getEnrolledUserList() {
        return enrolledUserList;
    }

    public void setEnrolledUserList(List<EnrolledUser> enrolledUserList) {
        this.enrolledUserList = enrolledUserList;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Subcategory getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Subcategory subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

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
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapp.Service[ id=" + id + " ]";
    }
    
}
