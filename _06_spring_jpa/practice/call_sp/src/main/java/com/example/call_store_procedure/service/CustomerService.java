package com.example.call_store_procedure.service;

import com.example.call_store_procedure.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void saveCustomer(Customer customer);
    Customer findById(int id) ;
    void deleteCustomer(int id);
}
