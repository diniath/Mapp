
package mapp.converter;

import mapp.entity.Company;
import mapp.dto.CompanySearchDto;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;


@Component
public class CompanySearchConverter {

    public CompanySearchDto entityToDto(Company company) {

        ModelMapper mapper = new ModelMapper();
        CompanySearchDto map = mapper.map(company, CompanySearchDto.class);
        return map;
    }

    public List<CompanySearchDto> entityToDto(List<Company> company) {

        return company.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }

}
