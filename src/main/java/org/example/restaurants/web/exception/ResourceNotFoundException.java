package org.example.restaurants.web.exception;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(int id) {
    super(String.format("resource with id: %d is not found", id));
  }

}
