package com.example.demo2;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserById(){
        User user = new User(1,"Melike", "mg@gmail.com", "Sariyer");
        when(userRepository.getUserById(1)).thenReturn(user);

        User result = userService.getUserById(1);

        assertNotNull(result);
        assertEquals("Melike",result.getName(), "User name should be Melike");
        assertEquals(1, result.getId(), "User id should be 1");

    }



}
