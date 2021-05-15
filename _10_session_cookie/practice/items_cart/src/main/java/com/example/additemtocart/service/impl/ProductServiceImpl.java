package com.example.additemtocart.service.impl;

import com.example.additemtocart.model.Product;
import com.example.additemtocart.repository.ProductRepository;
import com.example.additemtocart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer integer) {
        productRepository.deleteById(integer);
    }
}
