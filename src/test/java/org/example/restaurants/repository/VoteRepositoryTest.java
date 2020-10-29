package org.example.restaurants.repository;

import org.example.restaurants.model.Vote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.example.restaurants.RestaurantTestData.CFC_ID;
import static org.example.restaurants.RestaurantTestData.VENICE;
import static org.example.restaurants.UserTestData.USER;
import static org.example.restaurants.VoteTestData.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VoteRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private VoteRepository voteRepository;

    @Test
    void save() {
        Vote newVote = getNewVote();
        voteRepository.save(newVote, USER.getId(), CFC_ID);
        int vote_id = newVote.getId();
        Vote vote = getNewVote();
        vote.setId(vote_id);
        VOTE_TEST_MATCHER.assertMatch(newVote, vote);
    }

    @Test
    void update() {
        Vote updated = voteRepository.save(VOTE1, USER.getId(), VENICE.getId());
        assertNotNull(updated);
        Vote expected = voteRepository.get(updated.getId(), updated.getUser().getId());
        VOTE_TEST_MATCHER.assertMatch(updated, expected);
    }

    @Test
    void cantUpdateSomeoneElseVote() {
        Vote updated = voteRepository.save(VOTE2, USER.getId(), VENICE.getId());
        assertNull(updated);
    }

    @Test
    void get() {
        Vote vote = voteRepository.get(VOTE1.getId(), USER.getId());
        VOTE_TEST_MATCHER.assertMatch(vote, VOTE1);
    }

    @Test
    void cantGetSomeoneElseVote() {
        Vote vote = voteRepository.get(VOTE2.getId(), USER.getId());
        assertNull(vote);
    }

    @Test
    void delete() {
        assertTrue(voteRepository.delete(USER.getId(), REGISTERED));
        assertNull(voteRepository.get(VOTE1.getId(), USER.getId()));
    }

    @Test
    void getAllByDate() {
        List<Vote> votes = voteRepository.getAllByDate(REGISTERED);
        VOTE_TEST_MATCHER.assertMatch(votes, VOTES);
    }

    @Test
    void getAllByUserId() {
        List<Vote> votes = voteRepository.getAllByUserId(USER.getId());
        VOTE_TEST_MATCHER.assertMatch(votes, USER_VOTES);
    }
}