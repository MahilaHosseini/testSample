package com.example.testSample.model.repository;

import com.example.testSample.model.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseDao extends JpaRepository<BaseEntity, Long> {
    Optional<BaseEntity> findById(Long id);
}
