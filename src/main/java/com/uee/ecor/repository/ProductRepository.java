package com.uee.ecor.repository;

import com.uee.ecor.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Integer> {
    Product findById(String id);

    void deleteById(String id);
}
