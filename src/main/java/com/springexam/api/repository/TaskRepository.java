package com.springexam.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springexam.api.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    
}
