package com.codegym.casestudy.repository.user;

import com.codegym.casestudy.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);

    @Query("SELECT u.id FROM User u WHERE u.email = ?1")
    Integer getUserIdByEmail(String email);

    //    @Query("SELECT u.id FROM User u WHERE u.nickName = ?1")
    User getUserByEmail(String email);

    Boolean existsUsersByEmail(String email);
}
