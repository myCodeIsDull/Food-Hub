package org.example.restaurants.repository;

import org.example.restaurants.model.Meal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.example.restaurants.MealTestData.*;
import static org.example.restaurants.RestaurantTestData.CFC_ID;
import static org.example.restaurants.RestaurantTestData.NOT_FOUND_ID;
import static org.example.restaurants.util.DateUtil.parseString;
import static org.junit.jupiter.api.Assertions.*;


class MealRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private MealRepository repository;

    @Test
    void save() {
        Meal meal = getNewMeal();
        repository.save(meal, CFC_ID);
        int mealId = meal.getId();
        Meal expected = getNewMeal();
        expected.setId(mealId);
        MEAL_TEST_MATCHER.assertMatch(meal, expected);
    }

    @Test
    void update() {
        Meal actual = repository.save(UPDATED_MEAL, CFC_ID);
        assertNotNull(actual);
        int mealId = actual.getId();
        Meal expected = repository.get(mealId, CFC_ID);
        MEAL_TEST_MATCHER.assertMatch(actual, expected);
    }

    @Test
    void updateNotFound() {
        assertNull(repository.save(UPDATED_MEAL, NOT_FOUND_ID));
    }

    @Test
    void delete() {
        assertTrue(repository.delete(MEAL1_ID, CFC_ID));
        assertNull(repository.get(MEAL1_ID, CFC_ID));
    }

    @Test
    void deleteRestaurantNotFound() {
        assertFalse(repository.delete(MEAL1_ID, NOT_FOUND_ID));
    }

    @Test
    void deleteMealNotFound() {
        assertFalse(repository.delete(ID_NOT_FOUND, CFC_ID));
    }

    @Test
    void get() {
        MEAL_TEST_MATCHER.assertMatch(repository.get(MEAL1_ID, CFC_ID), MEAL1);
    }

    @Test
    void getMealNotFound() {
        assertNull(repository.get(ID_NOT_FOUND, CFC_ID));
    }

    @Test
    void getRestaurantNotFound() {
        assertNull(repository.get(MEAL1_ID, NOT_FOUND_ID));
    }

    @Test
    void getAllByRestaurantId() {
        MEAL_TEST_MATCHER.assertMatch(repository.getAllById(CFC_ID, parseString(PUBLISHED)), CFC_MENU);
    }

    @Test
    void getAllByDate() {
        MEAL_TEST_MATCHER.assertMatch(repository.getAll(parseString(PUBLISHED)), ALL_MENUS);
    }
}