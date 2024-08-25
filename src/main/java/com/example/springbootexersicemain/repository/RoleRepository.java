package com.example.springbootexersicemain.repository;

import com.example.springbootexersicemain.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
