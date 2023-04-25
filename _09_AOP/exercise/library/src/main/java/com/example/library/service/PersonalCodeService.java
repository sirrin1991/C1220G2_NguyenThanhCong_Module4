package com.example.library.service;

import com.example.library.entity.PersonalCode;

public interface PersonalCodeService {
    void save(PersonalCode personalCode);

    PersonalCode findById(Integer id);

    void delete(Integer id);

    PersonalCode findByCode(String code);
}
