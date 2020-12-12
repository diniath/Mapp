
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.CompanyDao;
import mapp.entity.Company;
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
    
    public Company create(Company company) {
        Company comp = dao.save(company);
        return comp;
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
