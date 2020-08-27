package org.example.restaurants;

import org.example.restaurants.model.Menu;
import org.example.restaurants.model.Restaurant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RestaurantTestData {

    public static final Restaurant CROWN_FRIED_CHICKEN = new Restaurant("Crown Fried Chicken", "Main St, 20", new Menu(new HashMap<>() {{
        put("Fried Chicken", 1075);
        put("Fresh Salad", 838);
        put("Beer", 100);
    }}));

    public static final Restaurant MCDONALDS = new Restaurant("McDonald's", "Maple St, 5", new Menu(new HashMap<>() {{
        put("Big MAC", 1580);
        put("Fried potato", 500);
        put("Coca-Cola", 35);
    }}));

    public static final Restaurant VENICE = new Restaurant("Venice", "High St, 13", new Menu(new HashMap<>() {{
        put("Pasta", 1548);
        put("Cheese plate", 525);
        put("Dry vine", 150);
    }}));

    public static final Restaurant VEGAN = new Restaurant("Tap And Tandoor", "Park St, 3", new Menu(new HashMap<>() {{
        put("Soya Tikka", 650);
        put("Fresh Salad", 550);
        put("Vegetable Kebab", 450);
        put("Fresh Water", 20);
    }}));

    public static final Restaurant SEAFOOD_HEAVEN = new Restaurant("Seafood Heaven", "Union St, 22", new Menu(new HashMap<>() {{
        put("Trout on charcoals", 2035);
        put("Fried Shrimps", 800);
        put("Sea food salad", 1095);
        put("White vine", 150);
    }}));

    public static final List<Restaurant> RESTAURANTS = Arrays.asList(CROWN_FRIED_CHICKEN, MCDONALDS, VENICE, VEGAN, SEAFOOD_HEAVEN);

}
