package com.pratice.demo.bookmanagement.repository;

import com.pratice.demo.bookmanagement.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    /*
    * Optional is a container object that may or may not contain a value.
    * It is mainly used to avoid NullPointerException and to make code more readable.
    * */
    Optional<Book> findById(int id);
    List<Book> findAll();
    boolean deleteById(int id);
    boolean existsById(int id);
}
