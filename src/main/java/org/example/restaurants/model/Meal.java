package org.example.restaurants.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.restaurants.HasRestaurantID;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


//represents a record in restaurant menu

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Meal extends AbstractBaseEntity implements HasRestaurantID {

    @Column(nullable = false, columnDefinition = "date default now()")
    @JsonIgnore
    private LocalDate published = LocalDate.now();

    @Range(min = 10, max = 3000)
    @Column(nullable = false)
    private int price;

    @NotEmpty(message = "description can not be empty")
    @Column(name = "title", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id")
    @JsonIgnore
    private Restaurant restaurant;

    public Meal(Integer id, LocalDate published, int price, String description, Restaurant restaurant) {
        super(id);
        this.published = published;
        this.price = price;
        this.description = description;
        this.restaurant = restaurant;
    }

    public Meal(Integer id, int price, String description, Restaurant restaurant) {
        super(id);
        this.price = price;
        this.description = description;
        this.restaurant = restaurant;
    }

    public Meal(int price, String description) {
        this(null, price, description, null);
    }

    @Override
    public Integer getRestaurantID() {
        return restaurant.getId();
    }
}
