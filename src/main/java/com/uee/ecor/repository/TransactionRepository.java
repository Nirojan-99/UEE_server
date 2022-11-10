package com.uee.ecor.repository;

import com.uee.ecor.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, Integer> {
}
