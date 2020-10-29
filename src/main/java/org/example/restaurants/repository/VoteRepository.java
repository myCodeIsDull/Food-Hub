package org.example.restaurants.repository;

import org.example.restaurants.model.Vote;

import java.util.Date;
import java.util.List;

public interface VoteRepository {
    //null if vote is already exits and it's not belong to user
    Vote save(Vote vote, int userId, int restId);

    //null if vote is not belong to user
    Vote get(int id, int userId);

    //false if no vote with current user and date
    boolean delete(int userId, Date date);

    List<Vote> getAllByDate(Date date);

    List<Vote> getAllByUserId(int userId);
}
