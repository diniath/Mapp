package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.ReviewDao;
import mapp.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewServiceImpl {

    @Autowired
    private ReviewDao dao;

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private EnrolledUserServiceImpl enrolledUserService;

    public List<Review> findAll() {
        return dao.findAll();
    }

    // this dynamically updates rating
    public Review create(Review review) {
        setProductRating(review);
        setCompanyRating(review);
        Review newReview = dao.save(review);
        return newReview;
    }

    public void edit(Review review) {
        dao.saveAndFlush(review);
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<Review> findById(int id) {
        Optional<Review> review = dao.findById(id);
        return review;
    }

    public List<Review> findByProductId(Integer id) {
        return dao.findByProductId(id);
    }

    public List<Review> findByCompanyId(Integer id) {
        return dao.findByCompanyId(id);
    }

    public List<Review> findByEnrolledUserId(Integer id) {
        return dao.findByEnrolledUserId(id);
    }

    private void setProductRating(Review review) {
        List<Review> reviewList = dao.findByProductId(review.getProduct().getId());
        int sum = review.getProductRating();
        for (Review r : reviewList) {
            sum += r.getProduct().getRating();
        }
        Integer rating = (Integer) (sum / (reviewList.size() + 1));
        review.getProduct().setRating(rating);
    }

    private void setCompanyRating(Review review) {
        List<Review> reviewList = dao.findByCompanyId(review.getProduct().getId());
        int sum = review.getCompanyRating();
        for (Review r : reviewList) {
            sum += r.getCompany().getRating();
        }
        Integer rating = (Integer) (sum / (reviewList.size() + 1));
        review.getCompany().setRating(rating);
    }
}
