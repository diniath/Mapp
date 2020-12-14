/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.entity.Product;
import mapp.service.ProductServiceImpl;
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
 * @product Hello Java !
 */
@RestController//@RestController = @Controller + @ResponseBody
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    
    @GetMapping
    public List<Product> getProducts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(value = "id") Integer productId) throws Exception {
        Optional<Product> optionalProduct = service.findById(productId);
        return optionalProduct.orElseThrow(() -> new Exception("Product not exists with id:" + productId));
        //return optionalProduct.get();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.create(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductById(@PathVariable(value = "id") Integer productId) {
        service.delete(productId);
        return ResponseEntity.ok("Product deleted successfully, ID:" + productId);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable(value = "id") Integer productId,
            @RequestBody Product newProductDetails) throws Exception {
        Optional<Product> optionalProduct = service.findById(productId);
        Product productToUpdate = optionalProduct.orElseThrow(() -> new Exception("Product not exists with id:" + productId));
        newProductDetails.setId(productId);
//        productToUpdate.setDay(newProductDetails.getDay());
        service.edit(newProductDetails);
    }
    
//    @GetMapping("/search/{address}")
//    public Product getProductByAddress(@PathVariable(value = "address") String address){
//        return service.findProductByAddress(address);
//    }

}
