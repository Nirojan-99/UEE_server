package com.uee.ecor.repository;

import com.uee.ecor.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, Integer> {

    Vehicle findByDriverId(String id);
}
