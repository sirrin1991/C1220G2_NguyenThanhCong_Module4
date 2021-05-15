package com.example.exercise.service;

import com.example.exercise.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    void deleteProduct(Integer id);
    Product findById(Integer id);
    void saveProduct(Product product);
    Page<Product> findAllByCategoryName(String name ,Pageable pageable);
    List<Product> getProductList();
}
