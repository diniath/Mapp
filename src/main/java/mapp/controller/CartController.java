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
import mapp.service.CartServiceImpl;
import mapp.service.EnrolledUserServiceImpl;
import mapp.service.OrderingServiceImpl;
import mapp.service.OrderlistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private CartServiceImpl service;
    
    @PostMapping
    public ResponseEntity manageCart(@RequestBody List<Cart> carts) throws Exception {
        service.saveCarts(carts);

        return ResponseEntity.ok("Cart saved successfully!");
    }
}
