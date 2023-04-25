package com.example.handle_exception.service;

import com.example.handle_exception.model.User;
import com.example.handle_exception.util.DuplicateEmailException;


public interface UserService {
    void save(User user) throws DuplicateEmailException;
}
