package com.codegym.casestudy.config;


import com.codegym.casestudy.model.Role;
import com.codegym.casestudy.model.User;
import com.codegym.casestudy.reponsitory.RoleRepository;
import com.codegym.casestudy.reponsitory.UserRepository;
import com.codegym.casestudy.ultil.EncrypPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * Seeding data test for table users and roles
 */
@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (roleRepository.findByName("ROLE_ADMIN")==null){
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if (roleRepository.findByName("ROLE_MEMBER")==null){
            roleRepository.save(new Role("ROLE_MEMBER"));
        }
        if (roleRepository.findByName("ROLE_BLOCK")==null){
            roleRepository.save(new Role("ROLE_BLOCK"));
        }

        //them admin
        if (userRepository.findByUserName("admin111") == null){
            User admin = new User();
            admin.setUserName("admin111");
            admin.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }

        //Them Member
        if (userRepository.findByUserName("Member") == null){
            User member = new User();
            member.setUserName("Member");
            member.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            member.setRoles(roles);
            userRepository.save(member);
        }
    }
}
