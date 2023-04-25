package com.example.demo.repository.customer;

import com.example.demo.model.customer.Customer;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAll(Pageable pageable);

    List<Customer> findCustomerByCodeContainingAndNameContainingAndAddressContaining(String code, String name, String address);
}
