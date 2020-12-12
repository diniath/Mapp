
package mapp.dao;

import mapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ScheduleDao extends JpaRepository<Schedule, Integer>{

//    @Query("Select c FROM Schedule c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public Schedule findByAddress(@Param("address") String address);
    
}
