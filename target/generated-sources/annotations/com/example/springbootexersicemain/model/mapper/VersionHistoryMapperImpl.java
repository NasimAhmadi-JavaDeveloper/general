package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.DocumentDto;
import com.example.springbootexersicemain.model.dto.DocumentDto.InsertDocumentDto;
import com.example.springbootexersicemain.model.dto.VersionHistoryDetailDto;
import com.example.springbootexersicemain.model.dto.VersionHistoryDetailDto.InsertVersionHistoryDetailDto;
import com.example.springbootexersicemain.model.dto.VersionHistoryDto;
import com.example.springbootexersicemain.model.dto.VersionHistoryDto.InsertVersionHistoryDto;
import com.example.springbootexersicemain.model.entity.Document;
import com.example.springbootexersicemain.model.entity.VersionHistory;
import com.example.springbootexersicemain.model.entity.VersionHistoryDetail;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-23T16:34:55+0330",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class VersionHistoryMapperImpl implements VersionHistoryMapper {

    @Autowired
    private VersionHistoryDetailMapper versionHistoryDetailMapper;

    @Override
    public VersionHistory toEntity(InsertVersionHistoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        VersionHistory versionHistory = new VersionHistory();

        versionHistory.setVersionNumber( dto.getVersionNumber() );
        versionHistory.setVersionHistoryDetail( insertVersionHistoryDetailDtoListToVersionHistoryDetailList( dto.getVersionHistoryDetail() ) );

        return versionHistory;
    }

    @Override
    public VersionHistoryDto toDto(VersionHistory versionHistory) {
        if ( versionHistory == null ) {
            return null;
        }

        VersionHistoryDto versionHistoryDto = new VersionHistoryDto();

        versionHistoryDto.setId( versionHistory.getId() );
        versionHistoryDto.setVersionNumber( versionHistory.getVersionNumber() );
        versionHistoryDto.setVersionHistoryDetail( versionHistoryDetailListToVersionHistoryDetailDtoList( versionHistory.getVersionHistoryDetail() ) );

        return versionHistoryDto;
    }

    @Override
    public VersionHistoryDto toVersionHistoryDto(InsertVersionHistoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        VersionHistoryDto versionHistoryDto = new VersionHistoryDto();

        versionHistoryDto.setVersionNumber( dto.getVersionNumber() );
        versionHistoryDto.setVersionHistoryDetail( insertVersionHistoryDetailDtoListToVersionHistoryDetailDtoList( dto.getVersionHistoryDetail() ) );

        return versionHistoryDto;
    }

    protected Document insertDocumentDtoToDocument(InsertDocumentDto insertDocumentDto) {
        if ( insertDocumentDto == null ) {
            return null;
        }

        Document document = new Document();

        document.setName( insertDocumentDto.getName() );
        document.setChecksum( insertDocumentDto.getChecksum() );
        document.setLength( insertDocumentDto.getLength() );

        return document;
    }

    protected List<Document> insertDocumentDtoListToDocumentList(List<InsertDocumentDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Document> list1 = new ArrayList<Document>( list.size() );
        for ( InsertDocumentDto insertDocumentDto : list ) {
            list1.add( insertDocumentDtoToDocument( insertDocumentDto ) );
        }

        return list1;
    }

    protected VersionHistoryDetail insertVersionHistoryDetailDtoToVersionHistoryDetail(InsertVersionHistoryDetailDto insertVersionHistoryDetailDto) {
        if ( insertVersionHistoryDetailDto == null ) {
            return null;
        }

        VersionHistoryDetail versionHistoryDetail = new VersionHistoryDetail();

        versionHistoryDetail.setHistoryDate( insertVersionHistoryDetailDto.getHistoryDate() );
        versionHistoryDetail.setTitle( insertVersionHistoryDetailDto.getTitle() );
        versionHistoryDetail.setDescription( insertVersionHistoryDetailDto.getDescription() );
        versionHistoryDetail.setDocument( insertDocumentDtoListToDocumentList( insertVersionHistoryDetailDto.getDocument() ) );

        return versionHistoryDetail;
    }

    protected List<VersionHistoryDetail> insertVersionHistoryDetailDtoListToVersionHistoryDetailList(List<InsertVersionHistoryDetailDto> list) {
        if ( list == null ) {
            return null;
        }

        List<VersionHistoryDetail> list1 = new ArrayList<VersionHistoryDetail>( list.size() );
        for ( InsertVersionHistoryDetailDto insertVersionHistoryDetailDto : list ) {
            list1.add( insertVersionHistoryDetailDtoToVersionHistoryDetail( insertVersionHistoryDetailDto ) );
        }

        return list1;
    }

    protected List<VersionHistoryDetailDto> versionHistoryDetailListToVersionHistoryDetailDtoList(List<VersionHistoryDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<VersionHistoryDetailDto> list1 = new ArrayList<VersionHistoryDetailDto>( list.size() );
        for ( VersionHistoryDetail versionHistoryDetail : list ) {
            list1.add( versionHistoryDetailMapper.toDto( versionHistoryDetail ) );
        }

        return list1;
    }

    protected DocumentDto insertDocumentDtoToDocumentDto(InsertDocumentDto insertDocumentDto) {
        if ( insertDocumentDto == null ) {
            return null;
        }

        DocumentDto documentDto = new DocumentDto();

        documentDto.setName( insertDocumentDto.getName() );
        documentDto.setLength( insertDocumentDto.getLength() );
        documentDto.setChecksum( insertDocumentDto.getChecksum() );

        return documentDto;
    }

    protected List<DocumentDto> insertDocumentDtoListToDocumentDtoList(List<InsertDocumentDto> list) {
        if ( list == null ) {
            return null;
        }

        List<DocumentDto> list1 = new ArrayList<DocumentDto>( list.size() );
        for ( InsertDocumentDto insertDocumentDto : list ) {
            list1.add( insertDocumentDtoToDocumentDto( insertDocumentDto ) );
        }

        return list1;
    }

    protected VersionHistoryDetailDto insertVersionHistoryDetailDtoToVersionHistoryDetailDto(InsertVersionHistoryDetailDto insertVersionHistoryDetailDto) {
        if ( insertVersionHistoryDetailDto == null ) {
            return null;
        }

        VersionHistoryDetailDto versionHistoryDetailDto = new VersionHistoryDetailDto();

        versionHistoryDetailDto.setHistoryDate( insertVersionHistoryDetailDto.getHistoryDate() );
        versionHistoryDetailDto.setTitle( insertVersionHistoryDetailDto.getTitle() );
        versionHistoryDetailDto.setDescription( insertVersionHistoryDetailDto.getDescription() );
        List<Long> list = insertVersionHistoryDetailDto.getDocumentIds();
        if ( list != null ) {
            versionHistoryDetailDto.setDocumentIds( new ArrayList<Long>( list ) );
        }
        versionHistoryDetailDto.setDocument( insertDocumentDtoListToDocumentDtoList( insertVersionHistoryDetailDto.getDocument() ) );

        return versionHistoryDetailDto;
    }

    protected List<VersionHistoryDetailDto> insertVersionHistoryDetailDtoListToVersionHistoryDetailDtoList(List<InsertVersionHistoryDetailDto> list) {
        if ( list == null ) {
            return null;
        }

        List<VersionHistoryDetailDto> list1 = new ArrayList<VersionHistoryDetailDto>( list.size() );
        for ( InsertVersionHistoryDetailDto insertVersionHistoryDetailDto : list ) {
            list1.add( insertVersionHistoryDetailDtoToVersionHistoryDetailDto( insertVersionHistoryDetailDto ) );
        }

        return list1;
    }
}
