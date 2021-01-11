
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.ScheduleDao;
import mapp.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScheduleServiceImpl{
    
    @Autowired
    private ScheduleDao dao;
    
    public List<Schedule> findAll() {
        return dao.findAll();
    }
    
    public Schedule create(Schedule schedule) {
        Schedule comp = dao.save(schedule);
        return comp;
    }
    
    public void edit(Schedule schedule) {
        dao.saveAndFlush(schedule);
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<Schedule> findById(int id) {
        Optional<Schedule> schedule = dao.findById(id);
        return schedule;
    }
    
    public List<Schedule> findScheduleByCompanyId(Integer id){
        return dao.findByCompanyId(id);
    }
    
}
