package com.example.exercise.service.impl;

import com.example.exercise.entity.Order;
import com.example.exercise.repository.OrderRepository;
import com.example.exercise.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void save(Order category) {
        orderRepository.save(category);
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }
}
