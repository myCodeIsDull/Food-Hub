package org.example.restaurants.repository.jpa;

import org.example.restaurants.model.Restaurant;
import org.example.restaurants.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DataJpaRestaurantRepository implements RestaurantRepository {

  private final CrudRestaurantRepository crudRepository;

  @Autowired
  public DataJpaRestaurantRepository(CrudRestaurantRepository crudRepository) {
    this.crudRepository = crudRepository;
  }

  @Override
  @Transactional
  public Restaurant save(Restaurant restaurant) {
    if (!restaurant.isNew() && get(restaurant.getId()) == null) {
      return null;
    }
    return crudRepository.save(restaurant);
  }

  @Override
  public boolean delete(int id) {
    return crudRepository.delete(id) != 0;
  }

  @Override
  public Restaurant get(int id) {
    return crudRepository.findById(id).orElse(null);
  }

  @Override
  public List<Restaurant> getAll() {
    return crudRepository.getAll();
  }

}
