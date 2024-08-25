package com.example.springbootexersicemain.repository;

import com.example.springbootexersicemain.model.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {

}
