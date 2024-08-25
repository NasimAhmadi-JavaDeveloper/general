package com.example.springbootexersicemain.service.facade;

import com.example.springbootexersicemain.model.dto.VersionHistoryDto;

public interface VersionHistoryService {

    VersionHistoryDto save(VersionHistoryDto.InsertVersionHistoryDto dto);
}
