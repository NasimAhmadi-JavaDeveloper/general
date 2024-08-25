package com.example.springbootexersicemain.service.impl;

import com.example.springbootexersicemain.exception.CustomException;
import com.example.springbootexersicemain.exception.PostNotfoundException;
import com.example.springbootexersicemain.exception.UniqueConstraintException;
import com.example.springbootexersicemain.exception.UserNotfoundException;
import com.example.springbootexersicemain.model.dto.PostDto;
import com.example.springbootexersicemain.model.entity.Post;
import com.example.springbootexersicemain.model.entity.User;
import com.example.springbootexersicemain.model.enums.PostType;
import com.example.springbootexersicemain.model.mapper.PostMapper;
import com.example.springbootexersicemain.repository.PostRepository;
import com.example.springbootexersicemain.service.facade.PostService;
import com.example.springbootexersicemain.service.facade.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostMapper mapper;
    private final PostRepository repository;
    private final UserService userService;

    @Lazy
    public PostServiceImpl(PostMapper mapper, PostRepository repository, UserService userService) {
        this.mapper = mapper;
        this.repository = repository;
        this.userService = userService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostDto.Transfer> select() {
        // hala miram model haye dige masalam post put mizanam
        //mitony ersale @RequestParam , ersale BODY va inaro tamrin kony

        String url = "http://localhost:8090/api/weather_condition/select_average_and_temperature";
        new RestTemplate().getForObject(url, Object.class);

        List<Post> posts = repository.findAll();
        return mapper.entityToDtoList(posts);
    }

    @Override
    @Transactional
    public Post save(Post entity) {
//        PostDto.builder()
//                .body(dto.getBody())
//                .slug(dto.getSlug())
//                .summary(dto.getSummary())
//                .title(dto.getTitle())
//                .isVip(dto.getVip())
//                .userId(dto.getUserId())
//                .body(dto.getBody())
//                .postType(dto.getPostType())
//                .build();
        checkUniqueConstraint(entity.getTitle(), entity.getSlug(), null);

        return repository.save(entity);
    }

    @Override
    @Transactional
    public Post update(Post post) { //test konam

        Post entity = repository.findById(post.getId())
                .orElseThrow(PostNotfoundException::new);

        checkUniqueConstraint(post.getTitle(), post.getSlug(), post.getId());

        entity.setTitle(post.getTitle());
        entity.setBody(post.getBody());
        entity.setSummary(post.getSummary());
        entity.setSlug(post.getSlug());
        entity.setVip(post.getVip());
        entity.setPostType(post.getPostType());
        //  entity.setUser(handleUser(dto.getUserId()));

        return repository.save(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Post entity = repository.findById(id)
                .orElseThrow(PostNotfoundException::new);

        repository.delete(entity);
    }

    @Override
    @Transactional
    public List<Post> saveAll(List<Post> posts) {

        for (Post post : posts) {
            checkUniqueConstraint(post.getTitle(), post.getSlug(), post.getId());
        }
        return repository.saveAll(posts);
    }

    private User handleUser(Long userId) {
        if (ObjectUtils.isEmpty(userId)) {
            throw new UserNotfoundException();
        }

        return userService.findOptionalEntityById(userId);
    }

    @Override
    @Transactional
    public void deleteAll(List<Long> ids) {
        repository.deleteAllById(ids);
    }

    private void checkUniqueConstraint(String title, String slug, Long id) {
        Post entity = repository.findPostByTitleAndSlug(title, slug);

        // if (!ObjectUtils.isEmpty(entity) && !entity.getId().equals(id)) {
        if (Objects.nonNull(entity) && !Objects.equals(entity.getId(), id)) {
            throw new UniqueConstraintException();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> selectSlugIsVipTrueStream() {
        return repository.findAll()
                .stream()
                .filter(post -> Boolean.TRUE.equals(post.getVip()))
//                .filter(post -> post.getVip().equals(true))
                .filter(post -> Objects.nonNull(post.getSlug()))
                .map(Post::getSlug)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> selectSlugIsVipTrueQuery() {

        //   List<String> slugsList = new ArrayList<String>(); slugsList is Empty
        List<String> slugsList = repository.findAllSlug();

        //if (!slugsList.isEmpty()) {
        if (!CollectionUtils.isEmpty(slugsList)) {
            return slugsList;

        }
        return Collections.emptyList();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkAnyMatch() {
        List<Post> list = repository.findAll();
        return list.stream()
                .map(Post::getTitle)
                .anyMatch(s -> s.equals("ww"));//if there is getTitle == ww -> true
//        return list.stream()
//                .map(Post::getTitle)
//                .anyMatch(s -> s.equals("kkllloooppp"));//false

//        for (Post p : list) {
//            // if(p.getTitle().equals("ww")) {
//            if ("ww".equals(p.getTitle())) {
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkNonMatch() {
        List<Post> list = repository.findAll();

        return list.stream()
                .filter(post -> Objects.nonNull(post.getSlug()))
                .filter(post -> Objects.nonNull(post.getTitle()))
                .map(Post::getPostType)
                .noneMatch(c -> c.equals(PostType.PODCAST));
//        return list.stream()
//                .filter(post -> Objects.nonNull(post.getSlug()))
//                .filter(post -> Objects.nonNull(post.getTitle()))
//                .map(Post::getPostType)
//                .noneMatch(c -> c.equals(PostType.VIDEO));//if is VIDEO = false
    }

    @Override
    @Transactional(readOnly = true)
    public PostDto checkFindFirst() {

        Post entity = repository.findAll()
                .stream()
                //.filter(post -> post.getSlug().equals("string"))
                .filter(post -> "yyyyyyyyyyy".equals(post.getSlug()))
                .findFirst()
                //.orElse(null);
                .orElseThrow(CustomException::new);
//        Post entity = repository.findAll()
//                .stream()
//                // .filter(post -> post.getVip().equals(true))
//                .filter(post -> Boolean.TRUE.equals(post.getVip()))
//                .findFirst()
//                .orElseThrow(CustomException::new);
        return mapper.entityToDto(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public PostDto checkFindAny() {

        Post entity = repository.findAll()
                .stream()
                .filter(post -> post.getVip().equals(false))
                .findAny()
                .orElseThrow(CustomException::new);

        return mapper.entityToDto(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> checkOptional(PostDto.UpdatePostDto dto) {

        Optional<Post> result = repository.findById(dto.getId());

        if (result.isPresent()) {
            throw new PostNotfoundException();
        }

        List<Post> posts = repository.findAll();
        return posts.stream()
                .map(Post::getTitle)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Object optionalNullable(PostDto.InsertPostDto dto) {

//        if (dto != null) {
//            PostType postType = dto.getPostType();
//
//            if (postType != null && postType.equals(PostType.VIDEO))
//                return PostType.VIDEO;
//        }
//        return PostType.PODCAST;

        //-------
        return Optional.ofNullable(dto)
                .map(dto1 -> dto1.getPostType())
                .filter(postType -> PostType.VIDEO.equals(postType)) //if
                .map(postType -> PostType.VIDEO) // return
                .orElse(PostType.PODCAST); // else
    }
}
