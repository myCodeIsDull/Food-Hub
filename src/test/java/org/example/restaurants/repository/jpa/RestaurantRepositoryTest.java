package org.example.restaurants.repository.jpa;

import org.example.restaurants.model.Restaurant;
import org.example.restaurants.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.example.restaurants.RestaurantTestData.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-db.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class RestaurantRepositoryTest {


    @Autowired
    RestaurantRepository repository;

    @Test
    void save() {
        Restaurant newRestaurant = getNew();
        repository.save(newRestaurant);
        Restaurant expected = getNew();
        expected.setId(newRestaurant.getId());
        RESTAURANT_MATCHER.assertMatch(newRestaurant, expected);
    }

    @Test
    void delete() {
        assertTrue(repository.delete(CFC_ID));
        assertNull(repository.get(CFC_ID));
    }

    @Test
    void get() {
        Restaurant actual = repository.get(CFC_ID);
        RESTAURANT_MATCHER.assertMatch(actual, CROWN_FRIED_CHICKEN);
    }

    @Test
    void getAll() {
        List<Restaurant> restaurants = repository.getAll();
        RESTAURANT_MATCHER.assertMatch(restaurants, RESTAURANTS);
    }

    @Test
    void getByTelephone() {
        Restaurant restaurant = repository.getByTelephone("555-35-35");
        RESTAURANT_MATCHER.assertMatch(restaurant, CROWN_FRIED_CHICKEN);
    }

    @Test
    void getWithMenus() {
        List<Restaurant> restaurants = repository.getWithMenus();
        restaurants.forEach(r -> System.out.println(r+" menu:"+r.getMenuList()));
    }
}