package com.example.springbootexersicemain.repository;

import com.example.springbootexersicemain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByNameAndPasswordAndEmail(String name, String password, String email);//1

    // User findUserByNameAndPasswordAndEmail(String name, String password, String email);//2

    @Query(value = "select user_id, count(user_id) from tbl_user_role group by user_id", nativeQuery = true)
    List<Map<Integer, Integer>> findByNumberOfRepeat();

    @Query(value = "select u from User u where u.id = :id")
    User findUser(@Param("id") Long id);

}
