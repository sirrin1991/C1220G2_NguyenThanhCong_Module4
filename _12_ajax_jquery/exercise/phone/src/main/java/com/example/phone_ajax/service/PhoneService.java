package com.example.phone_ajax.service;

import com.example.phone_ajax.model.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> findAll();
    Phone save(Phone phone);
    void delete(Integer id);
    Phone findById(Integer id);
}
