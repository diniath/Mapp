
package mapp.service;

import java.util.List;
import mapp.dao.CompanyDao;
import mapp.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyService extends SuperService<Company> {
    
//    να φερουμε το 
    @Autowired
    private CompanyDao adao;
    
    @Override
    public List<Company> findAll() {
        return adao.findAll();
    }
    
    @Override
    public Company create(Company company) {
        Company comp = adao.save(company);
        return comp;
    }
    
    @Override
    public void edit(Company company) {
        adao.update(company);
    }

    @Override
    public String delete(int id) {
        return adao.remove(id);
    }

    @Override
    public Company findById(int id) {
        Company company = adao.findById(id);
        return company;
    }
}
