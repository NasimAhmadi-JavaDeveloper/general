package com.example.springbootexersicemain.service.facade;

import com.example.springbootexersicemain.model.dto.DocumentDto;
import com.example.springbootexersicemain.model.entity.Document;

import javax.validation.Valid;
import java.util.List;

public interface DocumentService {

    List<DocumentDto> select();

    DocumentDto save(@Valid DocumentDto dto);

    DocumentDto update(@Valid DocumentDto dto);

    void delete(long id);

    List<Document> retrieveDocumentWhitDocumentId(List<Long> documentIds);
}
