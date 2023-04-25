package com.example.demo.service;

import com.example.demo.model.contract.ContractDetail;
import com.example.demo.model.contract.ContractDetailKey;

public interface ContractDetailService {
    void save(ContractDetail contractDetail);

    void delete(ContractDetailKey contractDetailKey);
}
