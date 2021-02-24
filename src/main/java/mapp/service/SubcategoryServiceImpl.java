
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.SubcategoryDao;
import mapp.entity.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SubcategoryServiceImpl{
    
    @Autowired
    private SubcategoryDao dao;
    
    public List<Subcategory> findAll() {
        return dao.findAll();
    }
    
    public Subcategory create(Subcategory subcategory) {
        Subcategory subcat = dao.save(subcategory);
        return subcat;
    }
    
    public void edit(Subcategory subcategory) {
        dao.saveAndFlush(subcategory);
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<Subcategory> findById(int id) {
        Optional<Subcategory> subcategory = dao.findById(id);
        return subcategory;
    }
    
//    public Subcategory findSubcategoryByAddress(@PathVariable(value = "address") String address){
//        return dao.findByAddress(address);
//    }
}
