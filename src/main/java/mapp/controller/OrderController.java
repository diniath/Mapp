/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.entity.Order;
import mapp.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @order Hello Java !
 */
@RestController//@RestController = @Controller + @ResponseBody
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl service;

    
    @GetMapping
    public List<Order> getOrders() {
        return service.findAll();
    }

    @GetMapping("/{myvariable}")
    public Order getOrderById(@PathVariable(value = "myvariable") Integer orderId) throws Exception {
        Optional<Order> optionalOrder = service.findById(orderId);
        return optionalOrder.orElseThrow(() -> new Exception("Order not exists with id:" + orderId));
        //return optionalOrder.get();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.create(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrderById(@PathVariable(value = "id") Integer orderId) {
        service.delete(orderId);
        return ResponseEntity.ok("Order deleted successfully, ID:" + orderId);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable(value = "id") Integer orderId,
            @RequestBody Order newOrderDetails) throws Exception {
        Optional<Order> optionalOrder = service.findById(orderId);
        Order orderToUpdate = optionalOrder.orElseThrow(() -> new Exception("Order not exists with id:" + orderId));
        
//        orderToUpdate.setDay(newOrderDetails.getDay());
        service.edit(newOrderDetails);
    }
    
//    @GetMapping("/search/{address}")
//    public Order getOrderByAddress(@PathVariable(value = "address") String address){
//        return service.findOrderByAddress(address);
//    }

}
