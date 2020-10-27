package org.example.restaurants.repository;

import java.util.Date;
import java.util.List;
import org.example.restaurants.model.Meal;

public interface MealRepository {
  // null if updated meal do not belong to restaurant
  Meal save(Meal record, int restId);

  // false if not found
  boolean delete(int id, int restId);

  // null if not found
  Meal get(int id, int restId);


  List<Meal> getAllById(int restId, Date published);


  List<Meal> getAll(Date published);

}
