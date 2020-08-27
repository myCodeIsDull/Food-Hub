package org.example.restaurants.util;

import org.example.restaurants.model.Restaurant;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;


public class RestaurantsUtil {
    public static List<Restaurant> getRestaurants(List<Restaurant> list) {
        list.sort(Comparator.comparing(Restaurant::getVoices).reversed());
        return list;
    }

    public static String convertToCurrency(int convertible) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return numberFormat.format(convertible / 100.0);
    }


}
