package com.example.springbootexersicemain.service.facade;

import com.example.springbootexersicemain.model.dto.BookDto;

public interface BookService {
    BookDto fetchBookWithId(Long id);
}
