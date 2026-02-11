package com.pratice.demo.bookmanagement.dto;

import com.pratice.demo.bookmanagement.model.Book;
import com.pratice.demo.bookmanagement.model.BookCategory;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BookResponseDto{

    private int id;
    private String title;
    private String author;
    private BookCategory category;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public static BookResponseDto fromModel(Book book) {
        return BookResponseDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .category(book.getCategory())
                .createdOn(book.getCreatedOn())
                .updatedOn(book.getUpdatedOn())
                .build();
    }
}