package com.example.register_form.util.validate;


import com.example.register_form.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    RegisterService registerService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !registerService.checkExistEmail(value);
    }
}
