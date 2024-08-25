package com.example.springbootexersicemain.service.facade;

import com.example.springbootexersicemain.model.dto.RoleDto;

import java.util.List;

public interface RoleService {

    List<RoleDto> select();

    RoleDto save(RoleDto.InsertRoleDto dto);

    void delete(long id);

    List<RoleDto> findAllRolesByRoleIds(List<Long> roleIds);

    RoleDto getRoleByIdUsingQueryParam(Long id);
}
