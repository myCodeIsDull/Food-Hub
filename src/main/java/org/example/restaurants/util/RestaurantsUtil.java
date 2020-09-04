package org.example.restaurants.util;

import java.text.NumberFormat;
import java.util.Locale;


public class RestaurantsUtil {

    public static String convertToCurrency(int convertible) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return numberFormat.format(convertible / 100.0);
    }


}
