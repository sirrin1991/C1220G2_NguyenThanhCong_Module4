package com.example.exercise.service.impl;

import com.example.exercise.entity.Product;
import com.example.exercise.repository.ProductRepository;
import com.example.exercise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> findAllByCategoryName(String name, Pageable pageable) {
        return productRepository.findAllByCategory_Name(name,pageable);
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }
}
