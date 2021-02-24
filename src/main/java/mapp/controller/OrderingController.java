package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.converter.OrderingDtoConverter;
import mapp.entity.Ordering;
import mapp.dto.OrderingDto;
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

@RestController
@RequestMapping("/ordering")
public class OrderingController {

    @Autowired
    private OrderingServiceImpl service;

    @Autowired
    private OrderingDtoConverter converter;

    @GetMapping
    public List<Ordering> getOrderings() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Ordering getOrderingById(@PathVariable(value = "id") Integer orderingId) throws Exception {
        Optional<Ordering> optionalOrdering = service.findById(orderingId);
        return optionalOrdering.orElseThrow(() -> new Exception("Ordering not exists with id:" + orderingId));
    }

    @PostMapping
    public Ordering createOrdering(@RequestBody Ordering ordering) {
        return service.create(ordering);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrderingById(@PathVariable(value = "id") Integer orderingId) {
        service.delete(orderingId);
        return ResponseEntity.ok("Ordering deleted successfully, ID:" + orderingId);
    }

    @PutMapping("/{id}")
    public void updateOrdering(@PathVariable(value = "id") Integer orderingId,
            @RequestBody Ordering newOrderingDetails) throws Exception {
        Optional<Ordering> optionalOrdering = service.findById(orderingId);
        optionalOrdering.orElseThrow(() -> new Exception("Ordering not exists with id:" + orderingId));
        service.edit(newOrderingDetails);
    }

    @GetMapping("/search/{id}")
    public List<List<OrderingDto>> getOrderingByAddress(@PathVariable(value = "id") Integer id) {
        List<Ordering> orderings = service.findAllOrderingByEnrolledUserId(id);
        return converter.entityToDto(orderings);
    }

}
