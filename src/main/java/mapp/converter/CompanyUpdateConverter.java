package mapp.converter;


import mapp.dto.CompanyUpdateDto;
import mapp.entity.Company;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CompanyUpdateConverter {

    public CompanyUpdateDto entityToDto(Company company) {

        ModelMapper mapper = new ModelMapper();
        CompanyUpdateDto map = mapper.map(company, CompanyUpdateDto.class);
        return map;
    }

}
