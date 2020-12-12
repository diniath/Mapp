
package mapp.dao;

import mapp.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceDao extends JpaRepository<Service, Integer> {

//    @Query("Select c FROM Service c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public Service findByAddress(@Param("address") String address);
    
}
