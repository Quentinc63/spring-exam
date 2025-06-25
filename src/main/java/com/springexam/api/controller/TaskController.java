package com.springexam.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springexam.api.mapper.EntityMapper;
import com.springexam.api.service.TaskService;

import com.springexam.api.model.Task;
import com.springexam.api.dto.TaskDTO;
import com.springexam.api.dto.TaskStatusDTO;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final EntityMapper mapper;

    public TaskController(TaskService taskService, EntityMapper mapper) {
        this.taskService = taskService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody Task task) {
        Task savedTask = taskService.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toTaskDTO(savedTask));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestBody TaskStatusDTO statusDTO) {
        Task updatedTask = taskService.updateStatus(id, statusDTO);
        return ResponseEntity.ok(updatedTask);
    }
    
    
}
