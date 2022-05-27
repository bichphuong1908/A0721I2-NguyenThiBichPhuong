package com.codegym.borrow_book_app.service;

import com.codegym.borrow_book_app.entity.Book;
import com.codegym.borrow_book_app.entity.Code;
import com.codegym.borrow_book_app.exception.NotAvailableException;
import com.codegym.borrow_book_app.exception.WrongCodeException;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);

    void borrow(Book book, Integer usedCode);

    void delete(Integer id);

    Code getNextAvailableCode(Book book) throws NotAvailableException;

    void returnBook(Book book, Integer returnCode) throws NotAvailableException, WrongCodeException;

    boolean checkNoUsedCode(Book book);
}
