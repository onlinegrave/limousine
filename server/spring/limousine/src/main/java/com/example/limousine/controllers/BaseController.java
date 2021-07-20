package com.example.limousine.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dambarpun
 */
public abstract class BaseController {
  @Autowired
  protected Gson gson;
}
