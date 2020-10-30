package org.example.restaurants.repository.jpa;

import org.example.restaurants.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {

    @Query("SELECT v FROM Vote v WHERE v.registered >= :startDateTime AND v.registered < :endDateTime")
    List<Vote> getAllByDate(@Param("startDateTime") LocalDateTime startDateTime, @Param("endDateTime") LocalDateTime endDateTime);

    @Query("SELECT COUNT(v) FROM Vote v WHERE v.restaurant.id=:restId AND v.registered >= :startDateTime AND v.registered < :endDateTime")
    int countByRestaurantIdAndDate(@Param("restId") int restId, @Param("startDateTime") LocalDateTime startDateTime, @Param("endDateTime") LocalDateTime endDateTime);

    //    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId")
    List<Vote> getAllByUserId(int userId);

    List<Vote> getAllByRestaurantId(int restId);
}
