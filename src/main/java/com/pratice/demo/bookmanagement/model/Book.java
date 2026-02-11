package com.pratice.demo.bookmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    private int id;
    private String title;
    private String author;
    private BookCategory category;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
