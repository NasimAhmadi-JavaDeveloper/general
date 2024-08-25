package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.ProductDto;
import com.example.springbootexersicemain.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDto.InsertProductDto productDto);
}
