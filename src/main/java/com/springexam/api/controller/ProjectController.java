package com.springexam.api.controller;
import org.springframework.data.util.TypeCollector;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springexam.api.dto.ProjectDTO;
import com.springexam.api.dto.UserDTO;
import com.springexam.api.model.Project;
import com.springexam.api.model.User;
import com.springexam.api.service.ProjectService;
import com.springexam.api.dto.TaskDTO;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.springexam.api.mapper.EntityMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;





@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final EntityMapper mapper;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
        this.mapper = new EntityMapper();
    }
    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@Valid @RequestBody Project project) {
        Project savedProject = projectService.save(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toProjectDTO(savedProject));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
        return projectService.findById(id)
                .map(project -> ResponseEntity.ok(mapper.toProjectDTO(project)))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<TaskDTO>> getTasksByProjectId(@PathVariable Long id) {
        return projectService.getTasksByProjectId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    
}
