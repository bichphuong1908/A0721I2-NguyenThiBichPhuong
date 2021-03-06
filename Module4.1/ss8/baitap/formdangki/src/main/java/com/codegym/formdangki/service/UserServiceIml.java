package com.codegym.formdangki.service;

import com.codegym.formdangki.model.User;
import com.codegym.formdangki.reposition.UserReposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIml implements UserService{
    @Autowired
    private UserReposition userReposition;
    @Override
    public List<User> findAll() {
        return userReposition.findAll();
    }

//    @Override
//    public Page<User> findAll(Pageable pageable) {
//        return userReposition.findAll(pageable);
//    }
//
//    @Override
//    public void save(User user) {
//        userReposition.save(user);
//    }
}
