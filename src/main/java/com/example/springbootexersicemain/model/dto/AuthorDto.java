package com.example.springbootexersicemain.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AuthorDto {
    private Long id;
    private String name;
    private String genre;
    private int age;
    private List<BookDto> books;
}