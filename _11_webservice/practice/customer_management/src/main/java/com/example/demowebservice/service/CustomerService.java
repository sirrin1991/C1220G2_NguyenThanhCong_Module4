package com.example.demowebservice.service;

import com.example.demowebservice.model.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    Customer findById(int id) ;
    void deleteCustomer(int id);
    List<Customer> findAll();
}
