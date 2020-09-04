package org.example.restaurants.repository;

import org.example.restaurants.model.User;

public interface UserRepository {

    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByEmail(String email);
}
