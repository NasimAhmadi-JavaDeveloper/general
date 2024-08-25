package com.example.springbootexersicemain.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookDto {
    private Long id;
    private String title;
    private String isbn;
    private Integer price;
}

