package com.pratice.demo.bookmanagement.controller;

import com.pratice.demo.bookmanagement.dto.BookRequestDto;
import com.pratice.demo.bookmanagement.dto.BookResponseDto;
import com.pratice.demo.bookmanagement.exceptions.BookNotFoundException;
import com.pratice.demo.bookmanagement.model.Book;
import com.pratice.demo.bookmanagement.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private  BookService bookService;
//    public BookController(BookService bookService){
//        this.bookService = bookService;
//    }

    @GetMapping
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public BookResponseDto addBook(@Valid @RequestBody BookRequestDto dto) {
        return bookService.addBook(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(bookService.getBookById(id));
        }catch (BookNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public BookResponseDto updateBookById(
            @PathVariable int id,
            @Valid @RequestBody BookRequestDto dto
    ) {
        return bookService.updateBookById(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBookById(@PathVariable int id) {
        try {
            bookService.deleteBookById(id);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (BookNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.FORBIDDEN);
        }
    }
    /*
    * Implement Patch
    * */
}
