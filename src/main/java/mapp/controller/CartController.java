/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mapp.entity.Appointment;
import mapp.entity.EnrolledUser;
import mapp.entity.Ordering;
import mapp.entity.Orderlist;
import mapp.entity.wrapper.Cart;
import mapp.service.AppointmentServiceImpl;
import mapp.service.EnrolledUserServiceImpl;
import mapp.service.OrderingServiceImpl;
import mapp.service.OrderlistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hello Java !
 */
@RestController//@RestController = @Controller + @ResponseBody
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @Autowired
    private OrderlistServiceImpl orderlistService;

    @Autowired
    private EnrolledUserServiceImpl enrolledUserService;

        @Autowired
    private OrderingServiceImpl orderingService;
    
    @PostMapping
    public Cart manageCart(@RequestBody Cart cart ) throws Exception {
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
        List<EnrolledUser> enrolledUsers = new ArrayList();

        appointment.setEnrolledUserList(enrolledUsers);

//        List<Appointment> appointments = new ArrayList();
        
        appointment = appointmentService.create(appointment);
        
//        appointments.add(appointmentService.create(appointment));
        
        
        
//        Optional<EnrolledUser> optionalEnrolledUser = enrolledUserService.findById(cart.getOrdering().getEnrolledUser().getId());
//        EnrolledUser enrolledUser = optionalEnrolledUser.orElseThrow(() -> new Exception("OYAAA not exists with id:"));
        
//        enrolledUser.setAppointmentList(appointments);
//        enrolledUserService.create(enrolledUser);
        
    return cart;}    
    
    
    
}
