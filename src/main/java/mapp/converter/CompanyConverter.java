/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.converter;

import mapp.entity.Company;
import mapp.dto.CompanyDto;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 *
 * @author Hello Java !
 */
@Component
public class CompanyConverter {

    public CompanyDto entityToDto(Company company) {

        ModelMapper mapper = new ModelMapper();
        CompanyDto map = mapper.map(company, CompanyDto.class);
        return map;
    }

    public List<CompanyDto> entityToDto(List<Company> company) {

        return company.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }

    public Company dtoToEntity(CompanyDto dto) {
        ModelMapper mapper = new ModelMapper();
        Company map = mapper.map(dto, Company.class);
        return map;
    }

    public List<Company> dtoToEntity(List<CompanyDto> dto) {

        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
