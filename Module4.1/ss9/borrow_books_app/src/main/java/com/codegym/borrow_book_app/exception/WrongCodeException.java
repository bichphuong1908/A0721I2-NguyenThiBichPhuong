package com.codegym.borrow_book_app.exception;

public class WrongCodeException extends Exception{
    @Override
    public String getMessage() {
        return "Your code is invalid";
    }
}
