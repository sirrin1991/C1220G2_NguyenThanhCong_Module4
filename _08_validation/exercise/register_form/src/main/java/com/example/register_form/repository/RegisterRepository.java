package com.example.register_form.repository;


import com.example.register_form.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {
    boolean existsRegisterByEmail(String email);

    boolean existsRegisterByPhone(String phoneNumber);
}
