package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.CompanyDao;
import mapp.entity.Company;
import mapp.entity.Role;
import mapp.converter.CompanyUpdateConverter;
import mapp.dto.CompanyUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Transactional
public class CompanyServiceImpl {

    @Autowired
    private CompanyDao dao;

    @Autowired
    private ImageUrlServiceImpl service;

    @Autowired
    private CompanyUpdateConverter converter;

    public List<Company> findAll() {
        return dao.findAll();
    }

    // This method prevents a company to be saved as ADMIN (or User)
    public Company create(Company company) {
        Company createdCompany = null;
        if (company.getRoleList().size() == 1) {
            Role role = company.getRoleList().get(0);
            if (role.getId() == 2) {
                createdCompany = dao.save(company);
            }
        }
        return createdCompany;
    }

    // supports update operation 
    // to prevent list of entities from being deleted
    public void edit(Company company) {
        CompanyUpdateDto dto = converter.entityToDto(company);

        dao.setCompanyInfoById(
                dto.getUsername(), dto.getPassword(), dto.getCname(), dto.getEmail(),
                dto.getPostalCode(), dto.getAddress(), dto.getCity(), dto.getMunicipality(),
                dto.getTelephone(), dto.getMobile(), dto.getVatnumber(), dto.getVatservice(),
                dto.getDescription(), dto.getRepresentative(), dto.getIban(), dto.getRating(),
                dto.getProfile(), dto.getId()
        );

        // change imageUrl *** ***  
        if (!(company.getImageUrl().getUrl() == null)) {
            service.edit(company.getImageUrl());
        }

    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<Company> findById(int id) {
        Optional<Company> company = dao.findById(id);
        return company;
    }

    public Company findCompanyByAddress(@PathVariable(value = "address") String address) {
        return dao.findByAddress(address);
    }

    public Optional<Company> findCompanyByUsername(String username) {
        return dao.findByUsername(username);
    }

}
