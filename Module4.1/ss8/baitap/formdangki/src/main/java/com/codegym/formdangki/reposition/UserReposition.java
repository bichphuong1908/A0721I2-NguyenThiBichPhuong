package com.codegym.formdangki.reposition;

import com.codegym.formdangki.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposition extends JpaRepository<User,Long> {
}
