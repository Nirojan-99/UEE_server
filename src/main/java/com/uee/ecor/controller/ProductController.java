package com.uee.ecor.controller;

import com.uee.ecor.model.Product;
import com.uee.ecor.model.User;
import com.uee.ecor.service.ProductService;
import com.uee.ecor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @PostMapping("")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product createdProduct = productService.addProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Product> addCompanyProduct(@RequestBody Product product, @PathVariable("id") String id) {
        System.out.println("dddd");
        Product createdProduct = productService.addProduct(product);

        User user = userService.getUser(id);

        user.addProduct(createdProduct.getId());
        userService.updateUser(user);

        return new ResponseEntity<>(createdProduct, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {

        Product product = productService.getProduct(id);
        System.out.println(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/{userId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") String id, @PathVariable("id") String userId) {
        productService.deleteProduct(id);
        User user = userService.getUser(userId);

        if (user != null) {
            user.removeProduct(id);
            userService.updateUser(user);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Unable to delete", HttpStatus.NOT_FOUND);
        }

    }

}
