
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


@RestController
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
        optionalReview.orElseThrow(() -> new Exception("Review not exists with id:" + reviewId));
        service.edit(newReviewDetails);
    }

    @GetMapping("/search/product/{id}")
    public List<Review> findByProductId(@PathVariable(value = "id") Integer id) {
        return service.findByProductId(id);
    }

    @GetMapping("/search/company/{id}")
    public List<Review> findByCompanyId(@PathVariable(value = "id") Integer id) {
        return service.findByCompanyId(id);
    }

    @GetMapping("/search/enrolledUser/{id}")
    public List<Review> findByEnrolledUserId(@PathVariable(value = "id") Integer id) {
        return service.findByEnrolledUserId(id);
    }
}
