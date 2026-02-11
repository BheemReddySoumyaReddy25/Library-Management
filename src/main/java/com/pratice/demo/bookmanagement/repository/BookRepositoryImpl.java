package com.pratice.demo.bookmanagement.repository;

import com.pratice.demo.bookmanagement.model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final Map<Integer, Book> bookDB = new HashMap<>();



    @Override
    public Book save(Book book) {
        bookDB.put(book.getId(), book);
        return book;
    }

    @Override
    public Optional<Book> findById(int id) {
        return Optional.ofNullable(bookDB.get(id));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookDB.values());
    }

    @Override
    public boolean deleteById(int id) {
        if (!bookDB.containsKey(id)) return false;
        bookDB.remove(id);
        return true;
    }

    @Override
    public boolean existsById(int id) {
        return bookDB.containsKey(id);
    }
}
