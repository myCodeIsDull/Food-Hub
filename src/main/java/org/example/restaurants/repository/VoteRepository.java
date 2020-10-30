package org.example.restaurants.repository;

import org.example.restaurants.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {
    //null if vote is already exits and it's not belong to user
    Vote save(Vote vote, int userId, int restId);

    //null if vote is not belong to user
    Vote get(int id, int userId);

    int count(int restId, LocalDate localDate);

    List<Vote> getAllByDate(LocalDate date);

    List<Vote> getAllByUserId(int userId);

    List<Vote> getAllByRestId(int restId);
}
