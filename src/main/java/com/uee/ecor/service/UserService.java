package com.uee.ecor.service;

import com.uee.ecor.model.User;
import com.uee.ecor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //add user
    public User addUser(User user) {
        return userRepository.save(user);
    }

    //login
    public User login(String email) {
        return userRepository.findByEmail(email);
    }

    //get user
    public User getUser(String id) {
        return userRepository.findById(id);
    }

    //update user
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
