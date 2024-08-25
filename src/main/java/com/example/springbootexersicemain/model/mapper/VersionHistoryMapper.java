package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.VersionHistoryDto;
import com.example.springbootexersicemain.model.entity.VersionHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = VersionHistoryDetailMapper.class)
public interface VersionHistoryMapper {

    VersionHistory toEntity(VersionHistoryDto.InsertVersionHistoryDto dto);

    VersionHistoryDto toDto(VersionHistory versionHistory);

    VersionHistoryDto toVersionHistoryDto(VersionHistoryDto.InsertVersionHistoryDto dto);
}
