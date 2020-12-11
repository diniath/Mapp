
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.CompanyDao;
import mapp.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Transactional
public class CompanyServiceImpl{
    
    @Autowired
    private CompanyDao cdao;
    
    public List<Company> findAll() {
        return cdao.findAll();
    }
    
    public Company create(Company company) {
        Company comp = cdao.save(company);
        return comp;
    }
    
    public void edit(Company company) {
        cdao.saveAndFlush(company);
    }

    public void delete(int id) {
        cdao.deleteById(id);
    }

    public Optional<Company> findById(int id) {
        Optional<Company> company = cdao.findById(id);
        return company;
    }
    
    public Company findCompanyByAddress(@PathVariable(value = "address") String address){
        return cdao.findByAddress(address);
    }
}
