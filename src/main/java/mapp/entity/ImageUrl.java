
package mapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "image_url", catalog = "mapp", schema = "")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
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

    @JsonBackReference(value = "productMany_imageUrl")
    @ManyToMany(mappedBy = "imageUrlList")
    private List<Product> productList;

    @JsonBackReference(value = "companyMany_imageUrl")
    @ManyToMany(mappedBy = "imageUrlList")
    private List<Company> companyList;

    @JsonBackReference(value = "companyList_imageUrl")    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imageUrl")
    private List<Company> companyList1;

    @JsonBackReference(value = "enrolledUser_imageUrl")    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imageUrl")
    private List<EnrolledUser> enrolledUserList;

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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        return "mapp.entity.ImageUrl[ id=" + id + " ]";
    }

}
