package org.example.restaurants.repository.jpa;

import org.example.restaurants.model.Vote;
import org.example.restaurants.repository.RestaurantRepository;
import org.example.restaurants.repository.UserRepository;
import org.example.restaurants.repository.VoteRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public class DataJpaVoteRepository implements VoteRepository {
    private final CrudVoteRepository voteRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public DataJpaVoteRepository(CrudVoteRepository voteRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    @Transactional
    public Vote save(Vote vote, int userId, int restId) {
        if (!vote.isNew() && get(vote.getId(), userId) == null) {
            return null;
        }
        vote.setUser(userRepository.get(userId));
        vote.setRestaurant(restaurantRepository.get(restId));
        return voteRepository.save(vote);
    }

    @Override
    public Vote get(int id, int userId) {
        return voteRepository.findById(id)
                .filter(vote -> vote.getUser().getId() == userId)
                .orElse(null);
    }

    @Override
    public boolean delete(int userId, Date date) {
        return voteRepository.delete(userId, date) != 0;
    }

    @Override
    public List<Vote> getAllByDate(Date date) {
        return voteRepository.getAllByDate(date);
    }

    @Override
    public List<Vote> getAllByUserId(int userId) {
        return voteRepository.getAllByUserId(userId);
    }
}
