package org.example.restaurants.to;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.restaurants.model.Meal;
import org.example.restaurants.model.Restaurant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MenuTo {

  private Integer id;
  private Restaurant restaurant;
  private List<Meal> mealList;

}
