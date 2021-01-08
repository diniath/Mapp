
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

    // This method prevents an enrolledUser to be saved as ADMIN (or Company)
    public Company create(Company company) {
        Company createdCompany = null;
        if (company.getRoleList().size() == 1) {
            Role role = company.getRoleList().get(1);
//            System.out.println(role);
            if (role.getId() == 2) {
                createdCompany = dao.save(company);
            }
        }
        return createdCompany;
    }

    
    public void edit(Company company) {
        dao.saveAndFlush(company);
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
