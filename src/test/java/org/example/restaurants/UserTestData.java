package org.example.restaurants;

import org.example.restaurants.model.Role;
import org.example.restaurants.model.User;

public class UserTestData {
    public static final User USER = new User(100000, "User", "user@yandex.ru", "qwerty1", Role.USER);
    public static final User ADMIN = new User(1000001, "Admin", "admin@gmail.com", "qwerty2", Role.ADMIN, Role.USER);

}
