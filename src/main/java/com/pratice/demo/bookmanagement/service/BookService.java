package com.pratice.demo.bookmanagement.service;

import com.pratice.demo.bookmanagement.dto.BookRequestDto;
import com.pratice.demo.bookmanagement.dto.BookResponseDto;

import java.util.List;

public interface BookService {
    BookResponseDto addBook(BookRequestDto dto);

    List<BookResponseDto> getAllBooks();

    BookResponseDto getBookById(int id);

    BookResponseDto updateBookById(int id, BookRequestDto dto);

    boolean deleteBookById(int id);
}
