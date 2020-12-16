/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.entity.Appointment;
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

/**
 *
 * @appointment Hello Java !
 */
@RestController//@RestController = @Controller + @ResponseBody
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl service;
    
    @GetMapping
    public List<Appointment> getAppointments() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable(value = "id") Integer appointmentId) throws Exception {
        Optional<Appointment> optionalAppointment = service.findById(appointmentId);
        return optionalAppointment.orElseThrow(() -> new Exception("Appointment not exists with id:" + appointmentId));
        //return optionalAppointment.get();
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return service.create(appointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAppointmentById(@PathVariable(value = "id") Integer appointmentId) {
        service.delete(appointmentId);
        return ResponseEntity.ok("Appointment deleted successfully, ID:" + appointmentId);
    }

    @PutMapping("/{id}")
    public void updateAppointment(@PathVariable(value = "id") Integer appointmentId,
            @RequestBody Appointment newAppointmentDetails) throws Exception {
        Optional<Appointment> optionalAppointment = service.findById(appointmentId);
        Appointment appointmentToUpdate = optionalAppointment.orElseThrow(() -> new Exception("Appointment not exists with id:" + appointmentId));
        
//        appointmentToUpdate.setDay(newAppointmentDetails.getDay());
        service.edit(newAppointmentDetails);
    }
    
//    @GetMapping("/search/{address}")
//    public Appointment getAppointmentByAddress(@PathVariable(value = "address") String address){
//        return service.findAppointmentByAddress(address);
//    }

}
