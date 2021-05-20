package com.example.blog.repository;

import com.example.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);

    @Query("SELECT u.id FROM User u WHERE u.email = ?1")
    Integer getUserIdByEmail(String email);

    Boolean existsUsersByEmail(String email);
}
