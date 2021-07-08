package com.example.limousine.controllers.auth;

import com.example.limousine.services.AppUserDetailService;
import com.example.limousine.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private AppUserDetailService appUserDetailService;

  @Autowired
  private JwtUtil jwtUtil;

  @PostMapping(value = "/home")
  public ResponseEntity<?> home() {
    return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication().toString());
  }

  @PostMapping(value = "/authenticate")
  public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequest authenticateRequest) throws Exception {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(),
          authenticateRequest.getPassword()));

    } catch (BadCredentialsException e) {
      throw new Exception("Invlid authentication");
    }
    final UserDetails userDetails = appUserDetailService.loadUserByUsername(authenticateRequest.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails);
    return ResponseEntity.ok(new AuthenticateResponse(jwt));
  }
}
