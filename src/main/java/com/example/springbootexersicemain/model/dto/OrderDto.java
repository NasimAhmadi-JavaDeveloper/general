package com.example.springbootexersicemain.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

public class OrderDto {

    @Setter
    @Getter
    @Accessors(chain = true)
    public static class InsertOrderDto {
        private String name;
        private List<Long> productId;
    }
}
