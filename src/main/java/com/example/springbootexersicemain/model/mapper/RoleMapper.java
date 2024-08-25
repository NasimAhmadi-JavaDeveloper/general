package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.RoleDto;
import com.example.springbootexersicemain.model.entity.Role;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface RoleMapper {

    RoleDto toDto(Role role);

    Role toEntity(RoleDto.InsertRoleDto dto);

    Role dtoToEntity(RoleDto roles);

    List<RoleDto> entityToDtoList(List<Role> roles);

}
