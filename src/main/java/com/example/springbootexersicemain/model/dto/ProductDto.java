package com.example.springbootexersicemain.model.dto;

import com.example.springbootexersicemain.model.enums.ProductState;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class ProductDto {

    @Setter
    @Getter
    @Accessors(chain = true)
    public static class InsertProductDto {
        private String name;
        private ProductState productState;
    }
}
