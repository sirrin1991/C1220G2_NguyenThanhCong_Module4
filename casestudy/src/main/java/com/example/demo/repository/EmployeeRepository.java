package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findCustomerByPhoneContainingAndNameContainingAndAddressContaining(String name, String address,String phone);
    Boolean existsEmployeeByEmail(String email);
    Boolean existsEmployeeByPhone(String phone);
    Boolean existsEmployeeByIdCard(String idCard);
    Employee findEmployeeByEmail(String email);
    Boolean existsEmployeeByEmailAndIdNot(String email , Integer id);

}
