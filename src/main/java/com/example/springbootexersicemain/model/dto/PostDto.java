package com.example.springbootexersicemain.model.dto;

import com.example.springbootexersicemain.model.enums.PostType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Accessors(chain = true)
public class PostDto {

    private Long id;
    private String title;
    private String body;
    private String summary;
    private String slug;
    private Boolean isVip;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MMM-dd HH:mm:ss z", timezone = "Asia/Tehran")
    private Timestamp createDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MMM-dd HH:mm:ss z", timezone = "Asia/Tehran")
    private Timestamp updateDate;
    private PostType postType;


    public static class InsertPostDto {

        @NotEmpty
        private String title;
        private String body;
        private String summary;
        private String slug;
        @NotNull
        private Boolean isVip;
        private PostType postType;

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

        public PostType getPostType() {
            return postType;
        }

        public void setPostType(PostType postType) {
            this.postType = postType;
        }

        public Boolean getVip() {
            return isVip;
        }

        public void setVip(Boolean vip) {
            isVip = vip;
        }
    }

    public static class UpdatePostDto {

        @NotNull
        private Long id;
        @NotEmpty
        private String title;
        private String body;
        private String summary;
        private String slug;
        @NotNull
        private Boolean isVip;
//        @NotNull
        private Timestamp createDate;//??
        private PostType postType;
//        @NotNull
//        private Long userId;

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

        public PostType getPostType() {
            return postType;
        }

        public void setPostType(PostType postType) {
            this.postType = postType;
        }

    }

    public static class Transfer {

        private Long id;
        private String title;
        private String body;
        private String summary;
        private String slug;
        private Boolean isVip;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MMM-dd HH:mm:ss z", timezone = "Asia/Tehran")
        private Timestamp createDate;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MMM-dd HH:mm:ss z", timezone = "Asia/Tehran")
        private Timestamp updateDate;
        private PostType postType;
        private Long userId;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
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

        public Boolean getVip() {
            return isVip;
        }

        public void setVip(Boolean vip) {
            isVip = vip;
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

    public Boolean getVip() {
        return isVip;
    }

    public void setVip(Boolean vip) {
        isVip = vip;
    }
}
