package mapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "product", catalog = "mapp", schema = "")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull(message = "Property profile cannot be null")
    @Size(min = 1, max = 200)
    @Column(name = "profile")
    private String profile;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull(message = "Property price cannot be null")
    @Column(name = "price")
    private BigDecimal price;
    
    @Column(name = "rating")
    private Integer rating;
    
    @Basic(optional = false)
    @NotNull(message = "Property duration cannot be null")
    @Column(name = "duration")
    private int duration;
    
    @Basic(optional = false)
    @NotNull(message = "Property status cannot be null")
    @Column(name = "status")
    private boolean status;

    @Basic(optional = false)
    @NotNull(message = "Property description cannot be null")
    @Size(min = 1, max = 500)
    @Column(name = "description")
    private String description;

    @JoinTable(name = "product_image", joinColumns = {
        @JoinColumn(name = "product_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "image_url_id", referencedColumnName = "id")})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<ImageUrl> imageUrlList;

    @JsonBackReference(value = "product_enrolledUserList")
    @ManyToMany(mappedBy = "productList")
    private List<EnrolledUser> enrolledUserList;

    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Company company;

    @JoinColumn(name = "subcategory_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Subcategory subcategory;

    @JsonBackReference(value = "product_orderlist")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Orderlist> orderlistList;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String profile, BigDecimal price, Integer rating, int duration, boolean status, String description) {
        this.id = id;
        this.profile = profile;
        this.price = price;
        this.rating = rating;
        this.duration = duration;
        this.status = status;
        this.description = description;
    }

    
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
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

    @JsonBackReference(value = "company_product")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

//    @JsonBackReference(value = "product_subcategory")
    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapp.entity.Product[ id=" + id + " ]";
    }

}
