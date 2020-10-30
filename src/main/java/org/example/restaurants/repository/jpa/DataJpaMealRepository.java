package org.example.restaurants.repository.jpa;

import java.time.LocalDate;
import java.util.List;

import org.example.restaurants.model.Meal;
import org.example.restaurants.model.Restaurant;
import org.example.restaurants.repository.MealRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DataJpaMealRepository implements MealRepository {

    private final CrudMealRepository mealRepository;
    private final CrudRestaurantRepository restaurantRepository;

    public DataJpaMealRepository(CrudMealRepository mealRepository, CrudRestaurantRepository restaurantRepository) {
        this.mealRepository = mealRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    @Transactional
    public Meal save(Meal record, int restId) {
        if (!record.isNew() && get(record.getId(), restId) == null) {
            return null;
        }
        record.setRestaurant(restaurantRepository.getOne(restId));
        return mealRepository.save(record);
    }

    @Override
    @Transactional
    public List<Meal> saveMenu(List<Meal> meals, int restId) {
        Restaurant restaurant = restaurantRepository.getOne(restId);
        meals.forEach(meal -> meal.setRestaurant(restaurant));
        return mealRepository.saveAll(meals);
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
    public List<Meal> getAllById(int restId, LocalDate published) {
        return mealRepository.getAllById(restId, published);
    }

    @Override
    public List<Meal> getAll(LocalDate published) {
        return mealRepository.getAll(published);
    }
}
