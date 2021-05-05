package com.example.call_store_procedure.service;

import com.example.call_store_procedure.entity.Customer;
import com.example.call_store_procedure.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.userDelete(id);
    }
}
