package com.example.springbootexersicemain.model.dto;

import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.List;

@Accessors(chain = true)
public class VersionHistoryDto {

    private Long id;

    @NotNull(message = "{err.version-history.null}")
    private String versionNumber;

    private List<VersionHistoryDetailDto> versionHistoryDetail;

    @Accessors(chain = true)
    public static class InsertVersionHistoryDto {

        private String versionNumber;

        private List<VersionHistoryDetailDto.InsertVersionHistoryDetailDto> versionHistoryDetail;

        public String getVersionNumber() {
            return versionNumber;
        }

        public void setVersionNumber(String versionNumber) {
            this.versionNumber = versionNumber;
        }

        public List<VersionHistoryDetailDto.InsertVersionHistoryDetailDto> getVersionHistoryDetail() {
            return versionHistoryDetail;
        }

        public void setVersionHistoryDetail(List<VersionHistoryDetailDto.InsertVersionHistoryDetailDto> versionHistoryDetail) {
            this.versionHistoryDetail = versionHistoryDetail;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public List<VersionHistoryDetailDto> getVersionHistoryDetail() {
        return versionHistoryDetail;
    }

    public void setVersionHistoryDetail(List<VersionHistoryDetailDto> versionHistoryDetail) {
        this.versionHistoryDetail = versionHistoryDetail;
    }
}
