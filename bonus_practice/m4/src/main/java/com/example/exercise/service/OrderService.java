package com.example.exercise.service;


import com.example.exercise.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    void deleteById(Integer id);
    void save(Order category);
    Order findById(Integer id);
}
