package org.example.restaurants;

import org.example.restaurants.model.Role;
import org.example.restaurants.model.User;

import static org.example.restaurants.MealTestData.*;

public class UserTestData {
    public static final User USER = new User(START_SEQ, "User", "user@yandex.ru", "qwerty1", Role.USER);
    public static final User ADMIN = new User(START_SEQ + 1, "Admin", "admin@gmail.com", "qwerty2", Role.ADMIN, Role.USER);

}
