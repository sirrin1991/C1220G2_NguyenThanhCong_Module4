package com.example.final_exam.repository;

import com.example.final_exam.model.SaleInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleInformationRepository extends JpaRepository<SaleInformation,Integer> {

    @Query(value = "SELECT * FROM sale where (?1 IS NULL   OR discount LIKE %?1%)\n" +
            "  AND (?2 IS NULL    OR start_date like %?2%)\n" +
            "  AND ( ?3 IS NULL  OR end_date like %?3%  )", nativeQuery = true)
    List<SaleInformation> searchAdvance(String discount, String startDate, String endDate);
}
