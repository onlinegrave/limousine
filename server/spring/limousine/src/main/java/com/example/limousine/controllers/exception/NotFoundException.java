package com.example.limousine.controllers.exception;

public class NotFoundException extends ControllerException {
  public NotFoundException(String message) {
    super(message);
  }

  public NotFoundException() {
    super("Not found");
  }
}
