package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    void testGetUserById_UserNotFound() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(1L)).thenReturn(Optional.empty());

        UserService userService = new UserService();
        // Inject mock repository (if not using constructor, set field directly for test)
        java.lang.reflect.Field repoField;
        try {
            repoField = UserService.class.getDeclaredField("userRepository");
            repoField.setAccessible(true);
            repoField.set(userService, mockRepo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Exception exception = assertThrows(UserNotFoundException.class, () -> {
            userService.getUserById(1L);
        });

        assertEquals("User not found", exception.getMessage());
    }
}