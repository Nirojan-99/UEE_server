package com.uee.ecor.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Transaction")
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    private String id;
    private String from;
    private String to;
    private double amount;
}
