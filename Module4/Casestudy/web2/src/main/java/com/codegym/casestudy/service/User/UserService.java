package com.codegym.casestudy.service.User;

import com.codegym.casestudy.model.User;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserService {
    User save(User user);

    UserDetails loadUserByUsername(String username);

    Boolean checkExistUser(String username);
}
