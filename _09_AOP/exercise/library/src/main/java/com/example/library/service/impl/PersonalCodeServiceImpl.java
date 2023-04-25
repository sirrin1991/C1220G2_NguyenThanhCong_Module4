package com.example.library.service.impl;

import com.example.library.entity.PersonalCode;
import com.example.library.repository.PersonalCodeRepository;
import com.example.library.service.PersonalCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalCodeServiceImpl implements PersonalCodeService {
    @Autowired
    PersonalCodeRepository personalCodeRepository;

    @Override
    public void save(PersonalCode personalCode) {
        personalCodeRepository.save(personalCode);
    }

    @Override
    public PersonalCode findById(Integer id) {
        return personalCodeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        personalCodeRepository.deleteById(id);
    }

    @Override
    public PersonalCode findByCode(String code) {
        return personalCodeRepository.findByCodeForBook(code);
    }
}
