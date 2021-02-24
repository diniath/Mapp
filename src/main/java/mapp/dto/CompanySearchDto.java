
package mapp.dto;


import lombok.Data;
import mapp.entity.Product;
import java.util.List;


@Data
public class CompanySearchDto {
    
    private static final long serialVersionUID = 1L;

    private Integer id; 
    
    private String cname; 
    
    private String address; 
    
    private String description; 
    
    private String profile; 
    
    private List<Product> productList;
}
