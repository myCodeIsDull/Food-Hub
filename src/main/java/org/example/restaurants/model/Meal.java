package org.example.restaurants.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

//represents a record in restaurant menu

@Entity
@Getter
@Setter
@ToString
@NamedQueries({
    @NamedQuery(name = Meal.GET_ALL_BY_ID, query = "SELECT m FROM Meal m WHERE m.restaurant.id=:restId AND m.published=:published"),
})
public class Meal extends AbstractBaseEntity {

  public static final String GET_ALL_BY_ID = "Meal.getAllById";

  @Column(nullable = false, columnDefinition = "timestamp default now()")
  @JsonIgnore
  private final Date published = new Date();

  @Range(min = 10, max = 1000)
  @Column(nullable = false)
  private int price;

  @NotEmpty(message = "description can not be empty")
  @Column(name = "title", nullable = false)
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rest_id")
  @JsonIgnore
  private Restaurant restaurant;

  public Meal(Integer id) {
    super(id);
  }

  protected Meal() {
  }
}
