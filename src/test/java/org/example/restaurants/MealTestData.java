package org.example.restaurants;

import org.example.restaurants.model.Meal;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.restaurants.RestaurantTestData.*;
import static org.example.restaurants.util.DateUtil.parseLocalDate;

public class MealTestData {
    public static final TestMatcher<Meal> MEAL_TEST_MATCHER = TestMatcher.usingFieldsComparator("restaurant");

    public static final int START_SEQ = 100000;
    public static final int MEAL1_ID = START_SEQ + 7;
    public static final String DATE = "2020-08-10";
    public static final LocalDate PUBLISHED = parseLocalDate(DATE);
    public static final int ID_NOT_FOUND = 125;

    public static final Meal MEAL1 = new Meal(MEAL1_ID, PUBLISHED, 1075, "Fried Chicken", CROWN_FRIED_CHICKEN);
    public static final Meal MEAL2 = new Meal(MEAL1_ID + 1, PUBLISHED, 838, "Fresh Salad", CROWN_FRIED_CHICKEN);
    public static final Meal MEAL3 = new Meal(MEAL1_ID + 2, PUBLISHED, 100, "Beer", CROWN_FRIED_CHICKEN);

    public static final Meal MEAL4 = new Meal(MEAL1_ID + 3, PUBLISHED, 2580, "Big MAC", MC_DONALDS);
    public static final Meal MEAL5 = new Meal(MEAL1_ID + 4, PUBLISHED, 500, "Fried potato", MC_DONALDS);
    public static final Meal MEAL6 = new Meal(MEAL1_ID + 5, PUBLISHED, 35, "Coca-Cola", MC_DONALDS);

    public static final Meal MEAL7 = new Meal(MEAL1_ID + 6, PUBLISHED, 1548, "Pasta", VENICE);
    public static final Meal MEAL8 = new Meal(MEAL1_ID + 7, PUBLISHED, 525, "Cheese plate", VENICE);
    public static final Meal MEAL9 = new Meal(MEAL1_ID + 8, PUBLISHED, 150, "Dry vine", VENICE);

    public static final Meal MEAL10 = new Meal(MEAL1_ID + 9, PUBLISHED, 650, "Soya Tikka", VEGAN);
    public static final Meal MEAL11 = new Meal(MEAL1_ID + 10, PUBLISHED, 550, "Fresh Salad", VEGAN);
    public static final Meal MEAL12 = new Meal(MEAL1_ID + 11, PUBLISHED, 450, "Vegetable Kebab", VEGAN);
    public static final Meal MEAL13 = new Meal(MEAL1_ID + 12, PUBLISHED, 20, "Fresh Water", VEGAN);

    public static final Meal MEAL14 = new Meal(MEAL1_ID + 13, PUBLISHED, 2035, "Trout on charcoals", SEAFOOD_HEAVEN);
    public static final Meal MEAL15 = new Meal(MEAL1_ID + 14, PUBLISHED, 800, "Fried Shrimps", SEAFOOD_HEAVEN);
    public static final Meal MEAL16 = new Meal(MEAL1_ID + 15, PUBLISHED, 1095, "Sea food salad", SEAFOOD_HEAVEN);
    public static final Meal MEAL17 = new Meal(MEAL1_ID + 16, PUBLISHED, 150, "White vine", SEAFOOD_HEAVEN);

    public static final List<Meal> CFC_MENU = List.of(MEAL1, MEAL2, MEAL3);

    public static final List<Meal> ALL_MENUS = List.of(MEAL1, MEAL2, MEAL3, MEAL4, MEAL5, MEAL6, MEAL7, MEAL8, MEAL9, MEAL10, MEAL11, MEAL12, MEAL13, MEAL14, MEAL15, MEAL16, MEAL17);

    public static final Meal UPDATED_MEAL = new Meal(MEAL1_ID + 2, PUBLISHED, 135, "Premium Lager", CROWN_FRIED_CHICKEN);

    public static Meal getNewMeal() {
        return new Meal(995, "Karry Chicken");
    }

    public static Meal getUpdatedMeal(Meal meal) {
        return new Meal(meal.getPrice(), meal.getDescription());
    }

    public static List<Meal> getNewestMenu() {
        return CFC_MENU.stream()
                .map(MealTestData::getUpdatedMeal)
                .collect(Collectors.toList());
    }


}
