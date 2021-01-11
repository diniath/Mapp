
package mapp.converter;

import java.util.List;
import java.util.stream.Collectors;
import mapp.dto.CompanyDto;
import mapp.entity.Company;
import mapp.entity.ImageUrl;
import mapp.service.ImageUrlServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CompanyConverter {

    @Autowired
    private ImageUrlServiceImpl service;

    public CompanyDto entityToDto(Company company) {

                ModelMapper mapper = new ModelMapper();
        CompanyDto map = mapper.map(company, CompanyDto.class);
        return map;
        
//        CompanyDto dto = new CompanyDto();
//        dto.setId(company.getId());
//        dto.setUsername(company.getUsername());
//        dto.setCname(company.getCname());
//        dto.setVatnumber(company.getVatnumber());
//        dto.setVatservice(company.getVatservice());
//        dto.setIban(company.getIban());
//        dto.setDescription(company.getDescription());
//        dto.setProfile(company.getProfile());
//        dto.setRepresentative(company.getRepresentative());
//        dto.setEmail(company.getEmail());
//        dto.setAddress(company.getAddress());
//        dto.setCity(company.getCity());
//        dto.setMunicipality(company.getMunicipality());
//        dto.setTelephone(company.getTelephone());
//        dto.setMobile(company.getMobile());
//        dto.setPostalCode(company.getPostalcode());
//
//        Integer id = company.getImageUrl().getId();
//        ImageUrl img = service.findById(id).get();
//        dto.setImageUrl(img);
//
//        return dto;
    }

    public List<CompanyDto> entityToDto(List<Company> company) {

        return company.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }

    public Company dtoToEntity(CompanyDto dto) {
//		Company st = new Company();
//		st.setId(dto.getId());
//		st.setName(dto.getName());
//		st.setPassword(dto.getPassword());
//		st.setUsername(dto.getUsername());
//		
//		return st;

        ModelMapper mapper = new ModelMapper();
        Company map = mapper.map(dto, Company.class);
        return map;
    }

    public List<Company> dtoToEntity(List<CompanyDto> dto) {

        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
