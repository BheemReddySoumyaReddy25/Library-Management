package com.pratice.demo.bookmanagement.service;

import com.pratice.demo.bookmanagement.model.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(int id);
    Book updateBookById(int id, Book book);
    boolean deleteBookById(int id);
}
