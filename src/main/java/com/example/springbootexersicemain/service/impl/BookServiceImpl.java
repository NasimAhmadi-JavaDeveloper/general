package com.example.springbootexersicemain.service.impl;

import com.example.springbootexersicemain.event.BookNotFoundEvent;
import com.example.springbootexersicemain.model.dto.BookDto;
import com.example.springbootexersicemain.model.mapper.BookMapper;
import com.example.springbootexersicemain.repository.BookRepository;
import com.example.springbootexersicemain.service.facade.BookService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
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

    @Transactional
    @CacheEvict(value = "books", allEntries = true)
    public void deleteBooks(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    private static void extracted() {
        String json = "{\n" +
                "  \"library\": {\n" +
                "    \"name\": \"City Library\",\n" +
                "    \"location\": \"Downtown\",\n" +
                "    \"books\": [\n" +
                "      {\"id\": 1, \"title\": \"Effective Java\", \"author\": \"Joshua Bloch\", \"publishedYear\": 2008},\n" +
                "      {\"id\": 2, \"title\": \"Clean Code\", \"author\": \"Robert C. Martin\", \"publishedYear\": 2008},\n" +
                "      {\"id\": 3, \"title\": \"The Pragmatic Programmer\", \"author\": \"Andrew Hunt\", \"publishedYear\": 1999},\n" +
                "      {\"id\": 4, \"title\": \"Design Patterns\", \"author\": \"Erich Gamma\", \"publishedYear\": 1994},\n" +
                "      {\"id\": 5, \"title\": \"Refactoring\", \"author\": \"Martin Fowler\", \"publishedYear\": 1999}\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);

            JsonNode booksArray = rootNode.path("library").path("books");

            if (booksArray.isArray() && !booksArray.isEmpty()) {

                JsonNode lastBook = booksArray.get(booksArray.size() - 1);

                String prettyString = lastBook.toPrettyString();
                System.out.println("Last Book: " + prettyString);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
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

    @Override
    public List<BookDto> fetchAllByPriceAndTitleEqualsAndAuthor_id(Integer price, String title, Long authorId) {
         return bookMapper.mapToDtoList(bookRepository.findAllByPriceAndTitleEqualsAndAuthor_id(price, title, authorId));
    }
}
