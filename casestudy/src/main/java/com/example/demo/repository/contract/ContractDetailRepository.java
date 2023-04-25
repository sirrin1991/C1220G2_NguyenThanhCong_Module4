package com.example.demo.repository.contract;

import com.example.demo.model.contract.ContractDetail;
import com.example.demo.model.contract.ContractDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail, ContractDetailKey> {
}
