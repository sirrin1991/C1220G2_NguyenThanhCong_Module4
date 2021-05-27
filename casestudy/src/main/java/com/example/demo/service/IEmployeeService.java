package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    void save(Employee employee);
    void delete(Integer id);
    Employee findById(Integer id);
    Boolean checkEmail(String email);
    Boolean checkPhone(String phone);
    Boolean checkIdCard(String idCard);
    Employee findEmployeeByEmail(String email);
    Boolean existsEmployeeByEmailAndIdNot(String email , Integer id);
}
