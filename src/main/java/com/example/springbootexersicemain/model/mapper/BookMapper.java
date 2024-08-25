package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.BookDto;
import com.example.springbootexersicemain.model.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto mapToDto(Book book);

}