package com.example.springbootexersicemain.model.dto;

import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Accessors(chain = true)
public class DocumentDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long length;

    @NotNull
    private Long checksum;

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

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getChecksum() {
        return checksum;
    }

    public void setChecksum(Long checksum) {
        this.checksum = checksum;
    }

    @Accessors(chain = true)
    public static class InsertDocumentDto {

        @NotNull
        private String name;

        @NotNull
        private Long length;

        @NotNull
        private Long checksum;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getLength() {
            return length;
        }

        public void setLength(Long length) {
            this.length = length;
        }

        public Long getChecksum() {
            return checksum;
        }

        public void setChecksum(Long checksum) {
            this.checksum = checksum;
        }
    }
}