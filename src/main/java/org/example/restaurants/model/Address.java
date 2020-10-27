package org.example.restaurants.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Address {

  @Column(nullable = false)
  @NotBlank
  @Size(min = 1, max = 20)
  private String city;

  @Column(nullable = false)
  @NotBlank
  @Size(min = 5, max = 50)
  private String street;

  @Column(nullable = false)
  @NotBlank
  @Size(min = 1, max = 20)
  private String house;

  @Column(nullable = false)
  @NotBlank
  @Size(min = 5, max = 20)
  private String phone;

}
