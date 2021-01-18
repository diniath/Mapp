package mapp.converter;

import java.util.stream.Collectors;
import mapp.dto.ProductDto;
import mapp.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProductConverter {

    public ProductDto entityToDto(Product product) {

        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setProductDescription(product.getDescription());
        dto.setProductProfile(product.getProfile());
        dto.setCompanyId(product.getCompany().getId());
        dto.setCompanyProfile(product.getCompany().getProfile());
        return dto;
    }

    public List<ProductDto> entityToDto(List<Product> product) {
        return product.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public Product dtoToEntity(ProductDto dto) {
        ModelMapper mapper = new ModelMapper();
        Product map = mapper.map(dto, Product.class);
        return map;
    }

    public List<Product> dtoToEntity(List<ProductDto> dto) {

        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
