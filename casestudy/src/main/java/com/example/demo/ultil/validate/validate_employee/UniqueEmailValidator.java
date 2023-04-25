package com.example.demo.ultil.validate.validate_employee;


import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmployeeEmail, String> {
    @Autowired
    private IEmployeeService employeeService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !employeeService.checkEmail(value);
    }
}
