package com.example.springbootexersicemain.service.impl;

import com.example.springbootexersicemain.model.dto.OptionDto;
import com.example.springbootexersicemain.model.entity.Option;
import com.example.springbootexersicemain.model.mapper.OptionMapper;
import com.example.springbootexersicemain.repository.OptionRepository;
import com.example.springbootexersicemain.service.facade.OptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository repository;
    private final OptionMapper mapper;

    public OptionServiceImpl(OptionRepository repository, OptionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public OptionDto.SelectOptionDto save(OptionDto.InsertOptionDto dto) {

        Option entity = mapper.toEntity(dto);
        repository.save(entity);
        return mapper.toDto(entity);
    }
}
