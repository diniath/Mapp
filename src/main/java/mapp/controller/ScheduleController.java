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

@RestController
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
    }

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return service.create(schedule);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteScheduleById(@PathVariable(value = "id") Integer scheduleId) {
        service.delete(scheduleId);
        return ResponseEntity.ok("Schedule deleted successfully, ID:" + scheduleId);
    }

    @PutMapping("/{id}")
    public void updateSchedule(@PathVariable(value = "id") Integer scheduleId,
            @RequestBody Schedule newScheduleDetails) throws Exception {
        Optional<Schedule> optionalSchedule = service.findById(scheduleId);
        optionalSchedule.orElseThrow(() -> new Exception("Schedule not exists with id:" + scheduleId));
        service.edit(newScheduleDetails);
    }

    @GetMapping("/search/{id}")
    public List<Schedule> getScheduleByCompanyId(@PathVariable(value = "id") Integer id) {
        return service.findScheduleByCompanyId(id);
    }

}
