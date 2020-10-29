package org.example.restaurants.repository;

import org.example.restaurants.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.example.restaurants.UserTestData.USER;
import static org.example.restaurants.UserTestData.getNew;
import static org.example.restaurants.UserTestData.USER_MATCHER;
import static org.example.restaurants.UserTestData.getUpdated;
import static org.example.restaurants.UserTestData.USERS;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {
        User user = getNew();
        userRepository.save(user);
        int usrId = user.getId();
        User created = userRepository.get(usrId);
        USER_MATCHER.assertMatch(user, created);
    }

    @Test
    void updateExisting() {
        User updatedUser = getUpdated();
        userRepository.save(updatedUser);
        User expected = getUpdated();
        USER_MATCHER.assertMatch(updatedUser, expected);
    }

    @Test
    void delete() {
        assertTrue(userRepository.delete(USER.getId()));
        assertNull(userRepository.get(USER.getId()));
    }

    @Test
    void get() {
        User user = userRepository.get(USER.getId());
        USER_MATCHER.assertMatch(user, USER);
    }

    @Test
    void getByEmail() {
        User user = userRepository.getByEmail("user@yandex.ru");
        USER_MATCHER.assertMatch(user, USER);
    }

    @Test
    void getAll() {
        List<User>users = userRepository.getAll();
        USER_MATCHER.assertMatch(users, USERS);
    }
}