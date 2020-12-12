
package mapp.dao;

import mapp.entity.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderingDao extends JpaRepository<Ordering, Integer>{

//    @Query("Select c FROM Order c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public Order findByAddress(@Param("address") String address);
    
}
