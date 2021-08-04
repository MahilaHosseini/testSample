package com.example.testSample.model.repository;

import com.example.testSample.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskDao extends JpaRepository<Task, Long> {
    List<Task> findAllByUserId(Long userId);
}
