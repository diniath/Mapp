
package mapp.dao;

import mapp.entity.Orderlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderlistDao extends JpaRepository<Orderlist, Integer>{

//    @Query("Select c FROM Orderlist c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public Orderlist findByAddress(@Param("address") String address);
    
}
