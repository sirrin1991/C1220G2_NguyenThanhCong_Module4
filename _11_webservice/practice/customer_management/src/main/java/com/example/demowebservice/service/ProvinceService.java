package com.example.demowebservice.service;

import com.example.demowebservice.model.Province;

import java.util.List;

public interface ProvinceService {
    void saveProvince(Province province);
    Province findById(int id) ;
    void deleteProvince(int id);
    List<Province> findAll();
}
