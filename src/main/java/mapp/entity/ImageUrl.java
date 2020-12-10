/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Hello Java !
 */
@Entity
@Table(name = "image_url", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "ImageUrl.findAll", query = "SELECT i FROM ImageUrl i")
    , @NamedQuery(name = "ImageUrl.findById", query = "SELECT i FROM ImageUrl i WHERE i.id = :id")
    , @NamedQuery(name = "ImageUrl.findByUrl", query = "SELECT i FROM ImageUrl i WHERE i.url = :url")})
public class ImageUrl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2083)
    @Column(name = "url")
    private String url;
    @JoinTable(name = "service_image", joinColumns = {
        @JoinColumn(name = "image_url_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "service_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Service> serviceList;
    @ManyToMany(mappedBy = "imageUrlList")
    private List<Company> companyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imageUrlId")
    private List<Company> companyList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imageUrlId")
    private List<EnrolledUser> enrolledUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imageUrlId")
    private List<Category> categoryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imageUrlId")
    private List<Subcategory> subcategoryList;

    public ImageUrl() {
    }

    public ImageUrl(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public List<Company> getCompanyList1() {
        return companyList1;
    }

    public void setCompanyList1(List<Company> companyList1) {
        this.companyList1 = companyList1;
    }

    public List<EnrolledUser> getEnrolledUserList() {
        return enrolledUserList;
    }

    public void setEnrolledUserList(List<EnrolledUser> enrolledUserList) {
        this.enrolledUserList = enrolledUserList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Subcategory> getSubcategoryList() {
        return subcategoryList;
    }

    public void setSubcategoryList(List<Subcategory> subcategoryList) {
        this.subcategoryList = subcategoryList;
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
        if (!(object instanceof ImageUrl)) {
            return false;
        }
        ImageUrl other = (ImageUrl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapp.ImageUrl[ id=" + id + " ]";
    }
    
}
