package com.example.demo2;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {
    private String name;
    private String email;
    private String address;
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
