package com.example.limousine.controllers.exception;

public class ControllerException extends Exception {
  public ControllerException() {
    super("Controller exception");
  }

  public ControllerException(String message) {
    super(message);
  }
}
