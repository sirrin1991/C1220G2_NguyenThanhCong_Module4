package com.example.demo.service.impl;

import com.example.demo.repository.service_furama.ServiceOfFuramaRepository;
import com.example.demo.service.IServiceOfFuramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOfFuramaServiceImpl implements IServiceOfFuramaService {
    @Autowired
    private ServiceOfFuramaRepository serviceOfFuramaRepository;

    @Override
    public List<com.example.demo.model.service_of_furama.Service> findAll() {
        return serviceOfFuramaRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        serviceOfFuramaRepository.deleteById(id);
    }

    @Override
    public com.example.demo.model.service_of_furama.Service findById(Integer id) {
        return serviceOfFuramaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(com.example.demo.model.service_of_furama.Service service) {
        serviceOfFuramaRepository.save(service);
    }

    @Override
    public Boolean checkServiceByCode(String code) {
        return serviceOfFuramaRepository.existsServiceByCode(code);
    }

    @Override
    public Boolean checkServiceByCodeAndId(String code, Integer id) {
        return serviceOfFuramaRepository.existsServiceByCodeAndIdNot(code, id);
    }
}
