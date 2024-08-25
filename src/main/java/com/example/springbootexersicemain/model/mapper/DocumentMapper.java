package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.DocumentDto;
import com.example.springbootexersicemain.model.entity.Document;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    List<DocumentDto> toDtoList(List<Document> document);

    DocumentDto toDto(Document document);

    Document toEntity(DocumentDto dto);
}
