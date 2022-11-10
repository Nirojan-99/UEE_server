package com.uee.ecor.repository;

import com.uee.ecor.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScheduleRepository extends MongoRepository<Schedule, Integer> {

    List<Schedule> findByCustomerId(String id);

    Schedule findById(String id);

    List<Schedule> findByDealerId(String id);
}
