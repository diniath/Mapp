/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.entity.Review;
import mapp.service.ReviewServiceImpl;
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
 * @review Hello Java !
 */
@RestController//@RestController = @Controller + @ResponseBody
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewServiceImpl service;

    
    @GetMapping
    public List<Review> getReviews() {
        return service.findAll();
    }

    @GetMapping("/{myvariable}")
    public Review getReviewById(@PathVariable(value = "myvariable") Integer reviewId) throws Exception {
        Optional<Review> optionalReview = service.findById(reviewId);
        return optionalReview.orElseThrow(() -> new Exception("Review not exists with id:" + reviewId));
        //return optionalReview.get();
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return service.create(review);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReviewById(@PathVariable(value = "id") Integer reviewId) {
        service.delete(reviewId);
        return ResponseEntity.ok("Review deleted successfully, ID:" + reviewId);
    }

    @PutMapping("/{id}")
    public void updateReview(@PathVariable(value = "id") Integer reviewId,
            @RequestBody Review newReviewDetails) throws Exception {
        Optional<Review> optionalReview = service.findById(reviewId);
        Review reviewToUpdate = optionalReview.orElseThrow(() -> new Exception("Review not exists with id:" + reviewId));
        
//        reviewToUpdate.setDay(newReviewDetails.getDay());
        service.edit(newReviewDetails);
    }
    
//    @GetMapping("/search/{address}")
//    public Review getReviewByAddress(@PathVariable(value = "address") String address){
//        return service.findReviewByAddress(address);
//    }

}
