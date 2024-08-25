package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.OptionDto;
import com.example.springbootexersicemain.model.dto.OptionDto.InsertOptionDto;
import com.example.springbootexersicemain.model.dto.OptionDto.SelectOptionDto;
import com.example.springbootexersicemain.model.dto.QuestionDto.SelectQuestionDto;
import com.example.springbootexersicemain.model.entity.Option;
import com.example.springbootexersicemain.model.entity.Question;
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
public class OptionMapperImpl implements OptionMapper {

    @Override
    public Option toEntity(InsertOptionDto dto) {
        if ( dto == null ) {
            return null;
        }

        Option option = new Option();

        option.setNumber( dto.getNumber() );

        return option;
    }

    @Override
    public SelectOptionDto toDto(Option option) {
        if ( option == null ) {
            return null;
        }

        SelectOptionDto selectOptionDto = new SelectOptionDto();

        selectOptionDto.setId( option.getId() );
        selectOptionDto.setNumber( option.getNumber() );
        selectOptionDto.setQuestion( questionToSelectQuestionDto( option.getQuestion() ) );

        return selectOptionDto;
    }

    @Override
    public OptionDto map(Option option) {
        if ( option == null ) {
            return null;
        }

        OptionDto optionDto = new OptionDto();

        return optionDto;
    }

    protected List<OptionDto> optionListToOptionDtoList(List<Option> list) {
        if ( list == null ) {
            return null;
        }

        List<OptionDto> list1 = new ArrayList<OptionDto>( list.size() );
        for ( Option option : list ) {
            list1.add( map( option ) );
        }

        return list1;
    }

    protected SelectQuestionDto questionToSelectQuestionDto(Question question) {
        if ( question == null ) {
            return null;
        }

        SelectQuestionDto selectQuestionDto = new SelectQuestionDto();

        selectQuestionDto.setId( question.getId() );
        selectQuestionDto.setQuestionNumber( question.getQuestionNumber() );
        selectQuestionDto.setOptions( optionListToOptionDtoList( question.getOptions() ) );

        return selectQuestionDto;
    }
}
