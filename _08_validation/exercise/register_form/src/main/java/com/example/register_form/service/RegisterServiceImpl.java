package com.example.register_form.service;


import com.example.register_form.entity.Register;
import com.example.register_form.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterRepository registerRepository;

    @Override
    public void save(Register register) {
        registerRepository.save(register);
    }

    @Override
    public boolean checkExistEmail(String email) {
        return registerRepository.existsRegisterByEmail(email);
    }

    @Override
    public boolean checkExistPhoneNumber(String phoneNumber) {
        return registerRepository.existsRegisterByPhone(phoneNumber);
    }

    @Override
    public List<Register> findAll() {
        return null;
    }
}
