package com.example.limousine.controllers.auth;

public class AuthenticateResponse {
  private String token;

  public AuthenticateResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return this.token;
  }
}
