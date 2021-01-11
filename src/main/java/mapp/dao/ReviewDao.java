
package mapp.dao;

import java.util.List;
import mapp.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewDao extends JpaRepository<Review, Integer>{

    public List<Review> findByProductId(Integer Id);

    public List<Review> findByCompanyId(Integer Id);
  
    public List<Review> findByEnrolledUserId(Integer Id);

}
