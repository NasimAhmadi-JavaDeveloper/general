package com.example.springbootexersicemain.controller;

import com.example.springbootexersicemain.model.dto.BookDto;
import com.example.springbootexersicemain.service.facade.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
