package com.springexam.api.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springexam.api.mapper.EntityMapper;
import com.springexam.api.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.springexam.api.model.User;

import com.springexam.api.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/users")
public class UserController {

    private final EntityMapper mapper;

    private final UserService userService;

    public UserController(EntityMapper mapper, UserService userService) {
        this.mapper = mapper;
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toUserDTO(savedUser));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return userService.findById(id)
                .map(user -> ResponseEntity.ok(mapper.toUserDTO(user)))
                .orElse(ResponseEntity.notFound().build());
    }
    
}
