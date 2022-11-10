package com.uee.ecor.controller;

import com.uee.ecor.model.Schedule;
import com.uee.ecor.model.User;
import com.uee.ecor.model.Vehicle;
import com.uee.ecor.service.ScheduleService;
import com.uee.ecor.service.UserService;
import com.uee.ecor.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;
    @Autowired
    UserService userService;
    @Autowired
    VehicleService vehicleService;

    @PostMapping("")
    public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule) {
        Schedule schedule1 = scheduleService.addSchedule(schedule);
        return new ResponseEntity<>(schedule1, HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Schedule>> getCustomerSchedule(@PathVariable("id") String id) {
        List<Schedule> schedules = scheduleService.getCustomerSchedule(id);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> acceptRequest(@PathVariable("id") String id, @RequestBody Schedule schedule) {
        Schedule exitingSchedule = scheduleService.getSchedule(id);

        exitingSchedule.setDealerId(schedule.getDealerId());
        Vehicle vehicle = vehicleService.getVehicleByUserId(schedule.getDealerId());

        if (vehicle != null) {
            exitingSchedule.setVehicleId(vehicle.getId());

            scheduleService.updateSchedule(exitingSchedule);

            return new ResponseEntity<>(exitingSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/dealer/{id}")
    public ResponseEntity<List<Schedule>> getDealerSchedule(@PathVariable("id") String id) {
        List<Schedule> schedules = scheduleService.getDealerSchedule(id);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getSchedules();

        List<Schedule> scheduleList = new ArrayList<>();

        for (Schedule schedule : schedules) {
            if (schedule.getDealerId() != null) {
                continue;
            }
            User user = userService.getUser(schedule.getCompanyId());
            if (user.getVehicles() != null) {
                continue;
            } else {
                scheduleList.add(schedule);
            }
        }

        return new ResponseEntity<>(scheduleList, HttpStatus.OK);
    }
}
