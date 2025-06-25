package com.springexam.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springexam.api.repository.TaskRepository;
import com.springexam.api.model.Task;

import com.springexam.api.model.Project;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;
        public Task save(Task task) {
        return taskRepository.save(task);
    }
    
}
