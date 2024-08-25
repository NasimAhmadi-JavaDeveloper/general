package com.example.springbootexersicemain.model.dto;

import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Accessors(chain = true)
public class VersionHistoryDetailDto {

    private Long id;

    @NotNull(message = "{err.version-history-detail.date.null}")
    private Timestamp historyDate;

    @NotNull(message = "{err.version-history-detail.title.null}")
    private String title;

    @NotNull(message = "{err.version-history-detail.description.null}")
    private String description;

    private List<DocumentDto> document;

    private List<Long> documentIds;


    @Accessors(chain = true)
    public static class InsertVersionHistoryDetailDto {

        @NotNull(message = "{err.version-history-detail.date.null}")
        private Timestamp historyDate;

        @NotNull(message = "{err.version-history-detail.title.null}")
        private String title;

        @NotNull(message = "{err.version-history-detail.description.null}")
        private String description;

        private List<DocumentDto.InsertDocumentDto> document;

        private List<Long> documentIds;

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

        public List<DocumentDto.InsertDocumentDto> getDocument() {
            return document;
        }

        public void setDocument(List<DocumentDto.InsertDocumentDto> document) {
            this.document = document;
        }

        public List<Long> getDocumentIds() {
            return documentIds;
        }

        public void setDocumentIds(List<Long> documentIds) {
            this.documentIds = documentIds;
        }
    }

    @Accessors(chain = true)
    public static class Transfer {

        private Long id;
        private Timestamp historyDate;
        private String title;
        private String description;

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
    }

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

    public List<Long> getDocumentIds() {
        return documentIds;
    }

    public void setDocumentIds(List<Long> documentIds) {
        this.documentIds = documentIds;
    }

    public List<DocumentDto> getDocument() {
        return document;
    }

    public void setDocument(List<DocumentDto> document) {
        this.document = document;
    }
}
