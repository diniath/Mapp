
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "enrolled_user", catalog = "mapp", schema = "")
public class EnrolledUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull(message = "Property username cannot be null")
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    
    @Basic(optional = false)
    @NotNull(message = "Property password cannot be null")
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    
    @Basic(optional = false)
    @NotNull(message = "Property fname cannot be null")
    @Size(min = 1, max = 45)
    @Column(name = "fname")
    private String fname;
    
    @Basic(optional = false)
    @NotNull(message = "Property lname cannot be null")
    @Size(min = 1, max = 45)
    @Column(name = "lname")
    private String lname;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull(message = "Property email cannot be null")
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @NotNull(message = "Property dateofbirth cannot be null")
    @Column(name = "dateofbirth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateofbirth;
    
    @Basic(optional = false)
    @NotNull(message = "Property postalcode cannot be null")
    @Column(name = "postalcode")
    private int postalcode;
    
    @Basic(optional = false)
    @NotNull(message = "Property address cannot be null")
    @Size(min = 1, max = 45)
    @Column(name = "address")
    private String address;
    
    @Basic(optional = false)
    @NotNull(message = "Property city cannot be null")
    @Size(min = 1, max = 45)
    @Column(name = "city")
    private String city;
    
    @Basic(optional = false)
    @NotNull(message = "Property municipality cannot be null")
    @Size(min = 1, max = 45)
    @Column(name = "municipality")
    private String municipality;
    
    @Basic(optional = false)
    @NotNull(message = "Property telephone cannot be null")
    @Size(min = 1, max = 45)
    @Column(name = "telephone")
    private String telephone;
    
    @Basic(optional = false)
    @NotNull(message = "Property mobile cannot be null")
    @Size(min = 1, max = 45)
    @Column(name = "mobile")
    private String mobile;

    @JsonBackReference(value = "enrolledUser_appointment")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enrolledUser")
    private List<Appointment> appointmentList;

    @JoinTable(name = "user_role", joinColumns = {
        @JoinColumn(name = "enrolled_user_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "id")})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    private List<Role> roleList;

    @JoinTable(name = "favorite", joinColumns = {
        @JoinColumn(name = "enrolled_user_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "product_id", referencedColumnName = "id")})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    private List<Product> productList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enrolledUser")
    private List<Ordering> orderingList;

    @JoinColumn(name = "image_url_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private ImageUrl imageUrl;

    public EnrolledUser() {
    }

    public EnrolledUser(Integer id) {
        this.id = id;
    }

    public EnrolledUser(Integer id, String username, String password, String fname, String lname, String email, LocalDate dateofbirth, int postalcode, String address, String city, String municipality, String telephone, String mobile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.dateofbirth = dateofbirth;
        this.postalcode = postalcode;
        this.address = address;
        this.city = city;
        this.municipality = municipality;
        this.telephone = telephone;
        this.mobile = mobile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    
    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @JsonManagedReference(value = "enrolledUser_ordering")
    public List<Ordering> getOrderingList() {
        return orderingList;
    }

    public void setOrderingList(List<Ordering> orderingList) {
        this.orderingList = orderingList;
    }

    @JsonBackReference(value = "enrolledUser_imageUrl")
    public ImageUrl getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(ImageUrl imageUrl) {
        this.imageUrl = imageUrl;
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
        if (!(object instanceof EnrolledUser)) {
            return false;
        }
        EnrolledUser other = (EnrolledUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapp.entity.EnrolledUser[ id=" + id + " ]";
    }

}
