
package mapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "role", catalog = "mapp", schema = "")
public class Role implements Serializable {

    @Basic(optional = false)
    @NotNull(message = "Property admission cannot be null")
    @Size(min = 1, max = 45)
    @Column(name = "admission")
    private String admission;

    @JsonBackReference(value = "companyMany_roleList")
    @ManyToMany(mappedBy = "roleList")
    private List<Company> companyList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JsonBackReference(value = "enrolledUserMany_roleList")
    @ManyToMany(mappedBy = "roleList")
    private List<EnrolledUser> enrolledUserList;

    public Role() {
    }

    public Role(Integer id) {
        this.id = id;
    }

    public Role(String admission) {
        this.admission = admission;
    }

    public Role(Integer id, String admission) {
        this.id = id;
        this.admission = admission;
    }

    public Role(Integer id, String admission, List<EnrolledUser> enrolledUserList) {
        this.id = id;
        this.admission = admission;
        this.enrolledUserList = enrolledUserList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<EnrolledUser> getEnrolledUserList() {
        return enrolledUserList;
    }

    public void setEnrolledUserList(List<EnrolledUser> enrolledUserList) {
        this.enrolledUserList = enrolledUserList;
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
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapp.entity.Role[ id=" + id + " ]";
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

}
