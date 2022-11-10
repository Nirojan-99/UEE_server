package com.uee.ecor.service;

import com.uee.ecor.model.Product;
import com.uee.ecor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(String id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
