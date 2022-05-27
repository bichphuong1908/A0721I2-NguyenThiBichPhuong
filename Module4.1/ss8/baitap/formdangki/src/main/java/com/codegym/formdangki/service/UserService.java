package com.codegym.formdangki.service;



import com.codegym.formdangki.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
