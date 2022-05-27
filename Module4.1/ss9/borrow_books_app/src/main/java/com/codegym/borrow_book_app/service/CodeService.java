package com.codegym.borrow_book_app.service;

import com.codegym.borrow_book_app.entity.Book;
import com.codegym.borrow_book_app.entity.Code;
import com.codegym.borrow_book_app.entity.Status;
import com.codegym.borrow_book_app.repository.IBookRepository;
import com.codegym.borrow_book_app.repository.ICodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeService implements ICodeService{
    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private ICodeRepository codeRepository;


    @Override
    public List<Code> findAll() {
        return this.codeRepository.findAll();
    }

    @Override
    public Code findById(Integer id) {
        return codeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Code code) {
        codeRepository.save(code);
    }

    @Override
    public List<Code> findAllCodeByBookId(Integer id) {
        return codeRepository.findCodeByBook_Id(id);
    }

    @Override
    public List<Code> findAvailableCodeByBookId(Integer id) {
        return codeRepository.findCodeByBook_IdAndStatus_Id(id, 1);
    }

    @Override
    public List<Code> findUsedCodeByBookId(Integer id) {
        return codeRepository.findCodeByBook_IdAndStatus_Id(id, 2);
    }

    @Override
    public void returnBookByCode(Book book, Integer returnCodeId) {
        Code code = codeRepository.findById(returnCodeId).orElse(null);
        book = code.getBook();
        book.returnBook();
        bookRepository.save(book);
        code.setStatus(new Status(1, "available"));
    }
}
