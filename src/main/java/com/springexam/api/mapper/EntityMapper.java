package com.springexam.api.mapper;
import org.springframework.stereotype.Component;
import com.springexam.api.model.User;
import com.springexam.api.dto.UserDTO;


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
    
}
