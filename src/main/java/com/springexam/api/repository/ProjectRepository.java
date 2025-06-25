package com.springexam.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.springexam.api.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByUserId(Long userId);
}
