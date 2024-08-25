package com.example.springbootexersicemain.service.facade;

import com.example.springbootexersicemain.model.dto.PostDto;
import com.example.springbootexersicemain.model.entity.Post;

import java.util.List;

public interface PostService {

    List<PostDto.Transfer> select();

    Post save(Post post);

    Post update(Post post);

    List<String> selectSlugIsVipTrueStream();

    List<String> selectSlugIsVipTrueQuery();

    boolean checkAnyMatch();

    boolean checkNonMatch();

    PostDto checkFindFirst();

    PostDto checkFindAny();

    List<String> checkOptional(PostDto.UpdatePostDto dto);

    Object optionalNullable(PostDto.InsertPostDto dto);

    List<Post> saveAll(List<Post> posts);

    void delete(Long id);

    void deleteAll(List<Long> ids);
}
