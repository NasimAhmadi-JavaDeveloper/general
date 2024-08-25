package com.example.springbootexersicemain.model.dto;

import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Accessors(chain = true)
public class UserDto {

    private Long id;
    private String name;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;
    private Timestamp createDate;
    private Timestamp updateDate;
    private List<RoleDto.Transfer> roles;
    @Valid
    @NotNull
    private List<PostDto.Transfer> posts;

    public static class Transfer {

        private Long id;
        private String name;
        private String password;
        private String email;
        private Timestamp createDate;
        private Timestamp updateDate;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Timestamp getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Timestamp createDate) {
            this.createDate = createDate;
        }

        public Timestamp getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(Timestamp updateDate) {
            this.updateDate = updateDate;
        }
    }

    public static class InsertUserDto {

        private String name;
        @NotEmpty
        private String password;
        @NotEmpty
        private String email;
        private List<Long> roleIds;
        private List<PostDto.InsertPostDto> posts;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public List<Long> getRoleIds() {
            return roleIds;
        }

        public void setRoleIds(List<Long> roleIds) {
            this.roleIds = roleIds;
        }

        public List<PostDto.InsertPostDto> getPosts() {
            return posts;
        }

        public void setPosts(List<PostDto.InsertPostDto> posts) {
            this.posts = posts;
        }
    }

    public static class UpdateUserDto {

        @NotNull
        private Long id;
        private String name;
        @NotEmpty
        private String password;
        @NotEmpty
        private String email;
        private List<Long> roleIds;
        @NotNull
        private List<PostDto.InsertPostDto> posts;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public List<Long> getRoleIds() {
            return roleIds;
        }

        public void setRoleIds(List<Long> roleIds) {
            this.roleIds = roleIds;
        }

        public List<PostDto.InsertPostDto> getPosts() {
            return posts;
        }

        public void setPosts(List<PostDto.InsertPostDto> posts) {
            this.posts = posts;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public List<RoleDto.Transfer> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto.Transfer> roles) {
        this.roles = roles;
    }

    public List<PostDto.Transfer> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDto.Transfer> posts) {
        this.posts = posts;
    }
}
