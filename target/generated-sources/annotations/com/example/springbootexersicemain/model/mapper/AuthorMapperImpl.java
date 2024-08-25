package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.AuthorDto;
import com.example.springbootexersicemain.model.dto.BookDto;
import com.example.springbootexersicemain.model.entity.Author;
import com.example.springbootexersicemain.model.entity.Book;
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
public class AuthorMapperImpl implements AuthorMapper {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public AuthorDto mapToDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setBooks( bookListToBookDtoList( author.getBooks() ) );
        authorDto.setId( author.getId() );
        authorDto.setName( author.getName() );
        authorDto.setGenre( author.getGenre() );
        authorDto.setAge( author.getAge() );

        return authorDto;
    }

    @Override
    public List<AuthorDto> mapToDtoList(List<Author> authorList) {
        if ( authorList == null ) {
            return null;
        }

        List<AuthorDto> list = new ArrayList<AuthorDto>( authorList.size() );
        for ( Author author : authorList ) {
            list.add( mapToDto( author ) );
        }

        return list;
    }

    protected List<BookDto> bookListToBookDtoList(List<Book> list) {
        if ( list == null ) {
            return null;
        }

        List<BookDto> list1 = new ArrayList<BookDto>( list.size() );
        for ( Book book : list ) {
            list1.add( bookMapper.mapToDto( book ) );
        }

        return list1;
    }
}
