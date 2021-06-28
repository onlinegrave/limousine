package com.example.limousine.controllers.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  @GetMapping(value = "/authenticate")
  @RequestMapping(method = RequestMethod.GET, value = "/authenticate")
  public ResponseEntity<String> authenticate(AuthenticateRequest authenticateRequest) {
    return ResponseEntity.ok().body("Authenticate");
  }
}
