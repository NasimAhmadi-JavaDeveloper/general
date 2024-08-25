package com.example.springbootexersicemain.repository;

import com.example.springbootexersicemain.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
