package com.example.springbootexersicemain.controller;

import com.example.springbootexersicemain.model.dto.ProductDto;
import com.example.springbootexersicemain.service.facade.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductRest {

    private final ProductService productService;

    @PostMapping(path = "/save")
    public ResponseEntity<Void> save(@RequestBody @Valid ProductDto.InsertProductDto dto) {
        productService.save(dto);
        return ResponseEntity.ok().build();
    }
}
