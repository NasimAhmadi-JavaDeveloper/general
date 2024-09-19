package com.example.springbootexersicemain.repository;

import com.example.springbootexersicemain.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findPostByTitleAndSlug(String title, String slug);

    @Query(value = "SELECT p.slug FROM tbl_post p WHERE p.is_vip IS TRUE AND p.slug NOTNULL", nativeQuery = true)
    List<String> findAllSlug();

    //Find all VIP posts created by users with a specific role
    @Query("SELECT p FROM Post p WHERE p.isVip = true AND p.user.id IN (SELECT u.id FROM User u JOIN u.roles r WHERE r.title = :roleName)")
    List<Post> findVipPostsByUserRole(@Param("roleName") String roleName);


    //Find all posts by users who have more than a certain number of posts
    @Query("SELECT p FROM Post p WHERE p.user.id IN (SELECT u.id FROM User u WHERE SIZE(u.posts) > :postCount)")
    List<Post> findPostsByUsersWithPostCountGreaterThan(@Param("postCount") int postCount);


    //Find posts that belong to users who registered after a specific date
    @Query("SELECT p FROM Post p WHERE p.user.createDate > :date")
    List<Post> findPostsByUsersRegisteredAfter(@Param("date") Timestamp date);


    //Get posts along with their summary and user details
    @Query("SELECT p.title, p.summary, u.name, u.email FROM Post p JOIN p.user u")
    List<Object[]> findPostSummariesWithUserDetails();
}
