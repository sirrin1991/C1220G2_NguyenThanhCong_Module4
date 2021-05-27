package com.example.demo.model;

import com.example.demo.service.IEmployeeService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidation implements Validator {

    @Qualifier("employeeServiceImpl")
    @Autowired
    IEmployeeService employeeService;

    @Override
    public boolean supports(@NotNull Class<?> clazz) {
        return clazz == EmployeeValidation.class;
    }

    @Override
    public void validate(@NotNull Object target, @NotNull Errors errors) {
        Employee employee = (Employee) target;

        Integer id = employee.getId();
        String idCard = employee.getIdCard();
        String email = employee.getEmail();
        String phone = employee.getPhone();

        if(id != null){
            if(employeeService.existsEmployeeByEmailAndIdNot(email,id)){
                errors.rejectValue("email","unique.email");
            }
        }else if(employeeService.checkEmail(email)){
            errors.rejectValue("email","unique.email");
        }


    }
}
//        if(employeeService.checkEmail(employee.getEmail()) &&
//                !employee.getEmail().equals(employeeService.findById(employee.getId()).getEmail())){
//            errors.rejectValue("email","unique.email");
//        }