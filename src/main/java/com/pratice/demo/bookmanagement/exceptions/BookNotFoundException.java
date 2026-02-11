package com.pratice.demo.bookmanagement.exceptions;


public class BookNotFoundException  extends RuntimeException{
    public BookNotFoundException(String message){
        super(message);
    }
}