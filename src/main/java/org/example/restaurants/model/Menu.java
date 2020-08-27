package org.example.restaurants.model;

import org.example.restaurants.util.RestaurantsUtil;

import java.util.Map;
import java.util.stream.Collectors;

public class Menu {
    private final Map<String, Integer> menu;

    public Menu(Map<String, Integer> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return menu.entrySet().stream()
                .map(e ->e.getKey()+":"+ RestaurantsUtil.convertToCurrency(e.getValue()))
                .collect(Collectors.joining(", "));
    }

}
