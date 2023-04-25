package com.example.demo.service.impl;

import com.example.demo.model.employee.Position;
import com.example.demo.repository.employee.PositionRepository;
import com.example.demo.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
