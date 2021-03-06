package com.codegym.casestudy.service.Role;

import com.codegym.casestudy.model.Role;
import com.codegym.casestudy.reponsitory.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> findAll() {
        return ((List<Role>) roleRepository.findAll());
    }

    @Override
    public Role findById(long id) {
            return roleRepository.findById(id).orElse(null);
    }
}
