package com.example.demo2;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private  UserService userService;


    @PostMapping
    public UserDTO addUser(@Valid @RequestBody UserRegisterDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/search")
    public List<UserDTO> searchUser(@RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        return userService.searchUser(name, email);
    }

    @PutMapping("/{id}")
    public UserDTO updateUserById(@PathVariable int id, @RequestBody UserDTO dto) {
        User updated = userService.updateUserById(id, dto);
        return UserMapper.toDTO(updated);
    }

    @DeleteMapping("/{id}")
    public UserDTO deleteUserById(@PathVariable int id) {
        return UserMapper.toDTO(userService.deleteUserById(id));
    }
}
