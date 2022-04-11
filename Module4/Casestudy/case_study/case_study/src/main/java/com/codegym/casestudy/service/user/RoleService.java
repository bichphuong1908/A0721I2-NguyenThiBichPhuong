package com.codegym.casestudy.service.user;


import com.codegym.casestudy.model.user.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String name);
    List<Role> findAll();
    Role findById(long id);
}
