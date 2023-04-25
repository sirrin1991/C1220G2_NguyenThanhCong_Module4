package com.example.demo.service.impl;

import com.example.demo.model.employee.Employee;
import com.example.demo.repository.employee.EmployeeRepository;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean checkEmail(String email) {
        return employeeRepository.existsEmployeeByEmail(email);
    }

    @Override
    public Boolean checkPhone(String phone) {
        return employeeRepository.existsEmployeeByPhone(phone);
    }

    @Override
    public Boolean checkIdCard(String idCard) {
        return employeeRepository.existsEmployeeByIdCard(idCard);
    }

    @Override
    public Employee findEmployeeByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email);
    }

    @Override
    public Boolean existsEmployeeByEmailAndIdNot(String email, Integer id) {
        return employeeRepository.existsEmployeeByEmailAndIdNot(email, id);
    }
}
