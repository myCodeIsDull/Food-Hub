package org.example.restaurants.repository.jpa;

import java.util.Date;
import java.util.List;
import org.example.restaurants.model.Meal;
import org.example.restaurants.repository.MealRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataJpaMealRepository implements MealRepository {

  private final CrudMealRepository mealRepository;
  private final CrudRestaurantRepository restaurantRepository;

  public DataJpaMealRepository(CrudMealRepository mealRepository,
      CrudRestaurantRepository restaurantRepository) {
    this.mealRepository = mealRepository;
    this.restaurantRepository = restaurantRepository;
  }

  @Override
  public Meal save(Meal record, int restId) {
    if (!record.isNew() && get(record.getId(), restId) == null) {
      return null;
    }
    return mealRepository.save(record);
  }

  @Override
  public boolean delete(int id, int restId) {
    return mealRepository.delete(id, restId) != 0;
  }

  @Override
  public Meal get(int id, int restId) {
    return mealRepository.findById(id)
        .filter(meal -> meal.getRestaurant().getId() == restId)
        .orElse(null);
  }

  @Override
  public List<Meal> getAllById(int restId, Date published) {
    return mealRepository.getAllById(restId, published);
  }

  @Override
  public List<Meal> getAll(Date published) {
    return mealRepository.getAll(published);
  }
}
