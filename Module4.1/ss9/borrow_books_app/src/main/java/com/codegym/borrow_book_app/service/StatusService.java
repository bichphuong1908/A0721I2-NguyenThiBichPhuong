package com.codegym.borrow_book_app.service;

import com.codegym.borrow_book_app.entity.Status;
import com.codegym.borrow_book_app.repository.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements IStatusService{
    @Autowired
    private IStatusRepository statusRepository;

    @Override
    public void createStatus() {
        statusRepository.save(new Status(1, "available"));
        statusRepository.save(new Status(2, "used"));
    }
}
