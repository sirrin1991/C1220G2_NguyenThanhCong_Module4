package com.example.register_form.service;


import com.example.register_form.entity.Register;

import java.util.List;

public interface RegisterService {
    void save(Register register);

    boolean checkExistEmail(String email);

    boolean checkExistPhoneNumber(String phoneNumber);

    List<Register> findAll();
}
