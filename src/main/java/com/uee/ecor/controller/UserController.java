package com.uee.ecor.controller;

import com.uee.ecor.model.Product;
import com.uee.ecor.model.User;
import com.uee.ecor.service.ProductService;
import com.uee.ecor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @PostMapping("")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User createdUser = userService.addUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        User createdUser = userService.getUser(id);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<List<Product>> getCompanyProducts(@PathVariable("id") String id) {
        User user = userService.getUser(id);

        List<String> products = user.getProducts();

        List<Product> productList = new ArrayList<>();

        for (String pid : products) {
            Product product = productService.getProduct(pid);
            if (product != null) {
                productList.add(product);
            }

        }

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping("/auth")
    public ResponseEntity<User> login(@RequestBody User user1) {
        User user = userService.login(user1.getEmail());
        if (user != null) {
            if (user.getPassword().equals(user1.getPassword())) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") String id) {
        User existingUser = userService.getUser(id);

        existingUser.setName(user.getName());
        existingUser.setMobileNumber(user.getMobileNumber());
        existingUser.setAddress(user.getAddress());

        userService.updateUser(existingUser);

        return new ResponseEntity<>(existingUser, HttpStatus.OK);
    }

    @PutMapping("/security/{id}")
    public ResponseEntity<User> updatePassword(@RequestBody User user, @PathVariable("id") String id) {
        User existingUser = userService.getUser(id);

        if (existingUser != null) {

            existingUser.setPassword(user.getPassword());
            userService.updateUser(existingUser);

            return new ResponseEntity<>(existingUser, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/payment/{id}")
    public ResponseEntity<User> updatePayment(@RequestBody User user, @PathVariable("id") String id) {
        User existingUser = userService.getUser(id);

        if (existingUser != null) {

            existingUser.setPayment(user.getPayment());
            userService.updateUser(existingUser);

            return new ResponseEntity<>(existingUser, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
