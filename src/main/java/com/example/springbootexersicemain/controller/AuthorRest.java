package com.example.springbootexersicemain.controller;

import com.example.springbootexersicemain.model.dto.AuthorDto;
import com.example.springbootexersicemain.service.facade.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
public class AuthorRest {

    private final AuthorService authorService;

    @GetMapping("/{authorId}")
    public AuthorDto getAuthorById(@PathVariable Long authorId) {
        return authorService.fetchAuthorById(authorId);
    }

    @GetMapping("/author-with-book-List-join/{price}")
    public List<AuthorDto> getAuthorWithBookList(@PathVariable int price) {
        return authorService.fetchAuthorsBooksByPriceInnerJoin(price);
    }

    @GetMapping("/author-with-book-List-join-fetch/{price}")
    public List<AuthorDto> getAuthorWithBookListJoinFetch(@PathVariable int price) {
        return authorService.fetchAuthorsBooksByPriceJoinFetch(price);
    }

    @GetMapping("/authors-with-more-than-books/{bookNumber}")
    public List<AuthorDto> getAuthorsWithMoreThanXBooks(@PathVariable Long bookNumber) {
        return authorService.fetchAuthorsWithMoreThanXBooks(bookNumber);
    }
}