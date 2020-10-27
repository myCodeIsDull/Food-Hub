package org.example.restaurants;

import static org.example.restaurants.util.DateUtil.*;

import java.util.Date;
import java.util.List;

import org.example.restaurants.model.Address;
import org.example.restaurants.model.Restaurant;


public class RestaurantTestData {

    public static final TestMatcher<Restaurant> RESTAURANT_MATCHER = TestMatcher.usingFieldsComparator("registered","address");

    public static final Address CFC_ADDRESS = new Address("Springfield", "Main St", "20", "555-35-35");
    public static final Address McD_ADDRESS = new Address("Springfield", "Maple St", "5", "333-40-515");
    public static final Address VENICE_ADDRESS = new Address("Springfield", "High St", "13", "348-88-13");
    public static final Address VEG_ADDRESS = new Address("Springfield", "Park St", "3", "315-43-12");
    public static final Address SFH_ADDRESS = new Address("Springfield", "Union St", "22", "733-90-11");
    public static final Address NEW_ADDRESS = new Address("New York", "Broadway", "59", "219-03-55");

    public static final int NOT_FOUND_ID = 10;
    public static final int CFC_ID = 100002;
    public static final int MCD_ID = 100003;
    public static final int VENICE_ID = 100004;
    public static final int VEG_ID = 100005;
    public static final int SFH_ID = 100006;

    public static final Restaurant CROWN_FRIED_CHICKEN = new Restaurant(CFC_ID, "Crown Fried Chicken", parseString("2018-12-03"), CFC_ADDRESS);

    public static final Restaurant MC_DONALDS = new Restaurant(MCD_ID, "McDonalds", parseString("2017-08-11"), McD_ADDRESS);

    public static final Restaurant VENICE = new Restaurant(VENICE_ID, "Venice", parseString("2020-03-25"), VENICE_ADDRESS);

    public static final Restaurant VEGAN = new Restaurant(VEG_ID, "Tap And Tandoor", parseString("2020-05-09"), VEG_ADDRESS);

    public static final Restaurant SEAFOOD_HEAVEN = new Restaurant(SFH_ID, "Seafood Heaven", parseString("2019-04-08"), SFH_ADDRESS);

    public static final Restaurant UPDATED = new Restaurant(CFC_ID, "Updated", parseString("2018-12-03"), false, CFC_ADDRESS);

    public static final Restaurant NOT_FOUND = new Restaurant(NOT_FOUND_ID, "", new Date(), NEW_ADDRESS);

    public static Restaurant getNew() {
        return new Restaurant("White Rabbit", NEW_ADDRESS);
    }

    public static final List<Restaurant> RESTAURANTS = List.of(CROWN_FRIED_CHICKEN, MC_DONALDS, VENICE, VEGAN, SEAFOOD_HEAVEN);


}
