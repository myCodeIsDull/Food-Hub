package org.example.restaurants.web;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import org.example.restaurants.model.Meal;
import org.example.restaurants.model.Restaurant;
import org.example.restaurants.repository.MealRepository;
import org.example.restaurants.repository.RestaurantRepository;
import org.example.restaurants.to.MenuTo;
import org.example.restaurants.util.MenuUtil;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

  private final RestaurantRepository restaurantRepository;
  private final MealRepository mealRepository;
  private final MealToModelAssembler assembler;

  public RestaurantController(RestaurantRepository restaurantRepository,
      MealRepository mealRepository, MealToModelAssembler assembler) {
    this.restaurantRepository = restaurantRepository;
    this.mealRepository = mealRepository;
    this.assembler = assembler;
  }


  @GetMapping("/restaurants")
  @ResponseStatus(HttpStatus.OK)
  @SneakyThrows
  public CollectionModel<EntityModel<MenuTo>> getAll() {
    List<Restaurant> restaurants = restaurantRepository.getAll();
    List<Meal> meals = mealRepository.getAll(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-10"));
    List<EntityModel<MenuTo>> menus = MenuUtil
        .getTos(restaurants, meals).stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());
    return CollectionModel
        .of(menus, linkTo(methodOn(RestaurantController.class).getAll()).withSelfRel());
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/restaurants/{id}")
  @SneakyThrows
  public EntityModel<MenuTo> getOne(@PathVariable int id) {
    Restaurant restaurant = restaurantRepository.get(id);
    List<Meal> meals = mealRepository.getAllById(restaurant.getId(), new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-10"));
    return assembler
        .toModel(MenuUtil.getTo(restaurant, meals));
  }

}
