package com.example.demo.service;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICustomerService {
    Page<Customer> getListCustomer(Pageable pageable);

    void save(Customer customer);

    void delete(Integer id);

    Customer findById(Integer id);

    List<Customer> searchCustomer(String code, String name, String address);
}
