package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.DocumentDto;
import com.example.springbootexersicemain.model.dto.VersionHistoryDetailDto;
import com.example.springbootexersicemain.model.entity.Document;
import com.example.springbootexersicemain.model.entity.VersionHistoryDetail;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-01T15:15:34+0330",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class VersionHistoryDetailMapperImpl implements VersionHistoryDetailMapper {

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public VersionHistoryDetailDto toDto(VersionHistoryDetail versionHistoryDetail) {
        if ( versionHistoryDetail == null ) {
            return null;
        }

        VersionHistoryDetailDto versionHistoryDetailDto = new VersionHistoryDetailDto();

        versionHistoryDetailDto.setId( versionHistoryDetail.getId() );
        versionHistoryDetailDto.setHistoryDate( versionHistoryDetail.getHistoryDate() );
        versionHistoryDetailDto.setTitle( versionHistoryDetail.getTitle() );
        versionHistoryDetailDto.setDescription( versionHistoryDetail.getDescription() );
        versionHistoryDetailDto.setDocument( documentMapper.toDtoList( versionHistoryDetail.getDocument() ) );

        return versionHistoryDetailDto;
    }

    @Override
    public VersionHistoryDetail toEntity(VersionHistoryDetailDto dto) {
        if ( dto == null ) {
            return null;
        }

        VersionHistoryDetail versionHistoryDetail = new VersionHistoryDetail();

        versionHistoryDetail.setId( dto.getId() );
        versionHistoryDetail.setHistoryDate( dto.getHistoryDate() );
        versionHistoryDetail.setTitle( dto.getTitle() );
        versionHistoryDetail.setDescription( dto.getDescription() );
        versionHistoryDetail.setDocument( documentDtoListToDocumentList( dto.getDocument() ) );

        return versionHistoryDetail;
    }

    @Override
    public List<VersionHistoryDetail> toEntityList(List<VersionHistoryDetailDto> dto) {
        if ( dto == null ) {
            return null;
        }

        List<VersionHistoryDetail> list = new ArrayList<VersionHistoryDetail>( dto.size() );
        for ( VersionHistoryDetailDto versionHistoryDetailDto : dto ) {
            list.add( toEntity( versionHistoryDetailDto ) );
        }

        return list;
    }

    protected List<Document> documentDtoListToDocumentList(List<DocumentDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Document> list1 = new ArrayList<Document>( list.size() );
        for ( DocumentDto documentDto : list ) {
            list1.add( documentMapper.toEntity( documentDto ) );
        }

        return list1;
    }
}
