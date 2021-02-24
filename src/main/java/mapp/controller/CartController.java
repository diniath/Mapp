package mapp.controller;

import java.util.List;
import mapp.entity.wrapper.Cart;
import mapp.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
