package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.AuthorDto;
import com.example.springbootexersicemain.model.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface AuthorMapper {

    @Mapping(source = "books", target = "books")
    AuthorDto mapToDto(Author author);

    List<AuthorDto> mapToDtoList(List<Author> authorList);
}