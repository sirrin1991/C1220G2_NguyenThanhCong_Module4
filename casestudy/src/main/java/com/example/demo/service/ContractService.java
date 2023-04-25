package com.example.demo.service;

import com.example.demo.model.contract.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();

    void save(Contract contract);

    void delete(Integer id);

    Contract findById(Integer id);
}
