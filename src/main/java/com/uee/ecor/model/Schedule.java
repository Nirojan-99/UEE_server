package com.uee.ecor.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Schedule")
@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    @Id
    private String id;
    private String productId;
    private String from;
    private String companyId;
    private int quantity;
    private String date;
    private String time;
    private String dealerId;
    private String vehicleId;
    private String parcelId;
    private String customerId;
    private String status;
}
