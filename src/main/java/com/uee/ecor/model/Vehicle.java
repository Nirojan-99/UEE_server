package com.uee.ecor.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Vehicle")
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {
    @Id
    private String id;
    private String vehicleType;
    private String vehicleNumber;
    private String vehicleColor;
    private int chassisNumber;
    private int licenceNumber;
    private String licenceImage;
    private String driverId;
}
