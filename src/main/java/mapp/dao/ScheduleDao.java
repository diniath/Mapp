
package mapp.dao;

import mapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ScheduleDao extends JpaRepository<Schedule, Integer>{

    public List<Schedule> findByCompanyId(Integer id);
    
}
