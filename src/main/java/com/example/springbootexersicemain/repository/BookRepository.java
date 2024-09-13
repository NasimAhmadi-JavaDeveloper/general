package com.example.springbootexersicemain.repository;

import com.example.springbootexersicemain.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT b FROM Book b INNER JOIN b.author a")
    List<Book> fetchBooksAuthorsInnerJoinBad();

    @Query(value = "SELECT b, a FROM Book b INNER JOIN b.author a")
    List<Book> fetchBooksAuthorsInnerJoinGood();

    @Query(value = "SELECT b FROM Book b JOIN FETCH b.author a")
    List<Book> fetchBooksAuthorsJoinFetch();

    List<Book> findAllByPriceAndTitleEqualsAndAuthor_id(Integer price, String title, Long authorId);
}