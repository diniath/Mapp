/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.converter;

import java.util.stream.Collectors;
import mapp.dto.ProductDto;
import mapp.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 *
 * @author Hello Java !
 */
@Component
public class ProductConverter {

    public ProductDto entityToDto(Product product) {

        ModelMapper mapper = new ModelMapper();
        ProductDto map = mapper.map(product, ProductDto.class);
        return map;
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