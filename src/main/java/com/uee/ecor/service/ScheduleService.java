package com.uee.ecor.service;

import com.uee.ecor.model.Schedule;
import com.uee.ecor.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public Schedule addSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getCustomerSchedule(String id) {
        return scheduleRepository.findByCustomerId(id);
    }

    public List<Schedule> getSchedules(){
        return scheduleRepository.findAll();
    }

    public Schedule getSchedule(String id){
        return scheduleRepository.findById(id);
    }

    public Schedule updateSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getDealerSchedule(String id){
        return  scheduleRepository.findByDealerId(id);
    }
}
