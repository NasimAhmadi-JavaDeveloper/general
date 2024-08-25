package com.example.springbootexersicemain.repository;

import com.example.springbootexersicemain.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findPostByTitleAndSlug(String title, String slug);

    @Query(value = "SELECT p.slug FROM tbl_post p WHERE p.is_vip IS TRUE AND p.slug NOTNULL", nativeQuery = true)
    List<String> findAllSlug();

}
