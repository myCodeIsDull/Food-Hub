package org.example.restaurants.repository;

import org.example.restaurants.model.Meal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.example.restaurants.MealTestData.*;
import static org.example.restaurants.RestaurantTestData.CFC_ID;
import static org.example.restaurants.RestaurantTestData.NOT_FOUND_ID;
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
    void saveList() {
        List<Meal>menu = getNewestMenu();
        repository.saveMenu(menu,CFC_ID);
        List<Meal>expected = repository.getAllById(CFC_ID, LocalDate.now());
        MEAL_TEST_MATCHER.assertMatch(menu,expected);

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
        MEAL_TEST_MATCHER.assertMatch(repository.getAllById(CFC_ID, PUBLISHED), CFC_MENU);
    }

    @Test
    void getAllByDate() {
        MEAL_TEST_MATCHER.assertMatch(repository.getAll(PUBLISHED), ALL_MENUS);
    }
}