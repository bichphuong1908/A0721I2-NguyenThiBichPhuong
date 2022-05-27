package com.codegym.borrow_book_app.repository;

import com.codegym.borrow_book_app.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepository extends JpaRepository<Status, Integer> {
}
