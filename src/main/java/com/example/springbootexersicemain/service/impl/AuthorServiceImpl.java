package com.example.springbootexersicemain.service.impl;

import com.example.springbootexersicemain.exception.AuthorNotFoundException;
import com.example.springbootexersicemain.model.dto.AuthorDto;
import com.example.springbootexersicemain.model.entity.Author;
import com.example.springbootexersicemain.model.entity.Book;
import com.example.springbootexersicemain.model.mapper.AuthorMapper;
import com.example.springbootexersicemain.repository.AuthorRepository;
import com.example.springbootexersicemain.service.facade.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorDto fetchAuthorById(Long authorId) {
        Author author = authorRepository.findAuthorById(authorId)
                .orElseThrow(AuthorNotFoundException::new);

        List<Book> books = author.getBooks();
        log.info("list of books :{} for authorId :{}", books, authorId);
        return authorMapper.mapToDto(author);
    }

    @Override
    public List<AuthorDto> fetchAuthorsBooksByPriceInnerJoin(int price) {
        List<Author> authorsWithBooks = authorRepository.findAuthorsBooksByPriceInnerJoin(price);
        return authorMapper.mapToDtoList(authorsWithBooks);
    }

    @Override
    public List<AuthorDto> fetchAuthorsBooksByPriceJoinFetch(int price) {
        List<Author> authorsWithBooks = authorRepository.findAuthorsBooksByPriceJoinFetch(price);
        return authorMapper.mapToDtoList(authorsWithBooks);
    }


}