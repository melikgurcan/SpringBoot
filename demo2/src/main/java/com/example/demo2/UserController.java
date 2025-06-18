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
    public User addUser(@Valid @RequestBody User user) {
        return userService.addUser(user.getName(), user.getEmail(), user.getAddress());
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/search")
    public List<User> searchUser(@RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        return userService.searchUser(name, email);
    }

    @PutMapping("/{id}")
    public User updateUserById(@PathVariable int id, @RequestBody User user) {
        return userService.updateUserById(id, user);
    }

    @DeleteMapping("/{id}")
    public User deleteUserById(@PathVariable int id) {
        return userService.deleteUserById(id);
    }
}
