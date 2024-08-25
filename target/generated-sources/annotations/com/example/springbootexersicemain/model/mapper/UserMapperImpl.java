package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.PostDto.InsertPostDto;
import com.example.springbootexersicemain.model.dto.PostDto.Transfer;
import com.example.springbootexersicemain.model.dto.UserDto;
import com.example.springbootexersicemain.model.dto.UserDto.InsertUserDto;
import com.example.springbootexersicemain.model.entity.Post;
import com.example.springbootexersicemain.model.entity.Role;
import com.example.springbootexersicemain.model.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-23T16:34:55+0330",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private PostMapper postMapper;

    @Override
    public UserDto insertUserToUser(InsertUserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setName( dto.getName() );
        userDto.setPassword( dto.getPassword() );
        userDto.setEmail( dto.getEmail() );
        userDto.setPosts( insertPostDtoListToTransferList( dto.getPosts() ) );

        return userDto;
    }

    @Override
    public List<UserDto> entityListToDtoList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( entityToDto( user ) );
        }

        return list;
    }

    @Override
    public UserDto entityToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setPassword( user.getPassword() );
        userDto.setEmail( user.getEmail() );
        userDto.setCreateDate( user.getCreateDate() );
        userDto.setUpdateDate( user.getUpdateDate() );
        userDto.setRoles( roleListToTransferList( user.getRoles() ) );
        userDto.setPosts( postMapper.entityToDtoList( user.getPosts() ) );

        return userDto;
    }

    @Override
    public User dtoToEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setName( dto.getName() );
        user.setPassword( dto.getPassword() );
        user.setEmail( dto.getEmail() );
        user.setCreateDate( dto.getCreateDate() );
        user.setUpdateDate( dto.getUpdateDate() );
        user.setRoles( transferListToRoleList( dto.getRoles() ) );
        user.setPosts( transferListToPostList( dto.getPosts() ) );

        return user;
    }

    protected Transfer insertPostDtoToTransfer(InsertPostDto insertPostDto) {
        if ( insertPostDto == null ) {
            return null;
        }

        Transfer transfer = new Transfer();

        transfer.setTitle( insertPostDto.getTitle() );
        transfer.setBody( insertPostDto.getBody() );
        transfer.setSummary( insertPostDto.getSummary() );
        transfer.setSlug( insertPostDto.getSlug() );
        transfer.setVip( insertPostDto.getVip() );
        transfer.setPostType( insertPostDto.getPostType() );

        return transfer;
    }

    protected List<Transfer> insertPostDtoListToTransferList(List<InsertPostDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Transfer> list1 = new ArrayList<Transfer>( list.size() );
        for ( InsertPostDto insertPostDto : list ) {
            list1.add( insertPostDtoToTransfer( insertPostDto ) );
        }

        return list1;
    }

    protected com.example.springbootexersicemain.model.dto.RoleDto.Transfer roleToTransfer(Role role) {
        if ( role == null ) {
            return null;
        }

        com.example.springbootexersicemain.model.dto.RoleDto.Transfer transfer = new com.example.springbootexersicemain.model.dto.RoleDto.Transfer();

        transfer.setId( role.getId() );
        transfer.setCode( role.getCode() );
        transfer.setTitle( role.getTitle() );
        transfer.setCreateDate( role.getCreateDate() );
        transfer.setUpdateDate( role.getUpdateDate() );

        return transfer;
    }

    protected List<com.example.springbootexersicemain.model.dto.RoleDto.Transfer> roleListToTransferList(List<Role> list) {
        if ( list == null ) {
            return null;
        }

        List<com.example.springbootexersicemain.model.dto.RoleDto.Transfer> list1 = new ArrayList<com.example.springbootexersicemain.model.dto.RoleDto.Transfer>( list.size() );
        for ( Role role : list ) {
            list1.add( roleToTransfer( role ) );
        }

        return list1;
    }

    protected Role transferToRole(com.example.springbootexersicemain.model.dto.RoleDto.Transfer transfer) {
        if ( transfer == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( transfer.getId() );
        role.setCode( transfer.getCode() );
        role.setTitle( transfer.getTitle() );
        role.setCreateDate( transfer.getCreateDate() );
        role.setUpdateDate( transfer.getUpdateDate() );

        return role;
    }

    protected List<Role> transferListToRoleList(List<com.example.springbootexersicemain.model.dto.RoleDto.Transfer> list) {
        if ( list == null ) {
            return null;
        }

        List<Role> list1 = new ArrayList<Role>( list.size() );
        for ( com.example.springbootexersicemain.model.dto.RoleDto.Transfer transfer : list ) {
            list1.add( transferToRole( transfer ) );
        }

        return list1;
    }

    protected Post transferToPost(Transfer transfer) {
        if ( transfer == null ) {
            return null;
        }

        Post post = new Post();

        post.setVip( transfer.getVip() );
        post.setId( transfer.getId() );
        post.setTitle( transfer.getTitle() );
        post.setBody( transfer.getBody() );
        post.setSummary( transfer.getSummary() );
        post.setSlug( transfer.getSlug() );
        post.setCreateDate( transfer.getCreateDate() );
        post.setUpdateDate( transfer.getUpdateDate() );
        post.setPostType( transfer.getPostType() );

        return post;
    }

    protected List<Post> transferListToPostList(List<Transfer> list) {
        if ( list == null ) {
            return null;
        }

        List<Post> list1 = new ArrayList<Post>( list.size() );
        for ( Transfer transfer : list ) {
            list1.add( transferToPost( transfer ) );
        }

        return list1;
    }
}
