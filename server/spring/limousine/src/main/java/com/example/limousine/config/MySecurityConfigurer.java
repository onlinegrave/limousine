package com.example.limousine.config;

import com.example.limousine.services.AppUserDetailService;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class MySecurityConfigurer extends WebSecurityConfigurerAdapter {
  private AppUserDetailService appUserDetailService;

  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(appUserDetailService);
  }
}
