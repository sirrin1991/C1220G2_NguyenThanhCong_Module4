package com.example.demo.service.impl;

import com.example.demo.model.service_of_furama.ServiceType;
import com.example.demo.repository.service_furama.ServiceTypeRepository;
import com.example.demo.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
