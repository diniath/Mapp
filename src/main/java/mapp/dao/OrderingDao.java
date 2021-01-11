
package mapp.dao;

import mapp.entity.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface OrderingDao extends JpaRepository<Ordering, Integer>{
  
   public List<Ordering> findByEnrolledUserId(Integer id);

}
