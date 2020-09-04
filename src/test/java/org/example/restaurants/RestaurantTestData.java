package org.example.restaurants;

import org.example.restaurants.model.Address;
import org.example.restaurants.model.Restaurant;

import java.util.List;

public class RestaurantTestData {
    public static final TestMatcher<Restaurant> RESTAURANT_MATCHER = TestMatcher.usingFieldsComparator("menuList", "registered", "address");

    public static final Address CFC_ADDRESS = new Address("Springfield", "Main St", "20", "555-35-35");
    public static final Address McD_ADDRESS = new Address("Springfield", "Maple St", "5", "333-40-515");
    public static final Address VENICE_ADDRESS = new Address("Springfield", "High St", "13", "348-88-13");
    public static final Address VEG_ADDRESS = new Address("Springfield", "Park St", "3", "315-43-12");
    public static final Address SFH_ADDRESS = new Address("Springfield", "Union St", "22", "733-90-11");
    public static final Address NEW_ADDRESS = new Address("New York", "Broadway", "59", "219-03-55");

    public static final int NOT_FOUND = 10;
    public static final int CFC_ID = 100002;
    public static final int MCD_ID = 100003;
    public static final int VENICE_ID = 100004;
    public static final int VEG_ID = 100005;
    public static final int SFH_ID = 100006;

    public static final Restaurant CROWN_FRIED_CHICKEN = new Restaurant(CFC_ID, "Crown Fried Chicken", CFC_ADDRESS);

    public static final Restaurant MCDONALDS = new Restaurant(MCD_ID, "McDonalds", McD_ADDRESS);

    public static final Restaurant VENICE = new Restaurant(VENICE_ID, "Venice", VENICE_ADDRESS);

    public static final Restaurant VEGAN = new Restaurant(VEG_ID, "Tap And Tandoor", VEG_ADDRESS);

    public static final Restaurant SEAFOOD_HEAVEN = new Restaurant(SFH_ID, "Seafood Heaven", SFH_ADDRESS);

    public static Restaurant getNew() {
        return new Restaurant(null, "White Rabbit", NEW_ADDRESS);
    }

    public static final List<Restaurant> RESTAURANTS = List.of(CROWN_FRIED_CHICKEN, MCDONALDS, SEAFOOD_HEAVEN, VEGAN, VENICE);


}
