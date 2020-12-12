
package mapp.dao;

import mapp.entity.EnrolledUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnrolledUserDao extends JpaRepository<EnrolledUser, Integer>{

//    @Query("Select c FROM EnrolledUser c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public EnrolledUser findByAddress(@Param("address") String address);
    
}
