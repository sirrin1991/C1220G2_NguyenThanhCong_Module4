package com.example.handle_exception.service;

import com.example.handle_exception.model.User;
import com.example.handle_exception.repository.UserRepository;
import com.example.handle_exception.util.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void save(User user) throws DuplicateEmailException {
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }
}
