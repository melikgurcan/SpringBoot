package com.example.demo2.service;

import com.example.demo2.User;
import com.example.demo2.dto.UserDTO;
import com.example.demo2.Mapper.UserMapper;
import com.example.demo2.dto.UserRegisterDTO;
import com.example.demo2.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LogManager.getLogger(UserService.class);


    public UserDTO addUser(UserRegisterDTO dto)
    {
        logger.info("User adding...");

        if(userRepository.existsByEmail(dto.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }

        User user = UserMapper.toEntity(dto);
        userRepository.save(user);
        return UserMapper.toDTO(user);
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(int id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toDTO(user);
    }

    public List<UserDTO> searchUser(String name, String email){
        if(name != null){
            return userRepository.findByNameContainingIgnoreCase(name)
                    .stream()
                    .map(UserMapper::toDTO)
                    .collect(Collectors.toList());
        }
        if(email != null){
            return userRepository.findByEmailContainingIgnoreCase(email)
                    .stream()
                    .map(UserMapper::toDTO)
                    .collect(Collectors.toList());
        }
        return getAllUsers();
    }

    public User updateUserById(int id, UserDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserMapper.updateEntity(user, dto);
        return userRepository.save(user);
    }

    public User deleteUserById(int id){
        User user  = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.deleteById(id);
        return user;
    }


}
