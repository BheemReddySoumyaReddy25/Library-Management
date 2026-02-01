package com.pratice.demo.bookmanagement.controller;

import com.pratice.demo.bookmanagement.model.Book;
import com.pratice.demo.bookmanagement.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }
    @PutMapping("/{id}")
    public Book updateBookById(@PathVariable int id, @RequestBody Book book) {
        return bookService.updateBookById(id, book);
    }
    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable int id){
        boolean deleted = bookService.deleteBookById(id);
        return deleted ? "Book deleted successfully" : "Book not found";
    }
}
