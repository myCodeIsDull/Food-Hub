package org.example.restaurants.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"phone"}, name = "unique_phone_number")})
public class Address extends AbstractBaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "city", nullable = false)
    @NotBlank
    @Size(min = 1, max = 20)
    private String city;

    @Column(name = "street", nullable = false)
    @NotBlank
    @Size(min = 5, max = 50)
    private String street;

    @Column(name = "house", nullable = false)
    @NotBlank
    @Size(min = 1, max = 20)
    private String house;

    @Column(name = "phone", nullable = false)
    @NotBlank
    @Size(min = 5, max = 20)
    private String phone;

    public Address(String city, String street, String house, String phone) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.phone = phone;
    }

    public Address(Integer id, Restaurant restaurant, String city, String street, String house, String phone) {
        super(id);
        this.restaurant = restaurant;
        this.city = city;
        this.street = street;
        this.house = house;
        this.phone = phone;
    }

    protected Address() {
    }


    public void setRestaurant(Restaurant restaurant) {

        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                '}';
    }
}
