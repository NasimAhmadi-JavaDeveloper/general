package com.example.springbootexersicemain.model.entity;

import com.example.springbootexersicemain.model.enums.PostType;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "tbl_post", uniqueConstraints =
@UniqueConstraint(name = "UNIQUE_CONST_POST", columnNames = {"TITLE", "SLUG"}))//USER_ID
@Accessors(chain = true)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "field_post_id_seq")
    @SequenceGenerator(name = "field_post_id_seq", sequenceName = "SEQ_POST_ID", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    @NotNull
    private String title;

    @Column(name = "BODY")
    private String body;

    @Column(name = "SUMMARY")
    private String summary;

    @Column(name = "SLUG")
    private String slug;

    @Column(name = "IS_VIP", nullable = false)
    @NotNull
    private Boolean isVip;

    @Column(name = "CREATE_DATE", nullable = false)
    @CreationTimestamp
    private Timestamp createDate;

    @Column(name = "UPDATE_DATE")
    @UpdateTimestamp
    private Timestamp updateDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "POST_TYPE", nullable = false)
    private PostType postType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID", nullable = false, foreignKey =
    @ForeignKey(name = "USER_ID_FK"))
    @NotNull
    private User user;

    public Boolean getVip() {
        return isVip;
    }

    public void setVip(Boolean vip) {
        isVip = vip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}