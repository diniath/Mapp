package mapp.converter;

import java.util.List;
import java.util.stream.Collectors;
import mapp.dto.CompanyDto;
import mapp.entity.Company;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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
