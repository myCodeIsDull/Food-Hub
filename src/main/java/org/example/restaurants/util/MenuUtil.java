package org.example.restaurants.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.restaurants.model.Meal;
import org.example.restaurants.model.Restaurant;
import org.example.restaurants.to.MenuTo;

public class MenuUtil {

  private static Map<Integer, List<Meal>> groupByRestId(Collection<Meal> meals) {
    return meals.stream()
        .collect(Collectors.groupingBy(meal -> meal.getRestaurant().getId()));
  }

  public static List<MenuTo> getTos(Collection<Restaurant> restaurants, Collection<Meal> meals) {
    return restaurants.stream().map(
        restaurant -> new MenuTo(restaurant.getId(), restaurant,
            groupByRestId(meals).get(restaurant.getId())))
        .collect(Collectors.toList());
  }

  public static MenuTo getTo(Restaurant restaurant, Collection<Meal> meals) {
    return new MenuTo(restaurant.getId(), restaurant, new ArrayList<>(meals));
  }


}
