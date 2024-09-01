package com.example.springbootexersicemain.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String isbn;
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}