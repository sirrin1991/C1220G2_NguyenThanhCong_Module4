package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    List<User> saveAll(List<User> users);

    User findById(Integer integer);

    boolean existsById(Integer integer);

    List<User> findAll();

    List<User> findAllById(List<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(User user);

    void deleteAll(Iterable<? extends User> iterable);

    void deleteAll();

    UserDetails loadUserByUsername(String username);

    @Query("SELECT u.id FROM User u WHERE u.email = ?1")
    Integer getUserIdByEmail(String email);

    Boolean checkExistUser(String email);
}
