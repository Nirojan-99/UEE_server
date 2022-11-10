package com.uee.ecor.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("User")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private int mobileNumber;
    private String role;
    private String NIC;
    private String address;
    private String dp;
    private int OTP;
    private Payment payment;
    private String companyName;
    private List<String> products;
    private List<Vehicle> vehicles;

    public void addProduct(String id) {
        if (this.products == null) {
            this.products = new ArrayList<>();
        }
        this.products.add(id);
    }

    public void removeProduct(String id) {
        if (this.products == null) {
            this.products = new ArrayList<>();
            return;
        } else {
            this.products.remove(id);
        }
    }
}
