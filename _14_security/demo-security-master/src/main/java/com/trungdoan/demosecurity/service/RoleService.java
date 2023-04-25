package com.trungdoan.demosecurity.service;

import com.trungdoan.demosecurity.model.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String name);

    List<Role> findAll();

    Role findById(long id);
}
