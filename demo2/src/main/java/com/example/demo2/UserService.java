package com.example.demo2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    private int idCounter = 1;

    private static final Logger logger = LogManager.getLogger(UserService.class);


    public UserDTO addUser(UserRegisterDTO dto)
    {
        logger.info("User adding...");
        User user = UserMapper.toEntity(dto);
        userRepository.saveUser(user);
        return UserMapper.toDTO(user);
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.findAllUsers()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(int id){
        User user = userRepository.getUserById(id);
        return UserMapper.toDTO(user);
    }

    public List<UserDTO> searchUser(String name, String email){
        if(name != null){
            return getUserByName(name);
        }
        if(email != null){
            return getUserByEmail(email);
        }
        return getAllUsers();
    }

    public List<UserDTO> getUserByName(String name){
        return userRepository.getUserByNameContains(name)
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<UserDTO> getUserByEmail(String email){
        return userRepository.getUserByEmailContains(email)
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<User> getUserByNameEmail(String name, String email){
        return userRepository.findAllUsers().stream().filter(user -> user.getName().contains(name.toLowerCase()) && user.getEmail().contains(email.toLowerCase())).toList() ;
    }

    public User updateUserById(int id, UserDTO dto) {
        User user = userRepository.getUserById(id);
        UserMapper.updateEntity(user, dto);
        return userRepository.updateUserById(id,user);
    }

    public User deleteUserById(int id){
        return userRepository.deleteUserById(id);
    }


}
