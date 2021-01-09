
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.CompanyDao;
import mapp.entity.Company;
import mapp.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Transactional
public class CompanyServiceImpl{
    
    @Autowired
    private CompanyDao dao;
    
    public List<Company> findAll() {
        return dao.findAll();
    }
    
//    public Company create(Company company) {
//        Company comp = dao.save(company);
//        return comp;
//    }

    // This method prevents an company to be saved as ADMIN (or Company)
    public Company create(Company company) {
        Company createdCompany = null;
        if (company.getRoleList().size() == 1) {
            Role role = company.getRoleList().get(0);
//            System.out.println(role);
            if (role.getId() == 2) {
                createdCompany = dao.save(company);
            }
        }
        return createdCompany;
    }

    // supports update operation 
    // to prevent list of entities from being deleted
    public void edit(Company company) {
        String username = company.getUsername();
        String password = company.getPassword();
        String cname = company.getCname();
        String email = company.getEmail();
        Integer postalcode = company.getPostalcode();
        String address = company.getAddress();
        String city = company.getCity();
        String municipality = company.getMunicipality();
        String telephone = company.getTelephone();
        String mobile = company.getMobile();
        String vatnumber = company.getVatnumber();
        String vatservice = company.getVatservice();        
        String description = company.getDescription();
        String representative = company.getRepresentative();         
        String iban = company.getIban();         
        Integer rating = company.getRating();
        String profile = company.getProfile();         
        Integer id = company.getId();

        dao.setCompanyInfoById(
             username,  password,  cname,  email,
             postalcode,  address,  city,  municipality, 
             telephone,  mobile,  vatnumber,  vatservice,
             description,  representative,  iban,  rating,
             profile, 
             id
        );
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<Company> findById(int id) {
        Optional<Company> company = dao.findById(id);
        return company;
    }
    
    public Company findCompanyByAddress(@PathVariable(value = "address") String address){
        return dao.findByAddress(address);
    }
}
