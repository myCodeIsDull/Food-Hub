package org.example.restaurants.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(name = Restaurant.GET_ALL, query = "SELECT r FROM Restaurant r"),
})
@Table(name = "restaurants", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"phone"}, name = "unique_phone_number")})
public class Restaurant extends AbstractNamedEntity {

    public static final String GET_ALL = "Restaurant.getAll";

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date registered = new Date();

    @Embedded
    private Address address;

    @Column(name = "enabled", nullable = false, columnDefinition = "boolean default true")
    private boolean enabled = true;

    public Restaurant(Integer id, String name, Date registered, boolean enabled, Address address) {
        super(id, name);
        this.registered = registered;
        this.enabled = enabled;
        this.address = address;
    }

    public Restaurant(Integer id, String name, Date registered, Address address) {
        super(id, name);
        this.registered = registered;
        this.address = address;
    }

    public Restaurant(String name, Address address) {
        super(null, name);
        this.address = address;
    }

}
