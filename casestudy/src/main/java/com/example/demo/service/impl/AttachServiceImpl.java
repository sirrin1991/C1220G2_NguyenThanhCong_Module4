package com.example.demo.service.impl;

import com.example.demo.model.contract.AttachService;
import com.example.demo.repository.contract.AttachServiceRepository;
import com.example.demo.service.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements IAttachService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
