
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
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "review", catalog = "mapp", schema = "")
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull(message = "Property ratingDate cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "rating_date")
    private LocalDate ratingDate;
    
    @Size(max = 45)
    @Column(name = "product_comment")
    private String productComment;
    
    @Basic(optional = false)
    @NotNull(message = "Property productRating cannot be null")
    @Column(name = "product_rating")
    private short productRating;
    
    @Column(name = "company_rating")
    private Short companyRating;
    
    @Size(max = 45)
    @Column(name = "comment_company")
    private String commentCompany;

    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Company company;

    @JoinColumn(name = "orderlist_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Orderlist orderlist;

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Product product;    

    @JoinColumn(name = "enrolled_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private EnrolledUser enrolledUser;  
    
    public Review() {
    }

    public Review(Integer id) {
        this.id = id;
    }

    public Review(Integer id, short productRating) {
        this.id = id;
        this.productRating = productRating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(LocalDate ratingDate) {
        this.ratingDate = ratingDate;
    }

    public String getProductComment() {
        return productComment;
    }

    public void setProductComment(String productComment) {
        this.productComment = productComment;
    }

    public short getProductRating() {
        return productRating;
    }

    public void setProductRating(short productRating) {
        this.productRating = productRating;
    }

    public Short getCompanyRating() {
        return companyRating;
    }

    public void setCompanyRating(Short companyRating) {
        this.companyRating = companyRating;
    }

    public String getCommentCompany() {
        return commentCompany;
    }

    public void setCommentCompany(String commentCompany) {
        this.commentCompany = commentCompany;
    }

    @JsonBackReference(value="company_review")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @JsonBackReference(value="orderlist_review")
    public Orderlist getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(Orderlist orderlist) {
        this.orderlist = orderlist;
    }
    
    @JsonBackReference(value="product_review")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @JsonBackReference(value="enrolledUser_review")
    public EnrolledUser getEnrolledUser() {
        return enrolledUser;
    }

    public void setEnrolledUser(EnrolledUser enrolledUser) {
        this.enrolledUser = enrolledUser;
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
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapp.entity.Review[ id=" + id + " ]";
    }

}
