package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.VersionHistoryDetailDto;
import com.example.springbootexersicemain.model.entity.VersionHistoryDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = DocumentMapper.class)
public interface VersionHistoryDetailMapper {

    VersionHistoryDetailDto toDto(VersionHistoryDetail versionHistoryDetail);

    VersionHistoryDetail toEntity(VersionHistoryDetailDto dto);

    List<VersionHistoryDetail> toEntityList(List<VersionHistoryDetailDto> dto);

}
