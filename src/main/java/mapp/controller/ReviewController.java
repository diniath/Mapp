package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.converter.ReviewDtoConverter;
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
import mapp.dto.ReviewDto;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewServiceImpl service;

    @Autowired
    private ReviewDtoConverter converter;

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

    @DeleteMapping("/delete/{id}")
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
    public List<ReviewDto> findByProductId(@PathVariable(value = "id") Integer id) {
        List<Review> reviews = service.findByProductId(id);
        return converter.entityToDto(reviews);
    }

    @GetMapping("/search/company/{id}")
    public List<ReviewDto> findByCompanyId(@PathVariable(value = "id") Integer id) {
        List<Review> reviews = service.findByCompanyId(id);
        return converter.entityToDto(reviews);

    }
   
    @GetMapping("/search/enrolledUser/{id}")
    public List<ReviewDto> findByEnrolledUserId(@PathVariable(value = "id") Integer id) {
        List<Review> reviews = service.findByEnrolledUserId(id);
        return converter.entityToDto(reviews);
    }
}
