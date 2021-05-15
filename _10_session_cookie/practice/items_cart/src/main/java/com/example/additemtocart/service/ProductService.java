package com.example.additemtocart.service;

import com.example.additemtocart.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(Integer id);
    void delete(Integer integer);
}
