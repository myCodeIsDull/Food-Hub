package org.example.restaurants.web;

import java.util.List;
import org.example.restaurants.model.Restaurant;
import org.example.restaurants.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

  private static final Logger LOGG = LoggerFactory.getLogger(RestaurantController.class);

  @Autowired
  RestaurantRepository repository;

  @GetMapping("/restaurants")
  public List<Restaurant> getAll() {
    return repository.getAll();
  }

}
