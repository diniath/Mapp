/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.dto;

/**
 *
 * @author Hello Java !
 */
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import mapp.entity.Appointment;
import mapp.entity.ImageUrl;
import mapp.entity.Ordering;
import mapp.entity.Product;
import mapp.entity.Role;


//@Data
public class EnrolledUserDto {
    
    private static final long serialVersionUID = 1L;
   
    private Integer id;

    private String username;
 
    private String fname;
    
    private String lname;

//    private String email;
// 
//    private LocalDate dateofbirth;
// 
//    private int postalcode;
//
//    private String address;
//
//    private String city;
//
//    private String municipality;
//   
//    private int telephone;
//
//    private int mobile;

    private ImageUrl imageUrl;

    public EnrolledUserDto(Integer id, String username, String fname, String lname, ImageUrl imageUrl) {
        this.id = id;
        this.username = username;
        this.fname = fname;
        this.lname = lname;
        this.imageUrl = imageUrl;
    }

    
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public ImageUrl getImageUrl() {
        return imageUrl;
    }

    
    
    }
