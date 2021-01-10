
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.ProductDao;
import mapp.entity.ImageUrl;
import mapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProductServiceImpl{
    
    @Autowired
    private ProductDao dao;
    
    public List<Product> findAll() {
        return dao.findAll();
    }
    
    public Product create(Product product) {
        return dao.save(product);
    }
    
    public void edit(Product product) {
        dao.saveAndFlush(product);
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<Product> findById(int id) {
        Optional<Product> product = dao.findById(id);
        return product;
    }
    
//    public Product findProductByAddress(@PathVariable(value = "address") String address){
//        return dao.findByAddress(address);
//    }
}
