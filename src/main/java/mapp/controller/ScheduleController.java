/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.entity.Schedule;
import mapp.service.ScheduleServiceImpl;
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
 * @schedule Hello Java !
 */
@RestController//@RestController = @Controller + @ResponseBody
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleServiceImpl service;

    
    @GetMapping
    public List<Schedule> getSchedules() {
        return service.findAll();
    }

    @GetMapping("/{myvariable}")
    public Schedule getScheduleById(@PathVariable(value = "myvariable") Integer scheduleId) throws Exception {
        Optional<Schedule> optionalSchedule = service.findById(scheduleId);
        return optionalSchedule.orElseThrow(() -> new Exception("Schedule not exists with id:" + scheduleId));
        //return optionalSchedule.get();
    }

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return service.create(schedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteScheduleById(@PathVariable(value = "id") Integer scheduleId) {
        service.delete(scheduleId);
        return ResponseEntity.ok("Schedule deleted successfully, ID:" + scheduleId);
    }

    @PutMapping("/{id}")
    public void updateSchedule(@PathVariable(value = "id") Integer scheduleId,
            @RequestBody Schedule newScheduleDetails) throws Exception {
        Optional<Schedule> optionalSchedule = service.findById(scheduleId);
        Schedule scheduleToUpdate = optionalSchedule.orElseThrow(() -> new Exception("Schedule not exists with id:" + scheduleId));
        
//        scheduleToUpdate.setDay(newScheduleDetails.getDay());
        service.edit(newScheduleDetails);
    }
    
//    @GetMapping("/search/{address}")
//    public Schedule getScheduleByAddress(@PathVariable(value = "address") String address){
//        return service.findScheduleByAddress(address);
//    }

}
