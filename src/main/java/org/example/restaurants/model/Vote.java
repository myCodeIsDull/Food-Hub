package org.example.restaurants.model;

import lombok.*;
import org.example.restaurants.HasRestaurantID;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "votes")
public class Vote extends AbstractBaseEntity implements HasRestaurantID {
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id")
    private Restaurant restaurant;

    @Column(nullable = false, columnDefinition = "timestamp default now()")
    private Date registered = new Date();

    public Vote(Integer id, User user, Restaurant restaurant, Date registered) {
        super(id);
        this.user = user;
        this.restaurant = restaurant;
        this.registered = registered;
    }

    public Vote(User user, Restaurant restaurant) {
        super(null);
        this.user = user;
        this.restaurant = restaurant;
    }

    @Override
    public Integer getRestaurantID() {
        return restaurant.getId();
    }
}
