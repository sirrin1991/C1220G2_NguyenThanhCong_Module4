package com.example.call_store_procedure.repository;

import com.example.call_store_procedure.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Transactional
    @Modifying
    @Query(value="call delete_by_id(:id);",nativeQuery = true)
    void userDelete(@Param("id") Integer id);

}
