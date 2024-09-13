package com.example.springbootexersicemain.service.facade;

import com.example.springbootexersicemain.model.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto fetchBookWithId(Long id);

    List<BookDto> fetchAllBooks();

    List<BookDto> fetchAllByPriceAndTitleEqualsAndAuthor_id(Integer price, String title, Long authorId);
}
