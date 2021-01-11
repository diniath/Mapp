
package mapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cascade;


@Entity
@Table(name = "company", catalog = "mapp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
    , @NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id")
    , @NamedQuery(name = "Company.findByUsername", query = "SELECT c FROM Company c WHERE c.username = :username")
    , @NamedQuery(name = "Company.findByPassword", query = "SELECT c FROM Company c WHERE c.password = :password")
    , @NamedQuery(name = "Company.findByCname", query = "SELECT c FROM Company c WHERE c.cname = :cname")
    , @NamedQuery(name = "Company.findByEmail", query = "SELECT c FROM Company c WHERE c.email = :email")
    , @NamedQuery(name = "Company.findByPostalcode", query = "SELECT c FROM Company c WHERE c.postalcode = :postalcode")
    , @NamedQuery(name = "Company.findByAddress", query = "SELECT c FROM Company c WHERE c.address = :address")
    , @NamedQuery(name = "Company.findByCity", query = "SELECT c FROM Company c WHERE c.city = :city")
    , @NamedQuery(name = "Company.findByMunicipality", query = "SELECT c FROM Company c WHERE c.municipality = :municipality")
    , @NamedQuery(name = "Company.findByTelephone", query = "SELECT c FROM Company c WHERE c.telephone = :telephone")
    , @NamedQuery(name = "Company.findByMobile", query = "SELECT c FROM Company c WHERE c.mobile = :mobile")
    , @NamedQuery(name = "Company.findByVatnumber", query = "SELECT c FROM Company c WHERE c.vatnumber = :vatnumber")
    , @NamedQuery(name = "Company.findByVatservice", query = "SELECT c FROM Company c WHERE c.vatservice = :vatservice")
    , @NamedQuery(name = "Company.findByDescription", query = "SELECT c FROM Company c WHERE c.description = :description")
    , @NamedQuery(name = "Company.findByRepresentative", query = "SELECT c FROM Company c WHERE c.representative = :representative")
    , @NamedQuery(name = "Company.findByRating", query = "SELECT c FROM Company c WHERE c.rating = :rating")
    , @NamedQuery(name = "Company.findByIban", query = "SELECT c FROM Company c WHERE c.iban = :iban")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;

    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cname")
    private String cname;       

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @NotNull
    @Column(name = "postalcode")
    private int postalcode;

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "address")
    private String address;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "city")
    private String city;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "municipality")
    private String municipality;

    @Basic(optional = false)
    @NotNull
    @Column(name = "telephone")
    private String telephone;

    @Basic(optional = false)
    @NotNull
    @Column(name = "mobile")
    private String mobile;

    @Basic(optional = false)
    @NotNull
    @Column(name = "vatnumber")
    private String vatnumber;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "vatservice")
    private String vatservice;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "description")
    private String description; 

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "representative")
    private String representative;

    @Size(max = 45)
    @Column(name = "iban")
    private String iban;

    @Column(name = "rating")
    private Integer rating;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "profile")
    private String profile;

//    @JsonManagedReference(value = "companyMany_roleList")
    @JoinTable(name = "company_role", joinColumns = {
        @JoinColumn(name = "company_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "id")})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Role> roleList;

//    @JsonManagedReference(value = "companyMany_postalCode")
    @JoinTable(name = "area_of_service", joinColumns = {
        @JoinColumn(name = "company_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "postal_code_id", referencedColumnName = "id")})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<PostalCode> postalCodeList;

//    @JsonManagedReference(value = "companyMany_imageUrl")
    @JoinTable(name = "company_image", joinColumns = {
        @JoinColumn(name = "company_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "image_url_id", referencedColumnName = "id")})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    private List<ImageUrl> imageUrlList;

//    @JsonManagedReference(value = "companyMany_orderlist")
    @JoinTable(name = "paid", joinColumns = {
        @JoinColumn(name = "company_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "orderlist_id", referencedColumnName = "id")})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    private List<Orderlist> orderlistList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Product> productList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Appointment> appointmentList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Schedule> scheduleList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Review> reviewList;

    @JoinColumn(name = "image_url_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private ImageUrl imageUrl;

    public Company() {
    }

    public Company(Integer id) {
        this.id = id;
    }

    public Company(Integer id, String username, String password, String cname, String email, int postalcode, String address, String city, String municipality, String telephone, String mobile, String vatnumber, String vatservice, String description, String representative, String iban, Integer rating, String profile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cname = cname;
        this.email = email;
        this.postalcode = postalcode;
        this.address = address;
        this.city = city;
        this.municipality = municipality;
        this.telephone = telephone;
        this.mobile = mobile;
        this.vatnumber = vatnumber;
        this.vatservice = vatservice;
        this.description = description;
        this.representative = representative;
        this.iban = iban;
        this.rating = rating;
        this.profile = profile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<PostalCode> getPostalCodeList() {
        return postalCodeList;
    }

    public void setPostalCodeList(List<PostalCode> postalCodeList) {
        this.postalCodeList = postalCodeList;
    }

    public List<ImageUrl> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(List<ImageUrl> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }

    public List<Orderlist> getOrderlistList() {
        return orderlistList;
    }

    public void setOrderlistList(List<Orderlist> orderlistList) {
        this.orderlistList = orderlistList;
    }

    @JsonManagedReference(value = "company_product")
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @JsonManagedReference(value = "company_appointment")
    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @JsonManagedReference(value = "company_schedule")
    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @JsonManagedReference(value = "company_review")
    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @JsonBackReference(value = "company_imageUrl")
    public ImageUrl getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(ImageUrl imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getVatnumber() {
        return vatnumber;
    }

    public void setVatnumber(String vatnumber) {
        this.vatnumber = vatnumber;
    }

    public String getVatservice() {
        return vatservice;
    }

    public void setVatservice(String vatservice) {
        this.vatservice = vatservice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
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
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapp.entity.Company[ id=" + id + " ]";
    }

}
