package com.springexam.api.mapper;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.springexam.api.model.User;
import com.springexam.api.dto.UserDTO;
import com.springexam.api.model.Project;
import com.springexam.api.dto.ProjectDTO;
import com.springexam.api.dto.TaskDTO;
import com.springexam.api.model.Task;


@Component
public class EntityMapper {

    public UserDTO toUserDTO(User user) {
        if (user == null) return null;
        return new UserDTO(
            user.getId(),
            user.getUsername(),
            user.getEmail()
        );
    }
    public User toUser(UserDTO userDTO) {
        if (userDTO == null) return null;
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public ProjectDTO toProjectDTO(Project project) {
        if (project == null) return null;

        Long userId = project.getUser() != null ? project.getUser().getId() : null;

        return new ProjectDTO(
            project.getId(),
            project.getName(),
            userId
        );
    }
    public Project toProject(ProjectDTO dto, User user) {
        if (dto == null) return null;

        Project project = new Project();
        project.setId(dto.getId());
        project.setName(dto.getName());
        project.setUser(user);
        return project;
    }
    public TaskDTO toTaskDTO(Task task) {
        if (task == null) return null;

        Long userId = task.getUser() != null ? task.getUser().getId() : null;
        Long projectId = task.getProject() != null ? task.getProject().getId() : null;

        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setUserId(userId);
        dto.setProjectId(projectId);
        return dto;
    }

    public Task toTask(TaskDTO dto, User user, Project project) {
        if (dto == null) return null;

        Task task = new Task();
        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setUser(user);
        task.setProject(project);
        return task;
    }    
    
    
}
