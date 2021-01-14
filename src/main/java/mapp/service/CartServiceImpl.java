

package mapp.service;

import java.util.ArrayList;
import mapp.entity.wrapper.Cart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import mapp.entity.Appointment;
import mapp.entity.EnrolledUser;
import mapp.entity.Ordering;
import mapp.entity.Orderlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;



@Service
@Transactional
public class CartServiceImpl {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @Autowired
    private OrderlistServiceImpl orderlistService;

    @Autowired
    private OrderingServiceImpl orderingService;

    public void saveCarts(List<Cart> carts) {

        byte length = (byte) carts.size();
        Cart cart = null;
        for (byte i = 0; i < length; i++) {
            cart = carts.get(i);

            Ordering ordering = orderingService.create(cart.getOrdering());

            Orderlist orderlist = new Orderlist();
            orderlist.setOrdering(ordering);
            orderlist.setProduct(cart.getProduct());
            orderlist = orderlistService.create(orderlist);

            Appointment appointment = new Appointment();
            appointment.setOrderlist(orderlist);
            appointment.setCompany(cart.getCompany());
            appointment.setEnddate(cart.getEndDate());
            appointment.setStartdate(cart.getStartDate());
            appointment.setAppointmentDate(cart.getAppointmentDate());
            appointment.setProduct(cart.getProduct());
            appointment.setEnrolledUser(cart.getOrdering().getEnrolledUser());
            appointment = appointmentService.create(appointment);

//            List<EnrolledUser> enrolledUsers = new ArrayList();
//            enrolledUsers.add(cart.getOrdering().getEnrolledUser());

        }
    }

}
