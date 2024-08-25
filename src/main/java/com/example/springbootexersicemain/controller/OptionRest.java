package com.example.springbootexersicemain.controller;

import com.example.springbootexersicemain.model.dto.OptionDto;
import com.example.springbootexersicemain.service.facade.OptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/option")
public class OptionRest {

    private final OptionService service;

    public OptionRest(OptionService service) {
        this.service = service;
    }

    @PostMapping(path = "/save_option")
    public ResponseEntity<OptionDto.SelectOptionDto> save(@RequestBody @Valid OptionDto.InsertOptionDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}
