package com.example.springbootexersicemain.service.impl;

import com.example.springbootexersicemain.model.dto.VersionHistoryDetailDto;
import com.example.springbootexersicemain.model.dto.VersionHistoryDto;
import com.example.springbootexersicemain.model.entity.VersionHistory;
import com.example.springbootexersicemain.model.entity.VersionHistoryDetail;
import com.example.springbootexersicemain.model.mapper.VersionHistoryMapper;
import com.example.springbootexersicemain.repository.VersionHistoryRepository;
import com.example.springbootexersicemain.service.facade.VersionHistoryDetailService;
import com.example.springbootexersicemain.service.facade.VersionHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VersionHistoryServiceImpl implements VersionHistoryService {

    private final VersionHistoryRepository repository;
    private final VersionHistoryMapper mapper;
    private final VersionHistoryDetailService versionHistoryDetailService;

    public VersionHistoryServiceImpl(VersionHistoryRepository repository, VersionHistoryMapper mapper, VersionHistoryDetailService versionHistoryDetailService) {
        this.repository = repository;
        this.mapper = mapper;
        this.versionHistoryDetailService = versionHistoryDetailService;
    }

    @Override
    @Transactional
    public VersionHistoryDto save(VersionHistoryDto.InsertVersionHistoryDto dto) {

        VersionHistory entity = mapper.toEntity(dto);

        VersionHistoryDto versionHistoryDto = mapper.toVersionHistoryDto(dto);

        entity.setVersionHistoryDetail(saveVersionHistoryDetail(versionHistoryDto.getVersionHistoryDetail()));

        repository.save(entity);

        return mapper.toDto(entity);
    }

    private List<VersionHistoryDetail> saveVersionHistoryDetail(List<VersionHistoryDetailDto> versionHistoryDetails) {
        return versionHistoryDetailService.saveAll(versionHistoryDetails);
    }


}
