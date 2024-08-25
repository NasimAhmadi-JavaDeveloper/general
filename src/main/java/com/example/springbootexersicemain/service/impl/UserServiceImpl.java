package com.example.springbootexersicemain.service.impl;

import com.example.springbootexersicemain.exception.UniqueConstraintException;
import com.example.springbootexersicemain.exception.UserNotfoundException;
import com.example.springbootexersicemain.model.dto.PostDto;
import com.example.springbootexersicemain.model.dto.RoleDto;
import com.example.springbootexersicemain.model.dto.UserDto;
import com.example.springbootexersicemain.model.entity.Post;
import com.example.springbootexersicemain.model.entity.Role;
import com.example.springbootexersicemain.model.entity.User;
import com.example.springbootexersicemain.model.mapper.PostMapper;
import com.example.springbootexersicemain.model.mapper.RoleMapper;
import com.example.springbootexersicemain.model.mapper.UserMapper;
import com.example.springbootexersicemain.repository.UserRepository;
import com.example.springbootexersicemain.service.facade.PostService;
import com.example.springbootexersicemain.service.facade.RoleService;
import com.example.springbootexersicemain.service.facade.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final RoleService roleService;
    private final RoleMapper roleMapper;
    private final PostService postService;
    private final PostMapper postMapper;

    public UserServiceImpl(UserRepository repository, UserMapper mapper, RoleService roleService, RoleMapper roleMapper, PostService postService, PostMapper postMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.roleService = roleService;
        this.roleMapper = roleMapper;
        this.postService = postService;
        this.postMapper = postMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> select() {

//        String url = "http://localhost:8090/api/city/select_min_and_max_temperature_city";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Accept", "/*");
//        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

//        new RestTemplate().exchange(
//                url,
//
//                HttpMethod.GET,
//                //in baraye ersal body hastesh, get body nadare
//
//                new HttpEntity<>(Object.class, headers),
//
//                Object.class
//        );

        //httpclienterror yani khata az requeste va na server

        List<User> users = repository.findAll();
        return mapper.entityListToDtoList(users);
    }

    @Override
    @Transactional
    public UserDto save(UserDto.InsertUserDto dto) {

        checkUniqueConstraint(dto.getName(), dto.getPassword(), dto.getEmail(), null);

        UserDto userDto = mapper.insertUserToUser(dto);

        User entity = mapper.dtoToEntity(userDto);

        List<RoleDto> rolesDto = roleService.findAllRolesByRoleIds(dto.getRoleIds());
//        List<Role> rolesEntity = new ArrayList<>();
//        rolesDto.forEach(roleDto -> {
//            Role role = roleMapper.toEntity(roleDto);
//            rolesEntity.add(role);
//        });
        List<Role> rolesEntity = rolesDto
                .stream()
                .map(roleMapper::dtoToEntity)
                .collect(Collectors.toList());

        entity.setRoles(rolesEntity);//many to many always saved

        repository.save(entity);// 1) save master(parent)

        List<Post> posts = entity.getPosts();

        List<Post> userRegisteredInPostEntity = new ArrayList<>();

        for (Post post : posts) {
            post.setUser(entity); //** set fk in child
            userRegisteredInPostEntity.add(post);
        }

        entity.setPosts(postService.saveAll(userRegisteredInPostEntity)); //2) save detail

        return mapper.entityToDto(entity);
//        ObjectUtils.
//        ObjectUtils.isEmpty()
//        Objects.nonNull(user.getId());
//        Objects.isNull(user.getEmail());
//        Objects.requireNonNull(user.getName());
//        Objects.equals(user, user.getEmail());
//        CollectionUtils.isEmpty()
    }

    @Override
    @Transactional
    public UserDto update(UserDto dto) {

        User entity = repository.findById(dto.getId())
                .orElseThrow(UserNotfoundException::new);

        checkUniqueConstraint(dto.getName(), dto.getPassword(), dto.getEmail(), dto.getId());

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());

        //roleId//todo

        repository.save(entity);

        // if getPosts is null = NullPointerException -> dto @NotNull
        // List<Post> posts = postMapper.dtoToEntityList(dto.getPosts());
        List<Post> posts = mapper.dtoToEntity(dto).getPosts();

        posts.forEach(post -> {

            post.setUser(entity);

            if (Objects.isNull(post.getId())) {
                postService.save(post);

            } else {
                postService.update(post);
            }
        });

        //if getPosts is null = NullPointerException -> dto @NotNull
        List<Long> sentPostIds = dto.getPosts()
                .stream()
                .map(PostDto.Transfer::getId)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        List<Post> deletedPost = new ArrayList<>();//ConcurrentModificationException

        //if getPosts is null = NullPointerException
        entity.getPosts().forEach(post ->
        {
            if (!sentPostIds.contains(post.getId())) {
                deletedPost.add(post); //ConcurrentModificationException
            }
        });

        postService.deleteAll(deletedPost
                .stream()
                .map(Post::getId)
                .collect(Collectors.toList()));

        entity.getPosts().removeAll(deletedPost);

        return mapper.entityToDto(entity);
    }


    private void checkUniqueConstraint(String name, String password, String email, Long userId) {

        Optional<User> user = repository.findUserByNameAndPasswordAndEmail(name, password, email);//1

        if (user.isPresent() && !Objects.equals(user.get().getId(), userId)) {
            throw new UniqueConstraintException();
        }
        //---------------
//        User user = repository.findUserByNameAndPasswordAndEmail(name, password, email); //2
//
//        if (Objects.nonNull(user)) {
//            throw new UniqueConstraintException();
//        }
        //-------------

//        User user = repository.findUserByNameAndPasswordAndEmail(name, email, password);//3
//
//        Optional.of(user).orElseThrow(UniqueConstraintException::new);
    }

    @Override
    //@Transactional********
    public void delete(long id) {
        User u = findOptionalEntityById(id);

        if (u.getName().equals("aidin")) {
            throw new UserNotfoundException();
        }
        repository.delete(u);
    }

    @Override
    @Transactional(readOnly = true)
    public User findOptionalEntityById(long userId) {
        return repository.findById(userId).orElseThrow(UserNotfoundException::new);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map<Integer, Integer>> selectByNumberOfRepeat() {
        return repository.findByNumberOfRepeat();
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> checkFlatMap() {

        return repository.findAll()
                .stream()
                .map(User::getPosts)
                .flatMap(posts -> posts
                        .stream()
                        .map(Post::getTitle))
                .filter(Objects::nonNull)
                .filter("bb"::equals)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserByIdUsingQueryParam(Long id) {
        User user = repository.findById(id)
                .orElseThrow(UserNotfoundException::new);
        return mapper.entityToDto(user);
    }
}
