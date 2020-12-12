
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.CategoryDao;
import mapp.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl{
    
    @Autowired
    private CategoryDao dao;
    
    public List<Category> findAll() {
        return dao.findAll();
    }
    
    public Category create(Category category) {
        Category comp = dao.save(category);
        return comp;
    }
    
    public void edit(Category category) {
        dao.saveAndFlush(category);
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<Category> findById(int id) {
        Optional<Category> category = dao.findById(id);
        return category;
    }
    
//    public Category findCategoryByAddress(@PathVariable(value = "address") String address){
//        return dao.findByAddress(address);
//    }
}
