package com.example.springbootexersicemain.model.mapper;

import com.example.springbootexersicemain.model.dto.RoleDto;
import com.example.springbootexersicemain.model.dto.RoleDto.InsertRoleDto;
import com.example.springbootexersicemain.model.dto.UserDto.Transfer;
import com.example.springbootexersicemain.model.entity.Role;
import com.example.springbootexersicemain.model.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-23T16:34:55+0330",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDto toDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setCode( role.getCode() );
        roleDto.setTitle( role.getTitle() );
        roleDto.setCreateDate( role.getCreateDate() );
        roleDto.setUpdateDate( role.getUpdateDate() );
        roleDto.setUsers( userListToTransferList( role.getUsers() ) );

        return roleDto;
    }

    @Override
    public Role toEntity(InsertRoleDto dto) {
        if ( dto == null ) {
            return null;
        }

        Role role = new Role();

        role.setCode( dto.getCode() );
        role.setTitle( dto.getTitle() );

        return role;
    }

    @Override
    public Role dtoToEntity(RoleDto roles) {
        if ( roles == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roles.getId() );
        role.setCode( roles.getCode() );
        role.setTitle( roles.getTitle() );
        role.setCreateDate( roles.getCreateDate() );
        role.setUpdateDate( roles.getUpdateDate() );
        role.setUsers( transferListToUserList( roles.getUsers() ) );

        return role;
    }

    @Override
    public List<RoleDto> entityToDtoList(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>( roles.size() );
        for ( Role role : roles ) {
            list.add( toDto( role ) );
        }

        return list;
    }

    protected Transfer userToTransfer(User user) {
        if ( user == null ) {
            return null;
        }

        Transfer transfer = new Transfer();

        transfer.setId( user.getId() );
        transfer.setName( user.getName() );
        transfer.setPassword( user.getPassword() );
        transfer.setEmail( user.getEmail() );
        transfer.setCreateDate( user.getCreateDate() );
        transfer.setUpdateDate( user.getUpdateDate() );

        return transfer;
    }

    protected List<Transfer> userListToTransferList(List<User> list) {
        if ( list == null ) {
            return null;
        }

        List<Transfer> list1 = new ArrayList<Transfer>( list.size() );
        for ( User user : list ) {
            list1.add( userToTransfer( user ) );
        }

        return list1;
    }

    protected User transferToUser(Transfer transfer) {
        if ( transfer == null ) {
            return null;
        }

        User user = new User();

        user.setId( transfer.getId() );
        user.setName( transfer.getName() );
        user.setPassword( transfer.getPassword() );
        user.setEmail( transfer.getEmail() );
        user.setCreateDate( transfer.getCreateDate() );
        user.setUpdateDate( transfer.getUpdateDate() );

        return user;
    }

    protected List<User> transferListToUserList(List<Transfer> list) {
        if ( list == null ) {
            return null;
        }

        List<User> list1 = new ArrayList<User>( list.size() );
        for ( Transfer transfer : list ) {
            list1.add( transferToUser( transfer ) );
        }

        return list1;
    }
}
