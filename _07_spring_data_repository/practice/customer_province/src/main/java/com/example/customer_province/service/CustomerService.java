package com.example.customer_province.service;


import com.example.customer_province.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    void saveCustomer(Customer customer);
    Customer findById(int id) ;
    void deleteCustomer(int id);
    Page<Customer> findByFirstNameContaining(String name, Pageable pageable);
}
