package com.pratice.demo.bookmanagement.dto;


import com.pratice.demo.bookmanagement.model.Book;
import com.pratice.demo.bookmanagement.model.BookCategory;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class BookRequestDto {

    private int id;
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Author cannot be blank")
    private String author;
    @NotNull(message = "Category cannot be null")
    private BookCategory category;
    public Book toModel() {
        return Book.builder()
                .id(this.id)
                .title(this.title)
                .author(this.author)
                .category(this.category)
                .build();
    }
}
