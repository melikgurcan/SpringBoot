package com.example.demo2.mapper;

import com.example.demo2.dto.UserDTO;
import com.example.demo2.dto.UserRegisterDTO;
import com.example.demo2.repository.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    //From DTO to Entity
    public User toEntity(UserRegisterDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAddress(dto.getAddress());
        user.setAge(dto.getAge());
        user.setIdNumber(dto.getIdNumber());

        return user;
    }

    //From Entity to DTO
    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAddress(user.getAddress());
        dto.setAge(user.getAge());
        return dto;
    }

    //Update user by using dto
    public void updateEntity(User user, UserDTO dto) {
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAddress(dto.getAddress());
        user.setAge(dto.getAge());
    }

}
