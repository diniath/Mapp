
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
public class ReviewServiceImpl{
    
    @Autowired
    private ReviewDao dao;
    
    public List<Review> findAll() {
        return dao.findAll();
    }
    
    public Review create(Review review) {
        Review comp = dao.save(review);
        return comp;
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
    
//    public Review findReviewByAddress(@PathVariable(value = "address") String address){
//        return dao.findByAddress(address);
//    }
}
