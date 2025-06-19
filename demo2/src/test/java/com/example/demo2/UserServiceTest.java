package com.example.demo2;


import com.example.demo2.repository.UserRepository;
import com.example.demo2.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

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
        //User user = new User(1,"Melike", "mg@gmail.com", "Sariyer", 19, 3982032);
        //when(userRepository.getUserById(1)).thenReturn(user);

        //User result = userService.getUserById(1);

        //assertNotNull(result);
        //assertEquals("Melike",result.getName(), "User name should be Melike");
        //assertEquals(1, result.getId(), "User id should be 1");

    }



}
