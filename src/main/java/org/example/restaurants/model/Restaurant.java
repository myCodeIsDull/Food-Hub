package org.example.restaurants.model;


import java.util.concurrent.atomic.AtomicInteger;

public class Restaurant {
    private final String name;
    private final String address;
    private final Menu menu;
    private AtomicInteger voices;

    public Restaurant(String name, String address, Menu menu) {
        this.name = name;
        this.address = address;
        this.menu = menu;
        voices = new AtomicInteger(0);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getVoices() {
        return voices.get();
    }

    public int incrementVoices() {
        return voices.incrementAndGet();
    }

    public int decrementVoices() {
        return voices.get() > 0 ? voices.decrementAndGet() : 0;
    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", street=" + address +
                ", menu=" + menu +
                ", votes=" + voices +
                '}';
    }
}
