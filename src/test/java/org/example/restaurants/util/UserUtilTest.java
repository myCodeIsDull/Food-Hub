package org.example.restaurants.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.example.restaurants.RestaurantTestData.*;
import static org.example.restaurants.UserTestData.ADMIN;
import static org.example.restaurants.UserTestData.USER;
import static org.junit.jupiter.api.Assertions.*;

class UserUtilTest {

    @Test
    void voteForRestaurant() {
        assertTrue(UserUtil.voteForRestaurant(USER, MCDONALDS, LocalDateTime.of(2020, Month.JULY, 20, 10, 0)));
        assertTrue(UserUtil.voteForRestaurant(ADMIN, MCDONALDS, LocalDateTime.of(2020, Month.JULY, 20, 10, 1)));
        assertEquals(MCDONALDS, USER.getChosenRestaurant());
        assertEquals(MCDONALDS, ADMIN.getChosenRestaurant());
        assertEquals(MCDONALDS.getVoices(), 2);
        assertEquals(RestaurantsUtil.getRestaurants(RESTAURANTS).get(0), MCDONALDS);
    }

    @Test
    void userTakesHisVoiceBack() {
        assertTrue(UserUtil.voteForRestaurant(USER, MCDONALDS, LocalDateTime.of(2020, Month.JULY, 20, 10, 5)));
        assertNull(USER.getChosenRestaurant());
        assertEquals(MCDONALDS.getVoices(), 1);
    }

    @Test
    void cantVoteAfterEleven() {
        assertFalse(UserUtil.voteForRestaurant(USER, VENICE, LocalDateTime.of(2020, Month.JULY, 20, 11, 1)));
    }


}