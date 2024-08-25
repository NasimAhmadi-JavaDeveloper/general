package com.example.springbootexersicemain.service.impl;

import com.example.springbootexersicemain.exception.UserNotfoundException;
import com.example.springbootexersicemain.model.dto.RoleDto;
import com.example.springbootexersicemain.model.entity.Role;
import com.example.springbootexersicemain.model.mapper.RoleMapper;
import com.example.springbootexersicemain.repository.RoleRepository;
import com.example.springbootexersicemain.service.facade.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final RoleMapper mapper;

    public RoleServiceImpl(RoleRepository repository, RoleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleDto> select() {

        List<Role> roles = repository.findAll();

        return mapper.entityToDtoList(roles);
    }

    @Override
    @Transactional
    public RoleDto save(RoleDto.InsertRoleDto dto) {

        final Role entity = mapper.toEntity(dto);

        repository.save(entity);

        return mapper.toDto(entity);
    }

    @Override
    @Transactional
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleDto> findAllRolesByRoleIds(List<Long> roleIds) {

        // if (!roleIds.isEmpty()) { // if roleIds = null -> NullPointerException ***
        // if (roleIds != null && !roleIds.isEmpty()) {***

        if (!CollectionUtils.isEmpty(roleIds)) {

            List<Role> roles = repository.findAllById(roleIds);

            if (!CollectionUtils.isEmpty(roles)) {
                return roles.stream()
                        .map(mapper::toDto)
                        .collect(Collectors.toList());
//            List<RoleDto> roleDtoArrayList = new ArrayList<>(); *** 2
//            for (Role item : roles) {
//                roleDtoArrayList.add(mapper.toDto(item));
//            }
//            return roleDtoArrayList;
                //---------------2
            }
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional(readOnly = true)
    public RoleDto getRoleByIdUsingQueryParam(Long id) {
        Role user = repository.findById(id)
                .orElseThrow(UserNotfoundException::new);
        return mapper.toDto(user);
    }
}
