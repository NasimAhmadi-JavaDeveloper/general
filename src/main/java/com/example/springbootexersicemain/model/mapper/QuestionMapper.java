package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.QuestionDto;
import com.example.springbootexersicemain.model.entity.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = OptionMapper.class)
public interface QuestionMapper {

    //QuestionDto.SelectQuestionDto toDto(Question question);

    //QuestionDto map(Question question);

    Question toEntity(QuestionDto.SelectQuestionDto question);

}
