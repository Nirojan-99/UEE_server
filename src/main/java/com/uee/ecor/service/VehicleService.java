package com.uee.ecor.service;

import com.uee.ecor.model.Vehicle;
import com.uee.ecor.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle addVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleByUserId(String id){
        Vehicle vehicle= vehicleRepository.findByDriverId(id);
        System.out.println(vehicle.getId());
        return vehicle;
    }
}
