package com.example.springbootexersicemain.service.impl;

import com.example.springbootexersicemain.model.dto.ProductDto;
import com.example.springbootexersicemain.model.entity.Product;
import com.example.springbootexersicemain.model.mapper.ProductMapper;
import com.example.springbootexersicemain.repository.ProductRepository;
import com.example.springbootexersicemain.service.facade.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void save(ProductDto.InsertProductDto productDto) {
        productRepository.save(productMapper.toEntity(productDto));
    }

    @Override
    public List<Product> findProductByProductId(List<Long> productId) {
        return productRepository.findAllById(productId);
    }

    @Override
    public List<Product> findProduct(Long orderId) {
        return productRepository.findProductsByOrderId(orderId);
    }

}
