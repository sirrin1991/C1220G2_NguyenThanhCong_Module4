package com.trungdoan.demosecurity.repository;

import com.trungdoan.demosecurity.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
