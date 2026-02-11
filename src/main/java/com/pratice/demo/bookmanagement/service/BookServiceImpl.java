package com.pratice.demo.bookmanagement.service;


import com.pratice.demo.bookmanagement.dto.BookRequestDto;
import com.pratice.demo.bookmanagement.dto.BookResponseDto;
import com.pratice.demo.bookmanagement.exceptions.BookNotFoundException;
import com.pratice.demo.bookmanagement.model.Book;
import com.pratice.demo.bookmanagement.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository repository;


    @Override
    public BookResponseDto addBook(BookRequestDto dto) {

        LocalDateTime now = LocalDateTime.now();

        Book book = dto.toModel();
        book.setCreatedOn(now);
        book.setUpdatedOn(now);

        repository.save(book);

        return BookResponseDto.fromModel(book);
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        return repository.findAll()
                .stream()
                .map(BookResponseDto::fromModel)
                .toList();
    }

    @Override
    public BookResponseDto getBookById(int id) {
        if(repository.findById(id).isEmpty())
            throw new BookNotFoundException("Book not found");
        return repository.findById(id)
                .map(BookResponseDto::fromModel).orElse(null);
    }

    @Override
    public BookResponseDto updateBookById(int id, BookRequestDto dto) {

        Book existing = repository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setTitle(dto.getTitle());
        existing.setAuthor(dto.getAuthor());
        existing.setCategory(dto.getCategory());

        existing.setUpdatedOn(LocalDateTime.now());

        Book res = repository.save(existing);

        return BookResponseDto.fromModel(res);
    }

    @Override
    public boolean deleteBookById(int id) {
        if(repository.findById(id).isEmpty())
            throw new BookNotFoundException("Book not found");
        return repository.deleteById(id);
    }
}
