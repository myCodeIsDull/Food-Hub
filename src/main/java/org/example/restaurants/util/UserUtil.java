package org.example.restaurants.util;

import org.example.restaurants.model.Restaurant;
import org.example.restaurants.model.User;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserUtil {
    private static final Logger logger = LoggerFactory.getLogger(UserUtil.class);

    public static boolean voteForRestaurant(User user, Restaurant restaurant, LocalDateTime dateTime) {
        logger.debug("voteForRestaurants with params: {}, {}, {}", user, restaurant, dateTime);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        if (dateTime.toLocalTime().isAfter(LocalTime.parse("11:00", dtf))) {
            return false;
        }
        Restaurant lastVotedRestaurant = user.getChosenRestaurant();
        if (lastVotedRestaurant != null) {
            if (lastVotedRestaurant.equals(restaurant)) {
                user.setChosenRestaurant(null);
                restaurant.decrementVoices();
                return true;
            }
        }
        restaurant.incrementVoices();
        user.setChosenRestaurant(restaurant);
        return true;
    }
}
