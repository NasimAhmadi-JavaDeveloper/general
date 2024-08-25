package com.example.springbootexersicemain.service.impl;

import com.example.springbootexersicemain.exception.UniqueConstraintException;
import com.example.springbootexersicemain.model.dto.VersionHistoryDetailDto;
import com.example.springbootexersicemain.model.entity.Document;
import com.example.springbootexersicemain.model.entity.VersionHistoryDetail;
import com.example.springbootexersicemain.model.mapper.VersionHistoryDetailMapper;
import com.example.springbootexersicemain.repository.VersionHistoryDetailRepository;
import com.example.springbootexersicemain.service.facade.DocumentService;
import com.example.springbootexersicemain.service.facade.VersionHistoryDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VersionHistoryDetailServiceImpl implements VersionHistoryDetailService {

    private final VersionHistoryDetailRepository repository;
    private final VersionHistoryDetailMapper mapper;
    private final DocumentService documentService;

    public VersionHistoryDetailServiceImpl(VersionHistoryDetailRepository repository, VersionHistoryDetailMapper mapper, DocumentService documentService) {
        this.repository = repository;
        this.mapper = mapper;
        this.documentService = documentService;
    }

    @Override
    @Transactional
    public List<VersionHistoryDetail> saveAll(List<VersionHistoryDetailDto> dtoList) {

        if (!CollectionUtils.isEmpty(dtoList)) {

            dtoList.forEach(item -> {

                checkUniqueConstraint(item.getTitle(), item.getDescription(), null);

            });

            List<VersionHistoryDetail> entityList = mapper.toEntityList(dtoList);

            entityList.forEach(entity -> entity.setDocument(getDocumentWhitDocumentId(entity)));

            return repository.saveAll(entityList);
        }

        return Collections.emptyList();
    }

    private List<Document> getDocumentWhitDocumentId(VersionHistoryDetail entity) {
        return documentService.retrieveDocumentWhitDocumentId(entity
                .getDocument()
                .stream()
                .map(Document::getId)
                .collect(Collectors.toList()));
    }


    private void checkUniqueConstraint(String title, String description, Long id) {

        VersionHistoryDetail entity = repository.findVersionHistoryDetailByTitleAndDescription(title, description);

        if (ObjectUtils.isEmpty(entity) && !Objects.equals(entity.getId(), id)) {

            throw new UniqueConstraintException();
        }
    }
}
