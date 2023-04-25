package com.example.handle_exception.repository;

import com.example.handle_exception.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
