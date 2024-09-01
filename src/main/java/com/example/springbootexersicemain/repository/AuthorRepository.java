package com.example.springbootexersicemain.repository;


import com.example.springbootexersicemain.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a where a.id = :id")
    Optional<Author> findAuthorById(@Param("id") Long id);

    // INNER JOIN https://dzone.com/articles/how-to-decide-between-join-and-join-fetch
    @Query(value = "SELECT a FROM Author a INNER JOIN a.books b WHERE b.price > ?1")//run lazy load
    List<Author> findAuthorsBooksByPriceInnerJoin(int price);

    // JOIN FETCH
    @Query(value = "SELECT a FROM Author a JOIN FETCH a.books b WHERE b.price > ?1")//run lazy load
    List<Author> findAuthorsBooksByPriceJoinFetch(int price);

    @Query(value = "SELECT DISTINCT a FROM Author a JOIN a.books b GROUP BY a.id HAVING COUNT(b) > ?1")
    List<Author> findAuthorsWithMoreThanXBooks(Long bookNumber);
}