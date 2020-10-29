package org.example.restaurants.web;

import static org.springframework.hateoas.EntityModel.of;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.example.restaurants.to.MenuTo;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class MealToModelAssembler implements RepresentationModelAssembler<MenuTo, EntityModel<MenuTo>> {

    @Override
    public EntityModel<MenuTo> toModel(MenuTo menu) {
        return of(menu,
                linkTo(methodOn(RestaurantController.class).getOne(menu.getId())).withSelfRel(),
                linkTo(methodOn(RestaurantController.class).getAll()).withRel("restaurants"));

    }
}
