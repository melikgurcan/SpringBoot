package com.example.demo2.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {


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

    @Min(value = 18, message = "Age must be above 18")
    private int age;

    @NotBlank
    @Size(min = 11, max = 11, message = "Id Number must be 11 character long")
    private String idNumber;

    public UserRegisterDTO(String name, String email, String address, int age, String idNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.age = age;
        this.idNumber = idNumber;
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

}
