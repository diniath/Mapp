
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.AppointmentDao;
import mapp.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Transactional
public class ServiceServiceImpl{
    
    @Autowired
    private AppointmentDao dao;
    
    public List<Appointment> findAll() {
        return dao.findAll();
    }
    
    public Appointment create(Appointment appointment) {
        Appointment comp = dao.save(appointment);
        return comp;
    }
    
    public void edit(Appointment appointment) {
        dao.saveAndFlush(appointment);
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<Appointment> findById(int id) {
        Optional<Appointment> appointment = dao.findById(id);
        return appointment;
    }
    
//    public Appointment findAppointmentByAddress(@PathVariable(value = "address") String address){
//        return dao.findByAddress(address);
//    }
}
