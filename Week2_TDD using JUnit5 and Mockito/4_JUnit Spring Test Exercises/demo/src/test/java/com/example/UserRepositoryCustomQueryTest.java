package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryCustomQueryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByName() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Alice");
        userRepository.save(user1);

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Bob");
        userRepository.save(user2);

        List<User> result = userRepository.findByName("Alice");
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
    }
}
