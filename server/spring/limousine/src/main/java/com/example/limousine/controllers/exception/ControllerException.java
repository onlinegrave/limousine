package com.example.limousine.controllers.exception;

/**
 * @author dambarpun
 */
public class ControllerException extends Exception {
  public ControllerException() {
    super("Controller exception");
  }

  public ControllerException(String message) {
    super(message);
  }
}
