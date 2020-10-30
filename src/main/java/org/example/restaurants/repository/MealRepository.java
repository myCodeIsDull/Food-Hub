package org.example.restaurants.repository;

import java.time.LocalDate;
import java.util.List;
import org.example.restaurants.model.Meal;

public interface MealRepository {
  // null if updated meal do not belong to restaurant
  Meal save(Meal record, int restId);

  List<Meal>saveMenu(List<Meal>menu, int restId);

  // false if not found
  boolean delete(int id, int restId);

  // null if not found
  Meal get(int id, int restId);


  List<Meal> getAllById(int restId, LocalDate published);


  List<Meal> getAll(LocalDate published);

}
