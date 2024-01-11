package com.example.onlinestoreback.ErrorHandler;

public class ResourceNotFoundException extends RuntimeException {
  private long id;

  public ResourceNotFoundException(long id) {
      this.id = id;
  }

  public long getId() {
      return id;
  }

  public void setId(long id) {
      this.id = id;
  }
}
