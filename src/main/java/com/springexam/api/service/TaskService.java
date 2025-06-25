package com.springexam.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springexam.api.repository.TaskRepository;
import com.springexam.api.dto.TaskStatusDTO;
import com.springexam.api.model.Task;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;
        public Task save(Task task) {
        return taskRepository.save(task);
    }
    
    public Task updateStatus(Long id, TaskStatusDTO statusDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with id: " + id));

        task.setStatus(statusDTO.getStatus());

        return taskRepository.save(task);
    }
    
}
