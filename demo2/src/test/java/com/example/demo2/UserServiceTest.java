package com.example.demo2;


import com.example.demo2.dto.UserDTO;
import com.example.demo2.repository.User;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserById(){
        User user = new User();
        user.setName("Melike");
        user.setEmail("mg@gmail.com");
        user.setAddress("Istanbul Sariyer");
        user.setAge(30);

        when(userRepository.findById(1)).thenReturn(Optional.of(user));


        UserDTO result = userService.getUserById(1);

        assertNotNull(result);
        assertEquals("Melike",result.getName(), "User name should be Melike");
        assertEquals(1, result.getAge(), "User age should be 1");

    }



}
