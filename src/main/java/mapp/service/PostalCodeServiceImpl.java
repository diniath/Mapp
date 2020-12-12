
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.PostalCodeDao;
import mapp.entity.PostalCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PostalCodeServiceImpl{
    
    @Autowired
    private PostalCodeDao dao;
    
    public List<PostalCode> findAll() {
        return dao.findAll();
    }
    
    public PostalCode create(PostalCode postalCode) {
        PostalCode comp = dao.save(postalCode);
        return comp;
    }
    
    public void edit(PostalCode postalCode) {
        dao.saveAndFlush(postalCode);
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<PostalCode> findById(int id) {
        Optional<PostalCode> postalCode = dao.findById(id);
        return postalCode;
    }
    
//    public PostalCode findPostalCodeByAddress(@PathVariable(value = "address") String address){
//        return dao.findByAddress(address);
//    }
}
