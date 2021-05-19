package com.example.customer_management.services;



import com.example.customer_management.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void remove(int id);
}
