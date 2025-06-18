package com.example.demo2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    private int idCounter = 1;

    private static final Logger logger = LogManager.getLogger(UserService.class);


    public User addUser(String name,  String email, String address) //entity
    {
        logger.info("User adding...");
        logger.debug("Full user info: name: {}, email: {}, address: {}", name, email, address);
        User user = new User(idCounter++, name, email, address);
        userRepository.saveUser(user);
        return user;
    }

    public List<User> getAllUsers(){
        return userRepository.findAllUsers();
    }

    public User getUserById(int id){
        return userRepository.getUserById(id);
    }

    public List<User> searchUser(String name, String email){
        if(name != null){
            return getUserByName(name);
        }
        if(email != null){
            return getUserByEmail(email);
        }
        return getAllUsers();
    }

    public List<User> getUserByName(String name){
        return userRepository.getUserByNameContains(name);
    }

    public List<User> getUserByEmail(String email){
        return userRepository.getUserByEmailContains(email);
    }

    public List<User> getUserByNameEmail(String name, String email){
        return userRepository.findAllUsers().stream().filter(user -> user.getName().contains(name.toLowerCase()) && user.getEmail().contains(email.toLowerCase())).toList() ;
    }

    public User updateUserById(int id, User user) {
        return userRepository.updateUserById(id,user);
    }

    public User deleteUserById(int id){
        return userRepository.deleteUserById(id);
    }

}
