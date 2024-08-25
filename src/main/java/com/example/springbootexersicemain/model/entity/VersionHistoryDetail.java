package com.example.springbootexersicemain.model.entity;

import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "tbl_version_history_detail", uniqueConstraints =
@UniqueConstraint(name = "UNIQUE_CONST_VERSION_HISTORY_DETAIL_TITLE_DESCRIPTION", columnNames = {"TITLE", "DESCRIPTION"}))
@Accessors(chain = true)
public class VersionHistoryDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "field_version_history_detail_id_seq")
    @SequenceGenerator(name = "field_version_history_detail_id_seq", sequenceName = "SEQ_VERSION_HISTORY_DETAIL_ID", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "HISTORY_DATE", nullable = false)
    @NotNull(message = "{err.version-history-detail.date.null}")
    private Timestamp historyDate;

    @Column(name = "TITLE", nullable = false)
    @NotNull(message = "{err.version-history-detail.title.null}")
    private String title;

    @Column(name = "DESCRIPTION", nullable = false)
    @NotNull(message = "{err.version-history-detail.description.null}")
    private String description;

    @ManyToMany
    @JoinTable(name = "tbl_version_history_Detail_document",
            joinColumns = @JoinColumn(name = "version_history_detail_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "document_id", referencedColumnName = "id"))
    private List<Document> document;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(Timestamp historyDate) {
        this.historyDate = historyDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Document> getDocument() {
        return document;
    }

    public void setDocument(List<Document> document) {
        this.document = document;
    }
}