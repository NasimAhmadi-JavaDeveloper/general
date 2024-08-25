package com.example.springbootexersicemain.model.entity;

import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "tbl_version_history", uniqueConstraints =
@UniqueConstraint(name = "UNIQUE_CONST_VERSION_HISTORY_VERSION_NUMBER", columnNames = "VERSION_NUMBER"))
@Accessors(chain = true)
public class VersionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "field_version_history_id_seq")
    @SequenceGenerator(name = "field_version_history_id_seq", sequenceName = "SEQ_VERSION_HISTORY_ID", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "VERSION_NUMBER", nullable = false)
    @NotEmpty(message = "{err.version-history.null}")
    private String versionNumber;

    @ManyToMany
    @JoinTable(name = "tbl_version_history_version_history_detail",
            joinColumns = @JoinColumn(name = "version_history_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "version_history_detail_id", referencedColumnName = "id"))
    private List<VersionHistoryDetail> versionHistoryDetail;

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

    public List<VersionHistoryDetail> getVersionHistoryDetail() {
        return versionHistoryDetail;
    }

    public void setVersionHistoryDetail(List<VersionHistoryDetail> versionHistoryDetail) {
        this.versionHistoryDetail = versionHistoryDetail;
    }
}