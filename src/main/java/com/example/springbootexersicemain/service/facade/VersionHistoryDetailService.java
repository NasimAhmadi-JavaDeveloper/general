package com.example.springbootexersicemain.service.facade;

import com.example.springbootexersicemain.model.dto.VersionHistoryDetailDto;
import com.example.springbootexersicemain.model.entity.VersionHistoryDetail;

import java.util.List;

public interface VersionHistoryDetailService {

    List<VersionHistoryDetail> saveAll(List<VersionHistoryDetailDto> dto);

}
