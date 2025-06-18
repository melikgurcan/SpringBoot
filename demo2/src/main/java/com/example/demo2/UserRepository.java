package com.example.demo2;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Integer, User> users = new HashMap<>();

    //CREATE
    public void saveUser(User user) {
        users.put(user.getId(),user);
    }

    //READ
    public List<User> findAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(int id) {
        return users.get(id);
    }

    public List<User> getUserByNameContains(String name) {
        return users.values().stream().filter(user -> user.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }

    public List<User> getUserByEmailContains(String email) {
        return users.values().stream().filter(user -> user.getEmail().contains(email.toLowerCase())).toList();
    }

    //UPDATE
    public User updateUserById(int id, User user) {
        user.setId(id);
        return users.put(id, user);
    }

    //DELETE
    public User deleteUserById(int id) {
        return users.remove(id);
    }

}
