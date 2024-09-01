package com.example.springbootexersicemain.service.impl;

import com.example.springbootexersicemain.model.dto.BookDto;
import com.example.springbootexersicemain.model.mapper.BookMapper;
import com.example.springbootexersicemain.repository.BookRepository;
import com.example.springbootexersicemain.service.facade.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto fetchBookWithId(Long id) {
        return bookMapper.mapToDto(bookRepository.findById(id).orElseThrow(RuntimeException::new));
    }
}
