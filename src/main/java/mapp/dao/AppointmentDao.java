
package mapp.dao;

import mapp.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Integer>{

//    @Query("Select c FROM Appointment c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public Appointment findByAddress(@Param("address") String address);
    
}
