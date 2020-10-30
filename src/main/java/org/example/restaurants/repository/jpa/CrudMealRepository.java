package org.example.restaurants.repository.jpa;

import java.time.LocalDate;
import java.util.List;

import org.example.restaurants.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Meal m WHERE m.id=:id AND m.restaurant.id=:restId")
    int delete(@Param("id") int id, @Param("restId") int restId);

    @Query("SELECT m FROM Meal m WHERE m.restaurant.id=:restId AND m.published=:published")
    List<Meal> getAllById(@Param("restId") int restId, @Param("published") LocalDate published);

    @Query("SELECT m FROM Meal m WHERE m.published=:published")
    List<Meal> getAll(@Param("published") LocalDate published);
}
