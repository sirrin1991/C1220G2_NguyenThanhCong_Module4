package com.example.final_exam.service;

import com.example.final_exam.model.SaleInformation;

import java.util.List;

public interface SaleInformationService {
    List<SaleInformation> findAll();
    void delete(Integer id);
    SaleInformation findById(Integer id);
    void save(SaleInformation saleInformation);
    List<SaleInformation> search(String discount,String startDate, String endDate);
}
