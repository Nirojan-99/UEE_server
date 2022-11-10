package com.uee.ecor.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Product")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String productName;
    private double unitPrice;
    private String description;
    private int totalCollection;
    private String image;
    private String companyName;
}
