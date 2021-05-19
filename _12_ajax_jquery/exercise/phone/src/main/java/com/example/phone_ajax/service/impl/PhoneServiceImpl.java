package com.example.phone_ajax.service.impl;

import com.example.phone_ajax.model.Phone;
import com.example.phone_ajax.repository.PhoneRepository;
import com.example.phone_ajax.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private  PhoneRepository phoneRepository;

    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public void delete(Integer id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public Phone findById(Integer id) {
        return phoneRepository.findById(id).orElse(null);
    }
}
