package com.example.demo2;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mySQL
    private int id;

    @NotBlank(message = "Name is required!")
    @Size(min = 3, message = "Name must be at least 3 characters long!")
    private String name;

    @NotBlank(message = "Email is required!")
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9+_.-]+$",
            message = "Invalid email format"
    )
    private String email;

    @NotBlank(message = "Address is required")
    @Size(min=10, message = "Address must be at least 10 characters long")
    private String address;


    public User(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
