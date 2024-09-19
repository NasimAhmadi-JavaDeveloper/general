package com.example.springbootexersicemain.controller;

import com.example.springbootexersicemain.model.dto.BookDto;
import com.example.springbootexersicemain.service.facade.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookRest {

    private final BookService bookService;

    @GetMapping("/{bookId}")
    public BookDto getBookById(@PathVariable Long bookId) {
        return bookService.fetchBookWithId(bookId);
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.fetchAllBooks();
    }

    @GetMapping("/books/{price}/{title}/{authorId}")
    public List<BookDto> getAllByPriceAndTitleEqualsAndAuthor_id(@PathVariable Integer price,
                                                                 @PathVariable String title,
                                                                 @PathVariable Long authorId) {
        return bookService.fetchAllByPriceAndTitleEqualsAndAuthor_id(price, title, authorId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
         bookService.deleteBooks(id);
         ResponseEntity.ok().build();
    }
}
