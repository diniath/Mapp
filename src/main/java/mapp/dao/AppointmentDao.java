package mapp.dao;

import mapp.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Integer> {

    public List<Appointment> findByProductId(Integer Id);

    public List<Appointment> findByEnrolledUserId(Integer id);

}
