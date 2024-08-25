package com.example.springbootexersicemain.model.entity;

import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "tbl_role", uniqueConstraints =
@UniqueConstraint(name = "UNIQUE_CONST_ROLE", columnNames = {"CODE", "TITLE"}))
@Accessors(chain = true)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "field_role_id_seq")
    @SequenceGenerator(name = "field_role_id_seq", sequenceName = "SEQ_ROLE_ID", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE")
    private Long code;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CREATE_DATE")
    @CreationTimestamp
    private Timestamp createDate;

    @Column(name = "UPDATE_DATE")
    @UpdateTimestamp
    private Timestamp updateDate;

    @ManyToMany(mappedBy = "roles",cascade = CascadeType.REMOVE)
    private List<User> users;

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
