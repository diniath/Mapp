
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.OrderDao;
import mapp.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Transactional
public class OrderServiceImpl{
    
    @Autowired
    private OrderDao dao;
    
    public List<Order> findAll() {
        return dao.findAll();
    }
    
    public Order create(Order order) {
        Order comp = dao.save(order);
        return comp;
    }
    
    public void edit(Order order) {
        dao.saveAndFlush(order);
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<Order> findById(int id) {
        Optional<Order> order = dao.findById(id);
        return order;
    }
    
//    public Order findOrderByAddress(@PathVariable(value = "address") String address){
//        return dao.findByAddress(address);
//    }
}
