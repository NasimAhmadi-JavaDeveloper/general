package com.example.springbootexersicemain.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String genre;
    private int age;
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY) //cascade = CascadeType.ALL,orphanRemoval = true
    private List<Book> books;// = new ArrayList<>();
}