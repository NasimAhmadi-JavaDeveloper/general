package com.example.springbootexersicemain.service.impl;

import com.example.springbootexersicemain.exception.DocumentNotfoundException;
import com.example.springbootexersicemain.model.dto.DocumentDto;
import com.example.springbootexersicemain.model.entity.Document;
import com.example.springbootexersicemain.model.mapper.DocumentMapper;
import com.example.springbootexersicemain.repository.DocumentRepository;
import com.example.springbootexersicemain.service.facade.DocumentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository repository;
    private final DocumentMapper mapper;

    public DocumentServiceImpl(DocumentRepository repository, DocumentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocumentDto> select() {
        List<Document> documents = repository.findAll();
        return mapper.toDtoList(documents);
    }

    @Override
    public DocumentDto save(DocumentDto dto) {
        Document document = mapper.toEntity(dto);
        Document savedDocument = repository.save(document);
        return mapper.toDto(savedDocument);
    }

    @Override
    @Transactional
    public DocumentDto update(DocumentDto dto) {

        Document entity = repository.findById(dto.getId())
                .orElseThrow(DocumentNotfoundException::new);

        //TODO updatable filed code

        entity.setChecksum(dto.getChecksum());
        entity.setLength(dto.getLength());
        entity.setName(dto.getName());

        Document updatedEntity = repository.save(entity);

        return mapper.toDto(updatedEntity);
    }

    @Override
    @Transactional
    public void delete(long id) {
        repository.deleteById(id);
    }

    public List<Document> retrieveDocumentWhitDocumentId(List<Long> documentIds) {

        if (!CollectionUtils.isEmpty(documentIds)) {

            List<Document> documentList = new ArrayList<>();

            documentIds.forEach(id -> {

                Document document = repository.findById(id)
                        .orElseThrow(DocumentNotfoundException::new);

                documentList.add(document);

            });

            return documentList;
        }

        return Collections.emptyList();
    }


}
