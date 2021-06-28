package com.example.limousine.controllers.home;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @GetMapping(value = "/")
  public void index() {
    // return ResponseEntity.ok().body("index");
  }

  @GetMapping(value = "/home")
  public ResponseEntity<Map<String, Object>> home() {
    final Map<String, Object> res = new HashMap<String, Object>();
    res.put("key", "value");
    return ResponseEntity.ok().body(res);
  }

  @GetMapping(value = "/admin")
  public ResponseEntity<Map<String, Object>> admin() {
    final Map<String, Object> res = new HashMap<String, Object>();
    res.put("key", "admin");
    return ResponseEntity.ok().body(res);
  }

}
