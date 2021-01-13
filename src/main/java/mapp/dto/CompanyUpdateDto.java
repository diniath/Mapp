
package mapp.dto;


import lombok.Data;

@Data
public class CompanyUpdateDto {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String password;
    
    private String cname;

    private String email;

    private String address;

    private String city;

    private String municipality;

    private String telephone;

    private String mobile;

    private String vatnumber;

    private String vatservice;

    private String description;

    private String representative;

    private String iban;

    private Integer rating;

    private String profile;
    
    private int postalCode;
       
}
