package com.example.springbootexersicemain.repository;

import com.example.springbootexersicemain.model.entity.VersionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionHistoryRepository extends JpaRepository<VersionHistory, Long> {

}
