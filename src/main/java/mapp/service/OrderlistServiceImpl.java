
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.OrderlistDao;
import mapp.entity.Orderlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class OrderlistServiceImpl{
    
    @Autowired
    private OrderlistDao dao;
    
    public List<Orderlist> findAll() {
        return dao.findAll();
    }
    
    public Orderlist create(Orderlist orderlist) {
        Orderlist comp = dao.save(orderlist);
        return comp;
    }
    
    public void edit(Orderlist orderlist) {
        dao.saveAndFlush(orderlist);
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<Orderlist> findById(int id) {
        Optional<Orderlist> orderlist = dao.findById(id);
        return orderlist;
    }
    
//    public Orderlist findOrderlistByAddress(@PathVariable(value = "address") String address){
//        return dao.findByAddress(address);
//    }
}
