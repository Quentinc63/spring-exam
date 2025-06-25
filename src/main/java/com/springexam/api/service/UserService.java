package com.springexam.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.springexam.api.repository.UserRepository;
import com.springexam.api.model.User;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    public User save(User user) {
        return userRepository.save(user);
    }
    
}
