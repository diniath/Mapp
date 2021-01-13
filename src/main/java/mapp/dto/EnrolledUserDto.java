
package mapp.dto;


import java.time.LocalDate;
import mapp.entity.ImageUrl;


public class EnrolledUserDto {
    
    private static final long serialVersionUID = 1L;
   
    private Integer id;

    private String username;
 
    private String fname;
    
    private String lname;

    private String email;
 
    private LocalDate dateofbirth;
 
    private int postalcode;

    private String address;

    private String city;

    private String municipality;
   
    private String telephone;

    private String mobile;

    private ImageUrl imageUrl;

    public EnrolledUserDto() {
    }

    public EnrolledUserDto(Integer id, String username, String fname, String lname, String email, LocalDate dateofbirth, int postalcode, String address, String city, String municipality, String telephone, String mobile, ImageUrl imageUrl) {
        this.id = id;
        this.username = username;
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
        this.imageUrl = imageUrl;
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

    public ImageUrl getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(ImageUrl imageUrl) {
        this.imageUrl = imageUrl;
    }



    
    
    }
