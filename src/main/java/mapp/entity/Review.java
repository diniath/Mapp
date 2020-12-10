/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Hello Java !
 */
@Entity
@Table(name = "review", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r")
    , @NamedQuery(name = "Review.findById", query = "SELECT r FROM Review r WHERE r.id = :id")
    , @NamedQuery(name = "Review.findByRatingDate", query = "SELECT r FROM Review r WHERE r.ratingDate = :ratingDate")
    , @NamedQuery(name = "Review.findByServiceComment", query = "SELECT r FROM Review r WHERE r.serviceComment = :serviceComment")
    , @NamedQuery(name = "Review.findByServiceRating", query = "SELECT r FROM Review r WHERE r.serviceRating = :serviceRating")
    , @NamedQuery(name = "Review.findByCompanyRating", query = "SELECT r FROM Review r WHERE r.companyRating = :companyRating")
    , @NamedQuery(name = "Review.findByCommentCompany", query = "SELECT r FROM Review r WHERE r.commentCompany = :commentCompany")})
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ratingDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ratingDate;
    @Size(max = 45)
    @Column(name = "service_comment")
    private String serviceComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "service_rating")
    private short serviceRating;
    @Column(name = "company_rating")
    private Short companyRating;
    @Size(max = 45)
    @Column(name = "comment_company")
    private String commentCompany;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Company companyId;
    @JoinColumn(name = "orderlist_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Orderlist orderlistId;

    public Review() {
    }

    public Review(Integer id) {
        this.id = id;
    }

    public Review(Integer id, short serviceRating) {
        this.id = id;
        this.serviceRating = serviceRating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }

    public String getServiceComment() {
        return serviceComment;
    }

    public void setServiceComment(String serviceComment) {
        this.serviceComment = serviceComment;
    }

    public short getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(short serviceRating) {
        this.serviceRating = serviceRating;
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

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Orderlist getOrderlistId() {
        return orderlistId;
    }

    public void setOrderlistId(Orderlist orderlistId) {
        this.orderlistId = orderlistId;
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
        return "mapp.Review[ id=" + id + " ]";
    }
    
}
