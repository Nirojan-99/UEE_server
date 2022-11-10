package com.uee.ecor.repository;

import com.uee.ecor.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {

    User findByEmail(String email);
    User findById(String email);

}
