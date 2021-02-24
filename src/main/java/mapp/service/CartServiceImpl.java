

package mapp.service;


import mapp.entity.wrapper.Cart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import mapp.dao.ProductDao;
import mapp.entity.Appointment;
import mapp.entity.Ordering;
import mapp.entity.Orderlist;
import mapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;




@Service
@Transactional
public class CartServiceImpl {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @Autowired
    private OrderlistServiceImpl orderlistService;

    @Autowired
    private OrderingServiceImpl orderingService;
    
    
    @Autowired
    private ProductDao productDao;

    public void saveCarts(List<Cart> carts) {
        
       
        
        byte length = (byte) carts.size();
        Cart cart = null;
        for (byte i = 0; i < length; i++) {
            cart = carts.get(i);
            
            Product productFromDB = productDao.findById(cart.getProduct().getId()).get(); // company from cart is not valid, so we pass the correct value here.                     
                     
            Ordering ordering = orderingService.create(cart.getOrdering());

            Orderlist orderlist = new Orderlist();
            orderlist.setOrdering(ordering);
            orderlist.setProduct(cart.getProduct());
            orderlist = orderlistService.create(orderlist);

            Appointment appointment = new Appointment();
            appointment.setOrderlist(orderlist);
            appointment.setCompany(productFromDB.getCompany());
            appointment.setEnddate(cart.getEndDate());
            appointment.setStartdate(cart.getStartDate());
            appointment.setAppointmentDate(cart.getAppointmentDate());
            appointment.setProduct(cart.getProduct());
            appointment.setEnrolledUser(cart.getOrdering().getEnrolledUser());
            appointment = appointmentService.create(appointment);


        }
    }

}
