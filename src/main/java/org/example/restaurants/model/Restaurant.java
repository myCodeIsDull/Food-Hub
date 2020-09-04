package org.example.restaurants.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "restaurants")
@NamedQueries({
        @NamedQuery(name = Restaurant.GET_BY_PHONE, query = "SELECT r FROM Restaurant r LEFT JOIN FETCH r.address WHERE r.address.phone=?1"),
        @NamedQuery(name = Restaurant.GET_ALL, query = "SELECT r FROM Restaurant r LEFT JOIN FETCH r.address a order by r.name"),
        @NamedQuery(name = Restaurant.GET_ALL_WITH_MENUS, query = "SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.address LEFT JOIN FETCH r.menuList")

})
public class Restaurant extends AbstractNamedEntity {
    public static final String GET_BY_PHONE = "Restaurant.getByPhone";
    public static final String GET_ALL = "Restaurant.getAll";
    public static final String GET_ALL_WITH_MENUS = "Restaurant.getWithMenus";

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
    private Date registered = new Date();

    @OneToOne(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private Address address;

    @Column(name = "enabled", nullable = false, columnDefinition = "boolean default true")
    private boolean enabled = true;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menu> menuList;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, Address address, Collection<Menu> menus) {
        super(id, name);
        this.address = address;
        setMenus(menus);
        address.setRestaurant(this);
    }

    public Restaurant(Integer id, String name, Address address, Menu... menus) {
        this(id, name, address, List.of(menus));
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date date) {
        this.registered = date;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private List<Menu> setMenus(Collection<Menu> menus) {
        return new LinkedList<>(menus);
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", address=" + address +
                '}';
    }
}
