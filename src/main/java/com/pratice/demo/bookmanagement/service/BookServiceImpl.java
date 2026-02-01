package com.pratice.demo.bookmanagement.service;


import com.pratice.demo.bookmanagement.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{

    private final Map<Integer, Book> bookDB = new HashMap<>();
    @PostConstruct
    public void initBooks() {
        bookDB.put(1, new Book(1, "Book 1", "Author 1"));
        bookDB.put(2, new Book(2, "Book 2", "Author 2"));
        bookDB.put(3, new Book(3, "Book 3", "Author 3"));
    }
    @Override
    public Book addBook(Book book) {
        bookDB.put(book.getId(),book);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookDB.values());
    }

    @Override
    public Book getBookById(int id) {
        if (!bookDB.containsKey(id)) {
            return null;
        }
        return bookDB.get(id);
    }

    @Override
    public Book updateBookById(int id, Book book) {
        if(bookDB.containsKey(id)){
            book.setId(id);
            bookDB.put(id,book);
        }
        return book;
    }

    @Override
    public boolean deleteBookById(int id) {
        if (!bookDB.containsKey(id)) {
           return false;
        }
        bookDB.remove(id);
        return true;
    }
}
