package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.UserDto;
import com.example.springbootexersicemain.model.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class, PostMapper.class})
public interface UserMapper {

    UserDto insertUserToUser(UserDto.InsertUserDto dto);

    List<UserDto> entityListToDtoList(List<User> users);

    UserDto entityToDto(User user);

    User dtoToEntity(UserDto dto);
}
