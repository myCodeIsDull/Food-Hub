package org.example.restaurants;

import org.example.restaurants.model.Role;
import org.example.restaurants.model.User;

import java.util.Collections;
import java.util.List;

import static org.example.restaurants.MealTestData.START_SEQ;

public class UserTestData {
    public static TestMatcher<User> USER_MATCHER = TestMatcher.usingFieldsComparator("registered");

    public static final User USER = new User(START_SEQ, "User", "user@yandex.ru", "password", Role.USER);
    public static final User ADMIN = new User(START_SEQ + 1, "Admin", "admin@gmail.com", "admin", Role.ADMIN, Role.USER);
    public static final List<User> USERS = List.of(ADMIN, USER);


    public static User getNew() {
        return new User(null, "New", "new@gmail.com", "newPass", false, Collections.singleton(Role.USER));
    }

    public static User getUpdated() {
        User updated = new User(USER);
        updated.setName("UpdatedName");
        updated.setRoles(Collections.singletonList(Role.ADMIN));
        return updated;
    }
}
