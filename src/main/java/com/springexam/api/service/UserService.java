package com.springexam.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.springexam.api.repository.UserRepository;
import com.springexam.api.model.User;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;
import com.springexam.api.model.Project;
import com.springexam.api.dto.ProjectDTO;
import com.springexam.api.repository.ProjectRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    @Transactional(readOnly = true)
    public Optional<List<ProjectDTO>> getProjectsByUserId(Long userId) {
        return findById(userId).map(user -> 
            projectRepository.findByUserId(userId)
                .stream()
                .map(project -> new ProjectDTO(
                        project.getId(),
                        project.getName(),
                        userId))
                .collect(Collectors.toList())
        );
    }

}
