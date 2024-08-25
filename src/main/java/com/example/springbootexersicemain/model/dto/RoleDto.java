package com.example.springbootexersicemain.model.dto;

import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.List;


@Accessors(chain = true)
public class RoleDto {

    private Long id;
    private Long code;
    private String title;
    private Timestamp createDate;
    private Timestamp updateDate;
    private List<UserDto.Transfer> users;

    @Accessors(chain = true)
    public static class InsertRoleDto {

        private Long code;
        private String title;

        public Long getCode() {
            return code;
        }

        public void setCode(Long code) {
            this.code = code;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    @Accessors(chain = true)
    public static class Transfer {

        private Long id;
        private Long code;
        private String title;
        private Timestamp createDate;
        private Timestamp updateDate;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getCode() {
            return code;
        }

        public void setCode(Long code) {
            this.code = code;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<UserDto.Transfer> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto.Transfer> users) {
        this.users = users;
    }
}
