package com.example.springbootexersicemain.service.impl;

import com.example.springbootexersicemain.event.BookNotFoundEvent;
import com.example.springbootexersicemain.model.dto.BookDto;
import com.example.springbootexersicemain.model.mapper.BookMapper;
import com.example.springbootexersicemain.repository.BookRepository;
import com.example.springbootexersicemain.service.facade.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Cacheable(value = "books")
    @Transactional(readOnly = true)
    public List<BookDto> fetchAllBooks() {
        return bookMapper.mapToDtoList(bookRepository.findAll());
    }

    @Override
    @Transactional
    @CacheEvict(key = "#id", value = "books")
    public BookDto fetchBookWithId(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::mapToDto)
                .orElseGet(() -> {
                    String title = String.format("Book with ID: %d not found", id);
                    log.error(title);
                    eventPublisher.publishEvent(new BookNotFoundEvent(this, title));
                    return null;
                });
    }
}
