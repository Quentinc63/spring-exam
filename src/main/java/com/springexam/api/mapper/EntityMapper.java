package com.springexam.api.mapper;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.springexam.api.model.User;
import com.springexam.api.dto.UserDTO;
import com.springexam.api.model.Project;
import com.springexam.api.dto.ProjectDTO;


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
    
    
}
