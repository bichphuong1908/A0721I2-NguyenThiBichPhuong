package com.codegym.validate.service;

import com.codegym.validate.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> findAll();
    void save(User user);
    void delete(Long id);
    Optional<User> findById(Long id);
    Page<User> findAll(Pageable pageable);
//    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}
