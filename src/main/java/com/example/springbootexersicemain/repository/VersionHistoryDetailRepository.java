package com.example.springbootexersicemain.repository;

import com.example.springbootexersicemain.model.entity.VersionHistoryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionHistoryDetailRepository extends JpaRepository<VersionHistoryDetail, Long> {

    VersionHistoryDetail findVersionHistoryDetailByTitleAndDescription(String title, String description);

}
