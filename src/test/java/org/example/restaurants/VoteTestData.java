package org.example.restaurants;

import org.example.restaurants.model.Vote;

import java.time.LocalDateTime;
import java.util.List;

import static org.example.restaurants.MealTestData.PUBLISHED;
import static org.example.restaurants.MealTestData.START_SEQ;
import static org.example.restaurants.RestaurantTestData.*;
import static org.example.restaurants.UserTestData.*;
import static org.example.restaurants.util.DateUtil.*;

public class VoteTestData {
    public static final TestMatcher<Vote> VOTE_TEST_MATCHER = TestMatcher.usingFieldsComparator("registered", "user", "restaurant");

    public static final Vote VOTE1 = new Vote(START_SEQ + 24, USER, CROWN_FRIED_CHICKEN, LocalDateTime.of(PUBLISHED, parseLocalTime("10:30")));
    public static final Vote VOTE2 = new Vote(START_SEQ + 25, ADMIN, MC_DONALDS, LocalDateTime.of(PUBLISHED, parseLocalTime("09:15")));
    public static final Vote VOTE3 = new Vote(START_SEQ + 26, USER, VENICE, LocalDateTime.of(PUBLISHED, parseLocalTime("09:47")));

    public static final List<Vote> USER_VOTES = List.of(VOTE1, VOTE3);
    public static final List<Vote> VOTES = List.of(VOTE1, VOTE2);

    public static Vote getNewVote() {
        return new Vote();
    }


}
