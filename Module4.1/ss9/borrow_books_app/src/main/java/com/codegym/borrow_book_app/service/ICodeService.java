package com.codegym.borrow_book_app.service;

import com.codegym.borrow_book_app.entity.Book;
import com.codegym.borrow_book_app.entity.Code;

import java.util.List;

public interface ICodeService {
    List<Code> findAll();

    Code findById(Integer id);

    void save(Code code);

    List<Code> findAllCodeByBookId(Integer id);

    List<Code> findAvailableCodeByBookId(Integer id);

    List<Code> findUsedCodeByBookId(Integer id);

    void returnBookByCode(Book book, Integer returnCode);
}
