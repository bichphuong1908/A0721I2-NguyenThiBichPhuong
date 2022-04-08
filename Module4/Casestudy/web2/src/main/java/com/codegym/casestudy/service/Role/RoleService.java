package com.codegym.casestudy.service.Role;

import com.codegym.casestudy.model.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String name);
    List<Role> findAll();
    Role findById(long id);
}
