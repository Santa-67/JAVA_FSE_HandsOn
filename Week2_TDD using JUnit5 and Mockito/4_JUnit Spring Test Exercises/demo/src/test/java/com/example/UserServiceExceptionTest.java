package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceExceptionTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserServiceExceptionTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserByIdOrThrow_UserNotFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(java.util.NoSuchElementException.class, () -> {
            userService.getUserByIdOrThrow(99L);
        });

        assertEquals("User not found", exception.getMessage());
    }
}
