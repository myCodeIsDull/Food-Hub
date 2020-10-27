package org.example.restaurants.repository.jpa;

import org.example.restaurants.model.Restaurant;
import org.example.restaurants.repository.RestaurantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

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
    void create() {
        Restaurant actual = repository.save(getNew());
        int newId = actual.getId();
        Restaurant created = getNew();
        created.setId(newId);
        RESTAURANT_MATCHER.assertMatch(actual, created);
        RESTAURANT_MATCHER.assertMatch(repository.get(newId), created);
    }

    @Test
    void update() {
        Restaurant actual = repository.save(UPDATED);
        assertNotNull(actual);
        int actualId = actual.getId();
        Restaurant updated = repository.get(actualId);
        RESTAURANT_MATCHER.assertMatch(actual, updated);
    }

    @Test
    void updateNotFound() {
        assertNull(repository.save(NOT_FOUND));
    }

    @Test
    void get() {
        Restaurant actual = repository.get(CFC_ID);
        RESTAURANT_MATCHER.assertMatch(actual, CROWN_FRIED_CHICKEN);
    }

    @Test
    void notFound() {
        assertNull(repository.get(NOT_FOUND_ID));
    }

    @Test
    void delete() {
        assertTrue(repository.delete(CFC_ID));
        assertNull(repository.get(CFC_ID));
    }

    @Test
    void deleteNotFound() {
        assertFalse(repository.delete(NOT_FOUND_ID));
    }

    @Test
    void getAll() {
        RESTAURANT_MATCHER.assertMatch(repository.getAll(), RESTAURANTS);
    }

}