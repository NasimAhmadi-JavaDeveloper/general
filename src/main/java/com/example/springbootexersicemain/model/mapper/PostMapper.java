package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.PostDto;
import com.example.springbootexersicemain.model.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PostMapper {

    @Mapping(target = "userId", source = "user.id")
    List<PostDto.Transfer> entityToDtoList(List<Post> posts); //1 list

    @Mapping(target = "userId", source = "user.id")
    PostDto.Transfer entityToDtoTransfer(Post posts); //2 object

    PostDto entityToDto(Post post);

}
