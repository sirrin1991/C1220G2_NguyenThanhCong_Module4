package com.example.final_exam.service;

import com.example.final_exam.model.SaleInformation;
import com.example.final_exam.repository.SaleInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleInformationServiceImpl implements SaleInformationService {
    @Autowired
    private SaleInformationRepository saleInformationRepository;
    @Override
    public List<SaleInformation> findAll() {
        return saleInformationRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        saleInformationRepository.deleteById(id);
    }

    @Override
    public SaleInformation findById(Integer id) {
        return saleInformationRepository.findById(id).orElse(null);
    }

    @Override
    public void save(SaleInformation saleInformation) {
        saleInformationRepository.save(saleInformation);
    }

    @Override
    public List<SaleInformation> search(String discount, String startDate, String endDate) {
        return saleInformationRepository.searchAdvance(discount, startDate, endDate);
    }

}
