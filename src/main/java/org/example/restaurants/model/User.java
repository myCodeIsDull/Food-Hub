package org.example.restaurants.model;

import java.util.Date;

public class User {
    private String name;
    private String email;
    private Restaurant chosenRestaurant;
    private Date registered;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        registered = new Date();
    }

    public User(String name, String email, Date registered) {
        this.name = name;
        this.email = email;
        this.registered = registered;
    }

    public String getName() {
        return name;
    }

    public Restaurant getChosenRestaurant() {
        return chosenRestaurant;
    }

    public void setChosenRestaurant(Restaurant chosenRestaurant) {
        this.chosenRestaurant = chosenRestaurant;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", chosenRestaurant=" + chosenRestaurant +
                ", registered=" + registered +
                '}';
    }
}
