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
import lombok.Data;

@Data
public class CompanyDto {
    
    private static final long serialVersionUID = 1L;

    private Integer id; 
    
    private String cname; 
    
    private String description; 
    
    private String profile; 
    
    
}
