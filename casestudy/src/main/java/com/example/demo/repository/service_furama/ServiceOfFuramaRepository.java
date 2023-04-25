package com.example.demo.repository.service_furama;

import com.example.demo.model.service_of_furama.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOfFuramaRepository extends JpaRepository<Service, Integer> {
    Boolean existsServiceByCode(String code);

    Boolean existsServiceByCodeAndIdNot(String code, Integer id);
}
