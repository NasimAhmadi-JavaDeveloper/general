package com.example.springbootexersicemain.model.entity;

import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_document")
@Accessors(chain = true)
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "field_document_id_seq")
    @SequenceGenerator(name = "field_document_id_seq", sequenceName = "SEQ_DOCUMENT_ID", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, updatable = false)
    @NotBlank
    private String name;

    @Column(name = "CHECKSUM", nullable = false, updatable = false)
    @NotNull
    private Long checksum;

    @Column(name = "LENGTH", nullable = false, updatable = false)
    @NotNull
    private Long length;

//    @ManyToMany(mappedBy = "document")
//    private List<VersionHistoryDetail> versionHistoryDetails;

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

    public Long getChecksum() {
        return checksum;
    }

    public void setChecksum(Long checksum) {
        this.checksum = checksum;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }
}
