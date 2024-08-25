package com.example.springbootexersicemain.service.facade;

import com.example.springbootexersicemain.model.dto.UserDto;
import com.example.springbootexersicemain.model.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<UserDto> select();

    UserDto save(UserDto.InsertUserDto dto);

    UserDto update(UserDto dto);

    void delete(long id);

    User findOptionalEntityById(long userId);

    List<Map<Integer, Integer>> selectByNumberOfRepeat();

    List<String> checkFlatMap();

    UserDto getUserByIdUsingQueryParam(Long id);
}
