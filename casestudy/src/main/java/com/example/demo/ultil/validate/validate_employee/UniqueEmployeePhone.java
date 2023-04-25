package com.example.demo.ultil.validate.validate_employee;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = UniquePhoneValidator.class)
public @interface UniqueEmployeePhone {
    public String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
