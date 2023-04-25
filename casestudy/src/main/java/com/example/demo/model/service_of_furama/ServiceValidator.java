package com.example.demo.model.service_of_furama;

import com.example.demo.service.IServiceOfFuramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ServiceValidator implements Validator {

    @Autowired
    private IServiceOfFuramaService iServiceOfFuramaService;

    @Override
    public boolean supports(Class<?> clazz) {
        return ServiceValidator.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Service service = (Service) target;
        Integer id = service.getId();
        String code = service.getCode();
        if (id != null) {
            if (iServiceOfFuramaService.checkServiceByCodeAndId(code, id)) {
                errors.rejectValue("code", "unique.code");
            }
        } else if (iServiceOfFuramaService.checkServiceByCode(code)) {
            errors.rejectValue("code", "unique.code");
        }
    }
}
