package com.example.springbootexersicemain.controller;

import com.example.springbootexersicemain.model.dto.VersionHistoryDto;
import com.example.springbootexersicemain.service.facade.VersionHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/version_history")
public class VersionHistoryRest {

    private final VersionHistoryService service;

    public VersionHistoryRest(VersionHistoryService service) {
        this.service = service;
    }

    @PostMapping(path = "/save_version_history")
    public ResponseEntity<VersionHistoryDto> save(@RequestBody @Valid VersionHistoryDto.InsertVersionHistoryDto dto)  {
        return ResponseEntity.ok(service.save(dto));
    }
}
