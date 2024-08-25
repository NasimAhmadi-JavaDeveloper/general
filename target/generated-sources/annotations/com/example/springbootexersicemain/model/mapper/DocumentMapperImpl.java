package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.DocumentDto;
import com.example.springbootexersicemain.model.entity.Document;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-23T16:34:55+0330",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class DocumentMapperImpl implements DocumentMapper {

    @Override
    public List<DocumentDto> toDtoList(List<Document> document) {
        if ( document == null ) {
            return null;
        }

        List<DocumentDto> list = new ArrayList<DocumentDto>( document.size() );
        for ( Document document1 : document ) {
            list.add( toDto( document1 ) );
        }

        return list;
    }

    @Override
    public DocumentDto toDto(Document document) {
        if ( document == null ) {
            return null;
        }

        DocumentDto documentDto = new DocumentDto();

        documentDto.setId( document.getId() );
        documentDto.setName( document.getName() );
        documentDto.setLength( document.getLength() );
        documentDto.setChecksum( document.getChecksum() );

        return documentDto;
    }

    @Override
    public Document toEntity(DocumentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Document document = new Document();

        document.setId( dto.getId() );
        document.setName( dto.getName() );
        document.setChecksum( dto.getChecksum() );
        document.setLength( dto.getLength() );

        return document;
    }
}
