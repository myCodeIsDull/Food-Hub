package org.example.restaurants.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.restaurants.HasRestaurantID;
import org.example.restaurants.model.Meal;
import org.example.restaurants.model.Restaurant;
import org.example.restaurants.model.Vote;
import org.example.restaurants.to.MenuTo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MenuUtil {

    private static <T extends HasRestaurantID> Map<Integer, List<T>> groupByRestId(Collection<T> collection) {
        return collection.stream()
                .collect(Collectors.groupingBy(HasRestaurantID::getRestaurantID));
    }

    public static List<MenuTo> getTos(Collection<Restaurant> restaurants, Collection<Meal> meals, Collection<Vote> votes) {
        Map<Integer, List<Vote>> restIdToVotes = groupByRestId(votes);
        return restaurants.stream()
                .map(restaurant -> new MenuTo(restaurant.getId(), restaurant, groupByRestId(meals).get(restaurant.getId()), restIdToVotes.computeIfAbsent(restaurant.getId(), key -> new ArrayList<>()).size()))
                .collect(Collectors.toList());
    }

    public static MenuTo getTo(Restaurant restaurant, Collection<Meal> meals, Collection<Vote> votes) {
        return new MenuTo(restaurant.getId(), restaurant, new ArrayList<>(meals), votes.size());
    }


}
