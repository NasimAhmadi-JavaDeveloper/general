package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.ProductDto.InsertProductDto;
import com.example.springbootexersicemain.model.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-23T16:41:50+0330",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(InsertProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setName( productDto.getName() );
        product.setProductState( productDto.getProductState() );

        return product;
    }
}
