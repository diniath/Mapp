package mapp.converter;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import mapp.dto.ReviewDto;
import mapp.entity.Review;

@Component
public class ReviewDtoConverter {

    public ReviewDto entityToDto(Review review) {
        ReviewDto dto = new ReviewDto();
        dto.setRatingDate(review.getRatingDate());
        dto.setProductRating(review.getProductRating());
        dto.setProductComment(review.getProductComment());
        dto.setProductProfile(review.getProduct().getProfile());
        dto.setCompanyProfile(review.getCompany().getProfile());
        dto.setUsername(review.getEnrolledUser().getUsername());
        return dto;
    }

    public List<ReviewDto> entityToDto(List<Review> review) {
        return review.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

}
