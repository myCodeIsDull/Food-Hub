package org.example.restaurants.repository;

import org.example.restaurants.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);

    // false if not found
    boolean delete(int id);

    // null if not found
    Restaurant get(int id);

    // null if not found
    Restaurant getByTelephone(String telephone);

    List<Restaurant>getAll();

    List<Restaurant>getWithMenus();
}
