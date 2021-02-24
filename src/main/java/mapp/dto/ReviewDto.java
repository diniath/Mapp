package mapp.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ReviewDto {

    private LocalDate ratingDate;

    private short productRating;

    private String productComment;

    private String productProfile;

    private String companyProfile;

    private String username;

}
