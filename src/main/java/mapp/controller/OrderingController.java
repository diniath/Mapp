/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.entity.Ordering;
import mapp.service.OrderingServiceImpl;
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
 * @ordering Hello Java !
 */
@RestController//@RestController = @Controller + @ResponseBody
@RequestMapping("/ordering")
public class OrderingController {

    @Autowired
    private OrderingServiceImpl service;

    
    @GetMapping
    public List<Ordering> getOrderings() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Ordering getOrderingById(@PathVariable(value = "id") Integer orderingId) throws Exception {
        Optional<Ordering> optionalOrdering = service.findById(orderingId);
        return optionalOrdering.orElseThrow(() -> new Exception("Ordering not exists with id:" + orderingId));
        //return optionalOrdering.get();
    }

    @PostMapping
    public Ordering createOrdering(@RequestBody Ordering ordering) {
        return service.create(ordering);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrderingById(@PathVariable(value = "id") Integer orderingId) {
        service.delete(orderingId);
        return ResponseEntity.ok("Ordering deleted successfully, ID:" + orderingId);
    }

    @PutMapping("/{id}")
    public void updateOrdering(@PathVariable(value = "id") Integer orderingId,
            @RequestBody Ordering newOrderingDetails) throws Exception {
        Optional<Ordering> optionalOrdering = service.findById(orderingId);
        Ordering orderingToUpdate = optionalOrdering.orElseThrow(() -> new Exception("Ordering not exists with id:" + orderingId));
        
//        orderingToUpdate.setDay(newOrderingDetails.getDay());
        service.edit(newOrderingDetails);
    }
    
//    @GetMapping("/search/{address}")
//    public Ordering getOrderingByAddress(@PathVariable(value = "address") String address){
//        return service.findOrderingByAddress(address);
//    }

}
