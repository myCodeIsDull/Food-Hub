package org.example.restaurants.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class User extends AbstractNamedEntity {

  @Column(nullable = false, unique = true)
  @Email
  @NotBlank
  @Size(max = 100)
  private String email;

  @Column(nullable = false)
  @NotBlank
  @Size(min = 5, max = 100)
  private String password;

  @Column(nullable = false, columnDefinition = "timestamp default now()")
  @NotNull
  private Date registered = new Date();

  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
      uniqueConstraints = {
          @UniqueConstraint(columnNames = {"user_id", "role"}, name = "user_roles_unique_idx")})
  @Column(name = "role")
  @ElementCollection(fetch = FetchType.EAGER)
  private Set<Role> roles;

  @Column(nullable = false, columnDefinition = "boolean default true")
  private boolean enabled = true;


  public User(Integer id, String name, String email, String password, Collection<Role> roles) {
    super(id, name);
    this.email = email;
    this.password = password;
    setRoles(roles);
  }

  public User(Integer id, String name, String email, String password, Role role, Role... roles) {
    this(id, name, email, password, EnumSet.of(role, roles));
  }

  public User(Integer id, String name, String email, String password, Role role) {
    this(id, name, email, password, EnumSet.of(role));
  }

  public void setRoles(Collection<Role> roles) {
    this.roles = roles.isEmpty() ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
  }

  public User(User user) {
    super(user.getId(), user.getName());
    this.email = user.email;
    this.password = user.password;
    this.registered = user.registered;
    this.enabled = user.enabled;
    this.roles = user.roles;
  }

  public User() {
  }

}
