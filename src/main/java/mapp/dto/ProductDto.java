package mapp.dto;

import lombok.Data;

@Data
public class ProductDto {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String productProfile;

    private String productDescription;

    private Integer companyId;

    private String companyProfile;

}
