package com.springexam.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.springexam.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  
   Optional<User> findByUsername(String username);
}
