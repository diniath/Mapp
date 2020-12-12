
package mapp.dao;

import mapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{

//    @Query("Select c FROM Order c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public Order findByAddress(@Param("address") String address);
    
}
