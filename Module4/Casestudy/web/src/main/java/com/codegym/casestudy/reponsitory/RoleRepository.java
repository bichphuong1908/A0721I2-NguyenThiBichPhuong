package com.codegym.casestudy.reponsitory;

import com.codegym.casestudy.model.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
