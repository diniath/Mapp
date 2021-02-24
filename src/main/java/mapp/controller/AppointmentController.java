package mapp.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import mapp.converter.AppointmentDtoConverter;
import mapp.entity.Appointment;
import mapp.dto.AppointmentDto;
import mapp.service.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl service;
    
    @Autowired
    private AppointmentDtoConverter converter;
    
    @GetMapping
    public List<Appointment> getAppointments() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable(value = "id") Integer appointmentId) throws Exception {
        Optional<Appointment> optionalAppointment = service.findById(appointmentId);
        return optionalAppointment.orElseThrow(() -> new Exception("Appointment not exists with id:" + appointmentId));
    }

    @PostMapping
    public Appointment createAppointment(@Valid @RequestBody Appointment appointment) {
        return service.create(appointment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAppointmentById(@PathVariable(value = "id") Integer appointmentId) {
        service.delete(appointmentId);
        return ResponseEntity.ok("Appointment deleted successfully, ID:" + appointmentId);
    }

    @PutMapping("/{id}")
    public void updateAppointment(@PathVariable(value = "id") Integer appointmentId,
            @RequestBody Appointment newAppointmentDetails) throws Exception {
        Optional<Appointment> optionalAppointment = service.findById(appointmentId);
        optionalAppointment.orElseThrow(() -> new Exception("Appointment not exists with id:" + appointmentId));
        service.edit(newAppointmentDetails);
    }

    @GetMapping("/search/{id}")
    public List<Appointment> findByProductId(@PathVariable(value = "id") Integer id) {
        return service.findByProductId(id);
    }

    @GetMapping("/search/enrolledUser/{id}")
    public List<AppointmentDto> findByEnrolledUserId(@PathVariable(value = "id") Integer id) {
        List<Appointment> appointments = service.findByEnrolledUserId(id);
        return converter.entityToDto(appointments);
    } 
    
}
