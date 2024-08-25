package com.example.springbootexersicemain.model.entity;

import com.example.springbootexersicemain.model.enums.ProductState;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tbl_product")
@Accessors(chain = true)
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductState productState;
    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
}