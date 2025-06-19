package com.example.demo2;

public class UserMapper {

    //From DTO to Entity
    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAddress(dto.getAddress());
        user.setAge(dto.getAge());

        return user;
    }

    //From Entity to DTO
    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getName(),
                user.getEmail(),
                user.getAddress(),
                user.getAge());
    }

}
