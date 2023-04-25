package com.example.demo.service.impl;

import com.example.demo.model.contract.ContractDetail;
import com.example.demo.model.contract.ContractDetailKey;
import com.example.demo.repository.contract.ContractDetailRepository;
import com.example.demo.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(ContractDetailKey contractDetailKey) {
        contractDetailRepository.deleteById(contractDetailKey);
    }
}
