package com.springexam.api.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springexam.api.model.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
    List<Task> findByProjectId(Long projectId);
    
}
