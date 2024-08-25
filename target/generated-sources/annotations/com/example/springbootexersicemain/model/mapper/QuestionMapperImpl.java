package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.OptionDto;
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
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question toEntity(SelectQuestionDto question) {
        if ( question == null ) {
            return null;
        }

        Question question1 = new Question();

        question1.setId( question.getId() );
        question1.setQuestionNumber( question.getQuestionNumber() );
        question1.setOptions( optionDtoListToOptionList( question.getOptions() ) );

        return question1;
    }

    protected Option optionDtoToOption(OptionDto optionDto) {
        if ( optionDto == null ) {
            return null;
        }

        Option option = new Option();

        return option;
    }

    protected List<Option> optionDtoListToOptionList(List<OptionDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Option> list1 = new ArrayList<Option>( list.size() );
        for ( OptionDto optionDto : list ) {
            list1.add( optionDtoToOption( optionDto ) );
        }

        return list1;
    }
}
