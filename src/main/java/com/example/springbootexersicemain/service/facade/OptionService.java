package com.example.springbootexersicemain.service.facade;

import com.example.springbootexersicemain.model.dto.OptionDto;

public interface OptionService {

    OptionDto.SelectOptionDto save(OptionDto.InsertOptionDto dto);

}
