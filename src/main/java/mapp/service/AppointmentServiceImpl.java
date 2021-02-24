package mapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mapp.dao.AppointmentDao;
import mapp.dao.ProductDao;
import mapp.entity.Appointment;
import mapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppointmentServiceImpl {

    @Autowired
    private AppointmentDao dao;

    @Autowired
    private ProductDao pdao;

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

    public List<Appointment> findByProductId(Integer id) {
        return dao.findByProductId(id);
    }

    public List<Appointment> findByEnrolledUserId(Integer id) {
        return dao.findByEnrolledUserId(id);
    }

}
