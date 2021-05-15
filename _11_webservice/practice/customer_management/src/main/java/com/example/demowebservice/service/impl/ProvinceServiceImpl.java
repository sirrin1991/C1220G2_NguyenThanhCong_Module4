package com.example.demowebservice.service.impl;

import com.example.demowebservice.model.Province;
import com.example.demowebservice.repository.ProvinceRepository;
import com.example.demowebservice.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public void saveProvince(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public Province findById(int id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProvince(int id) {
        provinceRepository.deleteById(id);
    }

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }
}
