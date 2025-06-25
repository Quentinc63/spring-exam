package com.springexam.api.service;
import com.springexam.api.dto.TaskDTO;
import com.springexam.api.model.Project;
import com.springexam.api.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import com.springexam.api.repository.TaskRepository;
import java.util.List;


import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public Project save(Project project) {
        return projectRepository.save(project);
    }
    @Transactional(readOnly = true)
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    //GET /projects/{id}/tasks → Lister les tâches d’un projet
    @Transactional(readOnly = true)
    public Optional<List<TaskDTO>> getTasksByProjectId(Long projectId) {
        return findById(projectId).map(project -> 
            taskRepository.findByProjectId(projectId)
                .stream()
                .map(task -> new TaskDTO(
                        task.getId(),
                        task.getTitle(),
                        task.getUser() != null ? task.getUser().getId() : null,
                        projectId,
                        task.getStatus()))
                .collect(Collectors.toList())
        );
    }
}
