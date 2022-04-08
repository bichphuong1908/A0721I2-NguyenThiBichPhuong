package com.codegym.casestudy.reponsitory;

import com.codegym.casestudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findAllByUserNameContaining(String UserName);

    User findByUserName(String userName);

    Boolean existsByUserName(String userName);

}
