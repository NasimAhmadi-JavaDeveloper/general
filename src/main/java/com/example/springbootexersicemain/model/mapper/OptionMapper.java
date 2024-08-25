package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.OptionDto;
import com.example.springbootexersicemain.model.entity.Option;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = QuestionMapper.class)
public interface OptionMapper {

    //@Mapping(source = "question.id", target = "questionId")
    Option toEntity(OptionDto.InsertOptionDto dto);

    OptionDto.SelectOptionDto toDto(Option option);

    OptionDto map(Option option);
}