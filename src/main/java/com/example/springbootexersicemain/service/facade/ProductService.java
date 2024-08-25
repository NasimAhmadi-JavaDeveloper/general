package com.example.springbootexersicemain.service.facade;

import com.example.springbootexersicemain.model.dto.ProductDto;
import com.example.springbootexersicemain.model.entity.Product;

import java.util.List;

public interface ProductService {
    void save(ProductDto.InsertProductDto productDto);

    List<Product> findProductByProductId(List<Long> productId);

    List<Product> findProduct(Long orderId);
}