package org.example.restaurants.repository.jpa;

import org.example.restaurants.model.Restaurant;
import org.example.restaurants.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaRestaurantRepository implements RestaurantRepository {
    private static final Logger logger = LoggerFactory.getLogger(DataJpaRestaurantRepository.class);
    private static final Sort SORT_BY_NAME = Sort.by(Sort.Direction.ASC,"name");

    private final CrudRestaurantRepository crudRepository;

    @Autowired
    public DataJpaRestaurantRepository(CrudRestaurantRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        logger.info("attempt to save Restaurant: {}", restaurant);
        return crudRepository.save(restaurant);
    }

    @Override
    public boolean delete(int id) {
        logger.info("attempt to delete Restaurant with id: {}", id);
        return crudRepository.delete(id) != 0;
    }

    @Override
    public Restaurant get(int id) {
        logger.info("attempt to get Restaurant by id: {}", id);
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public Restaurant getByTelephone(String telephone) {
        logger.info("attempt to save Restaurant by telephone: {}", telephone);
        return crudRepository.getByPhone(telephone);
    }

    @Override
    public List<Restaurant> getAll() {
        logger.info("attempt to get list of all restaurants");
        return crudRepository.getAll();
    }

    @Override
    public List<Restaurant> getWithMenus() {
        logger.info("attempt to get list of all restaurants with menus");
        return crudRepository.getWithMenus();
    }
}
