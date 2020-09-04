package org.example.restaurants.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Menu extends AbstractBaseEntity {

    @Column(name = "date_of_creation", nullable = false, columnDefinition = "timestamp default now()")
    private final Date registered = new Date();

    @ManyToOne(fetch = FetchType.EAGER)
    private Restaurant restaurant;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "menu_id")
    private List<Action> history;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "meal")
    @MapKeyColumn(name = "description")
    @Column(name = "price")
    private Map<String, Integer> lunchMenu = new HashMap<>();

    public Menu(Integer id) {
        super(id);
    }

    protected Menu() {
    }

    public Date getRegistered() {
        return registered;
    }

    public Map<String, Integer> getLunchMenu() {
        return lunchMenu;
    }

    public void setLunchMenu(Map<String, Integer> lunchMenu) {
        this.lunchMenu = lunchMenu;
    }
}
