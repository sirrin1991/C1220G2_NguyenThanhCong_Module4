package com.example.demo.service;

import com.example.demo.model.service_of_furama.Service;

import java.util.List;

public interface IServiceOfFuramaService {
    List<Service> findAll();

    void deleteById(Integer id);

    Service findById(Integer id);

    void save(Service service);

    Boolean checkServiceByCode(String code);

    Boolean checkServiceByCodeAndId(String code, Integer id);
}
