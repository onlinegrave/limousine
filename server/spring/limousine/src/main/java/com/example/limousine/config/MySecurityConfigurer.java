package com.example.limousine.config;

import com.example.limousine.services.MyUserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfigurer extends WebSecurityConfigurerAdapter {

  @Autowired
  private MyUserDetailService userDetailService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/users").hasAnyRole("ADMIN",
    // "USER")
    // .antMatchers("/").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
    // .and().logout().permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // auth.userDetailsService(userDetailService);
    auth.inMemoryAuthentication().withUser("foo").password("foo").roles("USER");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}
