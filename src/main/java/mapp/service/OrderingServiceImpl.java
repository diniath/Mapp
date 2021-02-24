
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.OrderingDao;
import mapp.entity.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;


@Service
@Transactional
public class OrderingServiceImpl{
    
    @Autowired
    private OrderingDao dao;
    
    public List<Ordering> findAll() {
        return dao.findAll();
    }
    
    public Ordering create(Ordering ordering) {
        Ordering comp = dao.save(ordering);
        return comp;
    }
    
    public void edit(Ordering ordering) {
        dao.saveAndFlush(ordering);
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<Ordering> findById(int id) {
        Optional<Ordering> ordering = dao.findById(id);
        return ordering;
    }
    
    public List<Ordering> findAllOrderingByEnrolledUserId(@PathVariable(value = "id") Integer id){
        return dao.findByEnrolledUserId(id);
    }
    
}
