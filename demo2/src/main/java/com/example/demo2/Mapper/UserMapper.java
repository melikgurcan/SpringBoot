package com.example.demo2.Mapper;

import com.example.demo2.dto.UserDTO;
import com.example.demo2.dto.UserRegisterDTO;
import com.example.demo2.User;

public class UserMapper {

    //From DTO to Entity
    public static User toEntity(UserRegisterDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAddress(dto.getAddress());
        user.setAge(dto.getAge());
        user.setIdNumber(dto.getIdNumber());

        return user;
    }

    //From Entity to DTO
    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAddress(user.getAddress());
        dto.setAge(user.getAge());
        return dto;
    }

    //Update user by using dto
    public static void updateEntity(User user, UserDTO dto) {
        if(dto.getName() != null)
            user.setName(dto.getName());
        if(dto.getEmail() != null)
            user.setEmail(dto.getEmail());
        if(dto.getAddress() != null)
            user.setAddress(dto.getAddress());
        if(dto.getAge() != 0)
            user.setAge(dto.getAge());
    }

}
