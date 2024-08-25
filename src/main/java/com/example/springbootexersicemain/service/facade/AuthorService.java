package com.example.springbootexersicemain.service.facade;

import com.example.springbootexersicemain.model.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto fetchAuthorById(Long authorId);

    List<AuthorDto> fetchAuthorsBooksByPriceInnerJoin(int price);

    List<AuthorDto> fetchAuthorsBooksByPriceJoinFetch(int price);
}
