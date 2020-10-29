package org.example.restaurants.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.restaurants.model.Meal;
import org.example.restaurants.model.Restaurant;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MenuTo {

  private Integer id;
  private Restaurant restaurant;
  private List<Meal> mealList;
  private int votes;
}
