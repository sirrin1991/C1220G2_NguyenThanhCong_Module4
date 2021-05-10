package com.example.customer_province.service;

import com.example.customer_province.entity.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();
    void saveProvince(Province province);
    Province findById(int id) ;
    void deleteProvince(int id);
}
